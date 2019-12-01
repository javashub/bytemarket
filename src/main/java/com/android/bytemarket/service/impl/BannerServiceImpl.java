package com.android.bytemarket.service.impl;

import com.android.bytemarket.dao.BannerDao;
import com.android.bytemarket.entity.Banner;
import com.android.bytemarket.service.BannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerDao, Banner> implements BannerService{

}
