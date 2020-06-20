package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Order;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.Store;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.entity.response.OrderResponse;
import com.android.bytemarket.entity.response.ProductResponse;
import com.android.bytemarket.entity.response.StoreResponse;
import com.android.bytemarket.service.OrderService;
import com.android.bytemarket.service.ProductService;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  前端控制器
 * @author lequal
 * @since 2019-11-30
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    /**
     * 渲染前端商品详情页面：detail.html
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/html/{id}")
    public String getHtml(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "detail";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ServerResponse del(@PathVariable("id") Integer id){
        productService.removeById(id);
        return ServerResponse.ofSuccess("删除成功");
    }

    /**
     * 根据id获取商品的详情信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ServerResponse get(@PathVariable("id") Integer id){
        Product product = productService.getById(id);
        ProductResponse productResponse = getProductResponse(product);
        return ServerResponse.ofSuccess(productResponse);
    }

    /**
     * 获取并封装商品信息返回
     * @param product
     * @return
     */
    private ProductResponse getProductResponse(Product product) {
        ProductResponse productResponse = new ModelMapper().map(product, ProductResponse.class);
        User u = userService.getById(productResponse.getUserId());
        if (u != null) {
            ProductResponse.User pu = new ProductResponse.User();
            pu.setId(u.getId());
            pu.setName(u.getNickName());
            pu.setAvatar(u.getAvatar());
            productResponse.setUser(pu);
        }
        return productResponse;
    }

    /**
     * 分类显示
     * @param page
     * @param limit
     * @param cid
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ServerResponse list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit,
                               @RequestParam(required = false)Integer cid){
        Page<Product> bannerPage = new Page<>(page,limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("update_time");
        wrapper.eq("status",0);
        wrapper.eq(cid!=null,"category_id",cid);
        IPage<Product> pages = productService.page(bannerPage, wrapper);
        return ServerResponse.ofSuccess(packageResponse(pages.getRecords()));
    }

    /**
     * 搜索商品
     * @param key
     * @param price
     * @param time
     * @param school
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/search")
    @ResponseBody
    public ServerResponse search(@RequestParam(required = false) String key,@RequestParam(required = false) String price,
                                 @RequestParam(required = false) String time, @RequestParam(required = false) Integer school,
                                 @RequestParam(required = false) Integer uid, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer limit){

        Page<Product> bannerPage = new Page<>(page,limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();

        //搜索关键字
        wrapper.like(!StringUtils.isEmpty(key),"title",key);
        //根据价格降序
        wrapper.orderBy(!StringUtils.isEmpty(price),"asc".equals(price),"price");
        //根据创建时间倒序
        wrapper.orderBy(!StringUtils.isEmpty(time),"asc".equals(time),"update_time");
        wrapper.eq(school!=null,"school_id",school);
        wrapper.eq(uid!=null,"user_id",uid);
        wrapper.eq("status",0);
        IPage<Product> pages = productService.page(bannerPage,wrapper);
        return ServerResponse.ofSuccess(packageResponse(pages.getRecords()));
    }

    /**
     * 封装商品数据
     * @param products
     * @return
     */
    private List<ProductResponse> packageResponse(List<Product> products){
        List<ProductResponse> list = new LinkedList<>();
        products.forEach(v->{
            ProductResponse productResponse = getProductResponse(v);
            list.add(productResponse);
        });
        return list;
    }

    /**
     * 发布商品
     * @param product
     * @return
     */
    @PostMapping("/")
    @ResponseBody
    public ServerResponse insert(@RequestBody Product product){
        product.setUpdateTime(LocalDateTime.now());
        boolean b = productService.saveOrUpdate(product);
        if (b){
            return ServerResponse.ofSuccess("操作成功",getProductResponse(product));
        }
        return ServerResponse.ofError("操作失败",null);
    }

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("/createorder")
    @ResponseBody
    public ServerResponse createOrder(@RequestBody Order order) {
        //这里只是逻辑实现 理论上在事务中执行 !

        //判断商品是否可买
        Integer productId = order.getProductId();
        Product product = productService.getById(productId);
        if (product==null || product.getStatus()!=0){
            return ServerResponse.ofError("商品不可买!");
        }

        // 此处回执单号需要另外处理
        int result = orderService.createOrder(order.getUserId(), order.getProductId(), order.getTotalMoney(),
                order.getRemarks(), order.getPayFrom(), order.getUserAddress(), order.getUserName(), order.getUserPhone(),
                order.getTradeNo());

        //设置商品状态
        product.setStatus(1);
        product.setBuyerId(order.getUserId());
        productService.saveOrUpdate(product);

        if (result > 0) {
            return ServerResponse.ofSuccess("下单成功！");
        } else {
            return ServerResponse.ofError("下单失败！");
        }
    }

    @GetMapping("/status")
    @ResponseBody
    public ServerResponse status(Integer uid){
        //发布中
        int publishCount = productService.count(new QueryWrapper<Product>().eq("user_id", uid).eq("status",0));
        //已卖出
        int hasSoldCount = productService.count(new QueryWrapper<Product>().eq("user_id", uid).eq("status",1));
        //已买到
        int hasGetCount = productService.count(new QueryWrapper<Product>().eq("buyer_id",uid));

        Map<String,Integer> map = new HashMap<>();
        map.put("pc",publishCount);
        map.put("sc",hasSoldCount);
        map.put("gc",hasGetCount);
        return ServerResponse.ofSuccess(map);
    }

    /*
        根据状态获取商品列表
     */
    @GetMapping("/listByStatus")
    @ResponseBody
    public ServerResponse listByStatus(Integer status,Integer uid){
        List<Product> list = productService.list(new QueryWrapper<Product>().eq("user_id", uid).eq("status", status));
        List<Store> stores = new ArrayList<>();
        list.forEach(v->{
            Store store = new Store();
            store.setId(0);
            store.setProductId(v.getId());
            stores.add(store);
        });

        return getStoreList(stores);
    }

    private ServerResponse getStoreList(List<Store> list) {
        List<StoreResponse> responses = new ArrayList<>();
        list.forEach(v -> {
            Product product = productService.getById(v.getProductId());
            ProductResponse productResponse = getProductResponse(product);
            StoreResponse storeResponse = new StoreResponse();
            storeResponse.setGoods(productResponse);
            storeResponse.setId(v.getId());
            responses.add(storeResponse);
        });
        return ServerResponse.ofSuccess(responses);
    }

    /*
        已卖出
     */
    @GetMapping("/list/{type}")
    @ResponseBody
    public ServerResponse listSoldOrder(@PathVariable String type,Integer uid){
        List<Order> orders;
        if ("got".equals(type)){
            orders = orderService.list(new QueryWrapper<Order>().eq("user_id",uid));
        }else {
            orders = orderService.list(new QueryWrapper<Order>().eq("owner_id",uid));
        }
        List<OrderResponse> ret = new ArrayList<>();
        orders.forEach(v -> {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(v.getId());
            orderResponse.setOrderNum(v.getOrderNum());
            orderResponse.setProductResponse(getProductResponse(productService.getById(v.getProductId())));
            orderResponse.setUserName(v.getUserName());
            orderResponse.setUserPhone(v.getUserPhone());
            orderResponse.setUserAddress(v.getUserAddress());
            String status;
            if (v.getStatus()==0){
                status = "交易进行中";
            }else{
                status = "已完成";
            }
            orderResponse.setStatus(status);
            ret.add(orderResponse);
        });

        return ServerResponse.ofSuccess(ret);
    }

}

