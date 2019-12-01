package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Category;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.service.ProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lequal
 * @since 2019-11-30
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ServerResponse list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit){
        Page<Product> bannerPage = new Page<>(page,limit);
        IPage<Product> pages = productService.page(bannerPage);
        return ServerResponse.ofSuccess(pages);
    }

    @GetMapping("/search")
    public ServerResponse search(@RequestParam(required = false) String key,@RequestParam(required = false) String price,@RequestParam(required = false) String time,@RequestParam(required = false) String desc,@RequestParam(required = false) Integer school,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")Integer limit){
        Page<Product> bannerPage = new Page<>(page,limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(key),"title",key);
        wrapper.orderBy(!StringUtils.isEmpty(price),StringUtils.isEmpty(desc),"price");
        wrapper.orderBy(!StringUtils.isEmpty(time),StringUtils.isEmpty(desc),"time");
        wrapper.eq(school==null,"school_id",school);
        IPage<Product> pages = productService.page(bannerPage,wrapper);
        return ServerResponse.ofSuccess(pages);
    }
}

