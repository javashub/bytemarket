package com.android.bytemarket.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: 15760
 * @Date: 2019/12/17
 * @Descripe: 购物车
 */
@Data
@TableName("tb_cart")
public class Cart<T> {

    private Integer id;

    // 商品id
    private Integer productId;

    // 加入购用户id
    private Integer userId;

    // 发布者id
    private Integer sellerId;

    // 商品数量
    private Integer num;

    // 商品单价
    private BigDecimal price;

    // 商品总价
    private BigDecimal totalPrice;

}
