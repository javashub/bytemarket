package com.android.bytemarket.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: 15760
 * @Date: 2019/11/28
 * @Descripe:
 */
public class Product {
    private Integer productId;//商品id
    private String title;//商品标题
    private BigDecimal price;//商品价格
    private String description;//商品描述
    private Integer owner;//商品发布者
    private Integer issell;//是否卖出，默认0表示未卖出，1表示已卖出
    private Integer buyer;//购买者
    private List<String> productPic;//商品图片，多张图片的地址

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", ownerId=" + owner +
                ", issell=" + issell +
                ", buyerId=" + buyer +
                ", productPic=" + productPic +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getIssell() {
        return issell;
    }

    public void setIssell(Integer issell) {
        this.issell = issell;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public List<String> getProductPic() {
        return productPic;
    }

    public void setProductPic(List<String> productPic) {
        this.productPic = productPic;
    }
}
