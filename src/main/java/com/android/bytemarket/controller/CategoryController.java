package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Banner;
import com.android.bytemarket.entity.Category;
import com.android.bytemarket.service.CategoryService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据类别获取商品列表，每次显示10条记录
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public ServerResponse list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit){
        Page<Category> bannerPage = new Page<>(page,limit);
        IPage<Category> pages = categoryService.page(bannerPage);
        return ServerResponse.ofSuccess(pages.getRecords());
    }
}

