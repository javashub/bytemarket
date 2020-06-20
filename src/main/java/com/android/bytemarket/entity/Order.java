package com.android.bytemarket.entity;

<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.IdType;
>>>>>>> 298a402bc66a7cd9396a8eb90da6db72dae04e07
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: 15760
 * @Date: 2019/12/16
 * @Descripe: 订单实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_order")
//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class Order {

    // 订单id
<<<<<<< HEAD
    @TableId("id")
=======
    @TableId(value = "id", type = IdType.AUTO)
>>>>>>> 298a402bc66a7cd9396a8eb90da6db72dae04e07
    private Integer id;

    // 订单号码
    private String orderNum;

    // 下单用户id
    private Integer userId;

    private Integer ownerId;

    // 商品id
    private Integer productId;

    // 总金额
    private BigDecimal totalMoney;

    // 支付类型：0为支付宝，1为微信
    private Integer payType;

    // 订单状态：0为无效，1为有效
    private Integer status;

    // 是否支付
    private Integer isPay;

    // 备注信息
    private String remarks;

    // 支付来源
    private Integer payFrom;

    // 收货地址
    private String userAddress;

    // 联系电话
    private String userPhone;

    // 联系人姓名
    private String userName;

    // 支付回执单号
    private String tradeNo;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
