package com.rizal.belajarspring.service.impl;

import com.rizal.belajarspring.entity.CategoriesEntity;
import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.ProductRequest;
import com.rizal.belajarspring.repository.CategoriesEntityRepository;
import com.rizal.belajarspring.repository.ProductEntityRepository;
import com.rizal.belajarspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductEntityRepository productEntityRepository;
    @Autowired
    CategoriesEntityRepository categoriesEntityRepository;


    @Override
    public Page<ProductEntity> getAllProductPagination(Pageable pageable) {
        return productEntityRepository.findAll(pageable);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productEntityRepository.findAll();
    }

    @Override
    public ProductEntity getProduct(String productId) {
        return productEntityRepository.findById(productId)
                .orElse(null);
    }

    @Override
    public ProductEntity addProduct(ProductRequest productRequest) {

        ProductEntity productToSave = new ProductEntity();
        productToSave.setProductName(productRequest.getProductName());
        productToSave.setProductPrice(productRequest.getProductPrice());
        productToSave.setProductQuantity(productRequest.getProductQuantity());

        String categoryId = "P";
        if (!productRequest.getProductCategory().equals("")) {
            categoryId = productRequest.getProductCategory();
        }

        Optional<CategoriesEntity> categoryProduct = categoriesEntityRepository
                .findById(categoryId);

        /*
        * if(categoryProduct.isPresent()){
        *   productToSave.setProductCategory(categoryProduct.get());
        * }
        */

        categoryProduct.ifPresent(productToSave::setProductCategory);

         return productEntityRepository.save(productToSave);
    }

    @Override
    public ProductEntity editProduct(String productId, ProductRequest productRequest) {
        Optional<ProductEntity> productFromDB = productEntityRepository
                .findById(productId);

        if (productFromDB.isPresent()) {
            ProductEntity product = productFromDB.get();
            product.setProductName(productRequest.getProductName());
            product.setProductPrice(productRequest.getProductPrice());
            product.setProductQuantity(productRequest.getProductQuantity());

            return productEntityRepository.save(product);
        }

        return null;
    }

    @Override
    public Integer deleteProduct(String productId) {
        Optional<ProductEntity> productFromDB = productEntityRepository
                .findById(productId);

        if (productFromDB.isPresent()) {
            productEntityRepository.deleteById(productId);

            return 1;
        }

        return 0;
    }
}
