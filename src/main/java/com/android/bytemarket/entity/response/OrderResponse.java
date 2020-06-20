package com.android.bytemarket.entity.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Integer id;

    private ProductResponse productResponse;

    //状态描述
    private String status;

    private String orderNum;

    private String userAddress;

    private String userPhone;

    private String userName;

}
