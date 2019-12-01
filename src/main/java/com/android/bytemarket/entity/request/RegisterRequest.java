package com.android.bytemarket.entity.request;

import lombok.Data;

import java.util.Date;

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

    private String avatar;//头像的地址

    private Date createTime;

}
