package com.android.bytemarket.entity.request;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: 15760
 * @Date: 2019/12/1
 * @Descripe:
 */
@Data
public class RegisterRequest {

    private String nickName;

    private String username;

    private String password;

    private Integer schoolId;

    private String description;

    // 头像的地址
    private String avatar;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
