package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Order;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.entity.response.ProductResponse;
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
import java.util.LinkedList;
import java.util.List;

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
     * 根据id查找商品
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
     * 商品详情页面，返回并渲染前端页面：detail.html
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/html/{id}")
    public String getHtml(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "detail";
    }

    /**
     *
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
                                 @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer limit){

        Page<Product> bannerPage = new Page<>(page,limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        //搜索关键字
        wrapper.like(!StringUtils.isEmpty(key),"title",key);
        //根据价格降序
        wrapper.orderBy(!StringUtils.isEmpty(price),"asc".equals(price),"price");
        //根据创建时间倒序
        wrapper.orderBy(!StringUtils.isEmpty(time),"asc".equals(time),"update_time");
        wrapper.eq(school!=null,"school_id",school);
        IPage<Product> pages = productService.page(bannerPage,wrapper);
        return ServerResponse.ofSuccess(packageResponse(pages.getRecords()));
    }

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

        // 此处回执单号需要另外处理
        int result = orderService.createOrder(order.getUserId(), order.getProductId(), order.getTotalMoney(),
                order.getRemarks(), order.getPayFrom(), order.getUserAddress(), order.getUserName(), order.getUserPhone(),
                order.getTradeNo());

        if (result > 0) {
            return ServerResponse.ofSuccess("下单成功！");
        } else {
            return ServerResponse.ofError("下单失败！");
        }
    }
}

