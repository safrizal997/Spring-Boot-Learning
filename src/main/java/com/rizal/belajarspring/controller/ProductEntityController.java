package com.rizal.belajarspring.controller;


import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.ProductRequest;
import com.rizal.belajarspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductEntityController {

    @Autowired
    private ProductService productService;

    @GetMapping("/page")
    public Page<ProductEntity> getAllProductPagination(@RequestParam(name = "page", defaultValue = "0") int page,
                                                       @RequestParam(name = "size", defaultValue = "2") int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return productService.getAllProductPagination(pageRequest);
    }

    @GetMapping
    public List<ProductEntity> getAllProduct() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ProductEntity getProduct(@PathVariable("productId") String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductRequest productEntity) {
        return productService.addProduct(productEntity);
    }

    @PutMapping("/{productId}")
    public ProductEntity editProduct(@PathVariable("productId") String productId, @RequestBody ProductRequest productEntity) {
        return productService.editProduct(productId, productEntity);
    }

    @DeleteMapping("/{productId}")
    public Integer deleteProduct(@PathVariable("productId") String productId) {
        return productService.deleteProduct(productId);
    }

}
