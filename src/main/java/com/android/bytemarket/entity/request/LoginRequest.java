package com.android.bytemarket.entity.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;

    private Integer id;
}
