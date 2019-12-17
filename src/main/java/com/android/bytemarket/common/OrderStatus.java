package com.android.bytemarket.common;

/**
 * @author: 15760
 * @Date: 2019/12/16
 * @Descripe:
 */
public class OrderStatus {

    // 支付宝支付
    public static final int WECHAT = 1;

    // 微信支付
    public static final int ALIPAY = 0;

    // 已支付
    public static final int PAYED = 1;

    // 待支付
    public static final int WAITING_TO_PAY = 0;

    // 订单有效
    public static final int ABLE = 1;

    // 订单无效
    public static final int DISABLE = 0;
}
