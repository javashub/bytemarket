package com.android.bytemarket.entity;

import lombok.Data;

/**
 * @author: 15760
 * @Date: 2019/12/17
 * @Descripe: 购物车
 */
@Data
public class Cart {

    private Integer id;

    // 商品id
    private Integer productId;

    // 加入购用户id
    private Integer userId;

    // 发布者id
    private Integer sellerId;


}
