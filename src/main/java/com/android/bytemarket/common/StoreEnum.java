package com.android.bytemarket.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum StoreEnum {

    COLLECT(1000,"收藏"),
    HISTORY(1001,"历史");

    // 响应状态码
    private int code;

    // 提示信息
    private String desc;

}
