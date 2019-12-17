package com.android.bytemarket.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 15760
 * @Date: 2019/12/16
 * @Descripe: 用户生成订单号的工具类,8位日期 + 5位随机数
 */
public class OrderUtils {

    public static String createNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str1 = sdf.format(new Date());
        String str2 = String.valueOf((int)((Math.random() * 9 +1 ) * 100000));
        return str1 + str2;
    }
}
