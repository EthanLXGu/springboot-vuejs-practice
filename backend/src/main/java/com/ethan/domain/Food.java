package com.ethan.domain;

/**
 * Created by Ethan L X Gu on 01/04/2017.
 */
public class Food {

    private Long productId;

    private String productName;

    private Double productPrice;

    public Food() {

    }

    public Food(Long productId, String productName, Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

    @Override
    public String toString() {
        return "Product{ " +
                "productId= " + productId +
                " productName= " + productName +
                " productPrice= " + productPrice +
                " }";
    }
}
