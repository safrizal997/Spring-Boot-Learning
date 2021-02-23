package com.rizal.belajarspring.service;

import com.rizal.belajarspring.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    ProductEntity getProduct(String productId);

    ProductEntity addProduct(ProductEntity productEntity);

    ProductEntity editProduct(String productId, ProductEntity productEntity);

    Integer deleteProduct(String productId);

}
