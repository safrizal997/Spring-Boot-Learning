package com.rizal.belajarspring.service;

import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.ProductRequest;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    ProductEntity getProduct(String productId);

    ProductEntity addProduct(ProductRequest productEntity);

    ProductEntity editProduct(String productId, ProductRequest productEntity);

    Integer deleteProduct(String productId);

}
