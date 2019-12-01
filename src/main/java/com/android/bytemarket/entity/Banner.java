package com.android.bytemarket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: 15760
 * @Date: 2019/12/1
 * @Descripe:
 */
@Data
@TableName("tb_banner")
public class Banner {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String url;

    private String tips;

}
