package com.android.bytemarket.controller;

import com.android.bytemarket.common.ServerResponse;
import com.android.bytemarket.entity.Banner;
import com.android.bytemarket.service.BannerService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/list")
    public ServerResponse list(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer limit){
        Page<Banner> bannerPage = new Page<>(page,limit);
        IPage<Banner> pages = bannerService.page(bannerPage);
        return ServerResponse.ofSuccess(pages.getRecords());
    }

}
