package com.rizal.belajarspring.service.impl;

import com.rizal.belajarspring.entity.CategoriesEntity;
import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.ProductRequest;
import com.rizal.belajarspring.repository.CategoriesEntityRepository;
import com.rizal.belajarspring.repository.ProductEntityRepository;
import com.rizal.belajarspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductEntity> getAll() {
        return productEntityRepository.findAll();
    }

    @Override
    public ProductEntity getProduct(String productId) {
        return productEntityRepository.findById(productId)
                .orElse(null);
    }

    @Override
    public ProductEntity addProduct(ProductRequest productEntity) {

        ProductEntity productToSave = new ProductEntity();
        productToSave.setProductName(productEntity.getProductName());
        productToSave.setProductPrice(productEntity.getProductPrice());
        productToSave.setProductQuantity(productEntity.getProductQuantity());

        String categoryId = "P";
        if (!productEntity.getProductCategory().equals("")) {
            categoryId = productEntity.getProductCategory();
        }

        Optional<CategoriesEntity> categoryProduct = categoriesEntityRepository
                .findById(categoryId);

        categoryProduct.ifPresent(productToSave::setProductCategory);

         return productEntityRepository.save(productToSave);
    }

    @Override
    public ProductEntity editProduct(String productId, ProductRequest productEntity) {
        Optional<ProductEntity> productFromDB = productEntityRepository
                .findById(productId);

        if (productFromDB.isPresent()) {
            ProductEntity product = productFromDB.get();
            product.setProductName(productEntity.getProductName());
            product.setProductPrice(productEntity.getProductPrice());
            product.setProductQuantity(productEntity.getProductQuantity());

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
