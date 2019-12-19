package com.android.bytemarket.entity.request;

import lombok.Data;

@Data
public class UpdateRequest {

    private String id;

    private String nickName;

    private Integer schoolId;

    private String description;

    private String password;

    private String avatar;
}
