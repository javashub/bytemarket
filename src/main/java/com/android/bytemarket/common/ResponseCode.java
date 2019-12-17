package com.android.bytemarket.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 响应状态
 */

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(0,"success"),
    ERROR(1,"error");

    // 响应状态码
    private int code;

    // 提示信息
    private String desc;
}
