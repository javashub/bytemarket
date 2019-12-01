package com.android.bytemarket.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    /**
     * 响应状态码
     */
    SUCCESS(0,"success"),
    ERROR(1,"error");

    private int code;
    private String desc;
}
