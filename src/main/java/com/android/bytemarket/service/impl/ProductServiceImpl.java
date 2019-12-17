package com.android.bytemarket.service.impl;


import com.android.bytemarket.dao.ProdutDao;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.dao.ProductDao;
import com.android.bytemarket.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lequal
 * @since 2019-11-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

    @Autowired
    private ProdutDao produtDao;

    @Override
    public List<Product> showProductsByDate() {
        return null;
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        // 根据关键字模糊查询商品
        QueryWrapper<Product> wrapper = new QueryWrapper<Product>().like("title", keyword);
        return produtDao.selectList(wrapper);
    }

}
