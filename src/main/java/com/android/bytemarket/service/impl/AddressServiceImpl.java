package com.android.bytemarket.service.impl;

import com.android.bytemarket.dao.AddressDao;
import com.android.bytemarket.entity.Address;
import com.android.bytemarket.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {
}
