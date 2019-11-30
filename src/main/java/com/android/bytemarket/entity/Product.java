package com.android.bytemarket.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lequal
 * @since 2019-11-30
 */
@Data
@TableName("tb_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID=1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 发布者
     */
    private Integer owner;

    /**
     * 默认0表示未卖出，1表示已经卖出
     */
    private Integer issell;

    /**
     * 购买者
     */
    private Integer buyer;

    /**
     * 商品图片
     */
    @TableField("productPic")
    private String productPic;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
        "id=" + id +
        ", title=" + title +
        ", price=" + price +
        ", description=" + description +
        ", owner=" + owner +
        ", issell=" + issell +
        ", buyer=" + buyer +
        ", productPic=" + productPic +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}
