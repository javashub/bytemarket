package com.android.bytemarket.controller;


import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Product;
import com.android.bytemarket.entity.School;
import com.android.bytemarket.entity.response.SchoolResponse;
import com.android.bytemarket.service.ProductService;
import com.android.bytemarket.service.SchoolService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 *  前端控制器
 * @author lequal
 * @since 2019-11-30
 */
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ServerResponse list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit){
        Page<School> p = new Page<>(page,limit);
        IPage<School> schoolPage = schoolService.page(p);
        return ServerResponse.ofSuccess(pac(schoolPage.getRecords()));
    }

    private List<SchoolResponse> pac(List<School> list){
        List<SchoolResponse> ret = new LinkedList<>();
        list.forEach(v -> {
            SchoolResponse schoolResponse = new ModelMapper().map(v,SchoolResponse.class);
            int count = productService.count(new QueryWrapper<Product>().eq("school_id", v.getId()));
            schoolResponse.setNumber(String.format("一共有%d件商品正在出售",count));
            ret.add(schoolResponse);
        });
        return ret;
    }
}

