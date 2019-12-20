package com.android.bytemarket.service.impl;

import com.android.bytemarket.common.OrderStatus;
import com.android.bytemarket.common.OrderUtils;
import com.android.bytemarket.dao.OrderDao;
import com.android.bytemarket.dao.ProdutDao;
import com.android.bytemarket.entity.Order;
import com.android.bytemarket.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: 15760
 * @Date: 2019/12/16
 * @Descripe:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int createOrder(Integer userId, Integer productId, BigDecimal total, String remarks,
                            Integer payFrom, String address, String username, String phone, String tradeNo) {
        // 调用订单初始化方法
        return initOrder(userId, productId, total, remarks, payFrom, address, username, phone, tradeNo);
    }

    // 初始化订单数据

    public int initOrder(Integer userId, Integer productId, BigDecimal total, String remarks,
                           Integer payFrom, String address, String username, String phone, String tradeNo) {

        Order order = new Order();
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        order.setUserId(userId);
        // 生成订单号，8位日期+5位随机数
        order.setOrderNum(OrderUtils.createNo());
        order.setProductId(productId);
        // 创建时间与更新时间一致从当前系统时间获得
        order.setCreateTime(currentTime);
        order.setUpdateTime(currentTime);

        order.setTotalMoney(total);
        // 支付状态初始化时设置为待支付
        order.setIsPay(OrderStatus.WAITING_TO_PAY);
        // 订单状态初始设置为有效
        order.setStatus(OrderStatus.ABLE);
        //支付方式，先默认支付宝吧,后面根据其它条件修改
        order.setPayType(OrderStatus.ALIPAY);
        order.setPayFrom(payFrom);
        order.setRemarks(remarks);
        order.setUserAddress(address);
        order.setUserName(username);
        order.setUserPhone(phone);
        order.setTradeNo(tradeNo);

        // 写入数据库
        return orderDao.insert(order);
    }
}
