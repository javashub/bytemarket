package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.common.StoreEnum;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.Store;
import com.android.bytemarket.entity.User;
import com.android.bytemarket.entity.response.ProductResponse;
import com.android.bytemarket.entity.response.StoreResponse;
import com.android.bytemarket.service.ProductService;
import com.android.bytemarket.service.StoreService;
import com.android.bytemarket.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  前端控制器
 * @author lequal
 * @since 2019-11-30
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

<<<<<<< HEAD
    /**
     * 收藏商品
     * @param store
     * @return
     */
=======
    @DeleteMapping("/{id}")
    public ServerResponse delete(@PathVariable("id") Integer id){
        //无校验
        boolean b = storeService.removeById(id);
        if (b) {
            return ServerResponse.ofSuccess("删除成功");
        }
        else {
            return ServerResponse.ofError("删除失败");
        }
    }

>>>>>>> 298a402bc66a7cd9396a8eb90da6db72dae04e07
    @PostMapping("/collect")
    public ServerResponse collect(@RequestBody Store store){
        store.setType(StoreEnum.COLLECT.getCode());
        int count = storeService.count(new QueryWrapper<Store>().eq("user_id", store.getUserId()).eq("product_id", store.getProductId()).eq("type",StoreEnum.COLLECT.getCode()));
        if (count>0){
            return ServerResponse.ofError("您已经收藏过了");
        }
        return saveStore(store);
    }

    /**
     * 显示历史记录
     * @param store
     * @return
     */
    @PostMapping("/history")
    public ServerResponse history(@RequestBody Store store){
        store.setType(StoreEnum.HISTORY.getCode());
        Store one = storeService.getOne(new QueryWrapper<Store>().eq("user_id", store.getUserId()).eq("product_id", store.getProductId()).eq("type",StoreEnum.HISTORY.getCode()));
        if(one!=null){
            return saveStore(one);
        }
        return saveStore(store);
    }

    private ServerResponse saveStore(@RequestBody Store store) {
        boolean b = storeService.saveOrUpdate(store);
        if (b) {
            return ServerResponse.ofSuccess("操作成功");
        } else {
            return ServerResponse.ofError("操作失败");
        }
    }

    /**
     * 根据id获取用户收藏
     */
    @GetMapping("/collect")
    public ServerResponse listCollect(Integer uid){
        List<Store> list = storeService.list(new QueryWrapper<Store>().eq("user_id", uid).eq("type", StoreEnum.COLLECT.getCode()).orderByDesc("create_time"));
        return getStoreList(list);
    }

    /**
     * 根据id获取用户收藏
     */
    @GetMapping("/history")
    public ServerResponse listHistory(Integer uid){
        List<Store> list = storeService.list(new QueryWrapper<Store>().eq("user_id", uid).eq("type", StoreEnum.HISTORY.getCode()).orderByDesc("create_time"));
        return getStoreList(list);
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



    private List<ProductResponse> packageResponse(List<Product> products){
        List<ProductResponse> list = new LinkedList<>();
        products.forEach(v->{
            ProductResponse productResponse = getProductResponse(v);
            list.add(productResponse);
        });
        return list;
    }


    // 设置商品的一些相关信息
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

}

