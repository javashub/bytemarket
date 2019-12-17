package com.android.bytemarket.service;

import com.android.bytemarket.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lequal
 * @since 2019-11-30
 */
public interface ProductService extends IService<Product> {

    //首页显示所有商品
    List<Product> showProductsByDate();

    //用户搜索商品
    List<Product> searchProduct(String keyword);


}
