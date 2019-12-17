package com.android.bytemarket.service;

import com.android.bytemarket.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * @author: 15760
 * @Date: 2019/12/16
 * @Descripe:
 */
public interface OrderService extends IService<Order> {

    // 创建订单
    int createOrder(Integer userId, Integer productId, BigDecimal total, String remarks, Integer payFrom, String address, String username, String phone, String tradeNo);

}
