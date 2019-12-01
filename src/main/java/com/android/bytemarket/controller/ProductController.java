package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
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
 *  前端控制器
 * @author lequal
 * @since 2019-11-30
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ServerResponse list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit,@RequestParam(required = false)Integer cid){
        Page<Product> bannerPage = new Page<>(page,limit);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("update_time");
        wrapper.eq(cid!=null,"category_id",cid);
        IPage<Product> pages = productService.page(bannerPage, wrapper);
        return ServerResponse.ofSuccess(pages);
    }

    @GetMapping("/search")
    public ServerResponse search(@RequestParam(required = false) String key,@RequestParam(required = false) String price,
                                 @RequestParam(required = false) String time,
                                 @RequestParam(required = false) Integer school,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")Integer limit){
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
        return ServerResponse.ofSuccess(pages);
    }
}

