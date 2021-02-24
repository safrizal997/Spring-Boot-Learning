package com.rizal.belajarspring.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tbl_product")
public class ProductEntity {

    @Id
    @Column(name = "product_id", nullable = false)
    private String productId = UUID.randomUUID().toString();
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_price", nullable = false)
    private Double productPrice;
    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity = 0;

    @OneToOne
    @JoinColumn(name = "product_category")
    private CategoriesEntity productCategory ;

    public ProductEntity() {
    }

    public ProductEntity(String productId, String productName, Double productPrice, Integer productQuantity, CategoriesEntity productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CategoriesEntity getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoriesEntity productCategory) {
        this.productCategory = productCategory;
    }
}
