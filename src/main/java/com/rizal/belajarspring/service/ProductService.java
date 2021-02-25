package com.rizal.belajarspring.service;

import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<ProductEntity> getAllProductPagination(Pageable pageable);

    List<ProductEntity> getAll();

    ProductEntity getProduct(String productId);

    ProductEntity addProduct(ProductRequest productEntity);

    ProductEntity editProduct(String productId, ProductRequest productEntity);

    Integer deleteProduct(String productId);

}
