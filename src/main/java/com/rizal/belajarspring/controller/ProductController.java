package com.rizal.belajarspring.controller;


import com.rizal.belajarspring.model.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    List<Product> products = new ArrayList<>();

    public ProductController(List<Product> products) {
        List<Product> productList = Arrays.asList(
                new Product( "Rexona man",12000.00, 2, 1),
                new Product( "Rexona women",12000.00, 2, 2)
        );
        this.products.addAll(productList);
    }

    @GetMapping
    public List<Product> getAllProduct(){

        return products;
    }

    @GetMapping("/{productId}")
    public List<Product> getProduct(@PathVariable ("productId") String productId) {
        return products.stream().filter(product -> product.getProductId().equals(productId) )
                .collect(Collectors.toList());
    }
    @PostMapping
    public List<Product> insertProduct (@RequestBody Product product){
         products.add(product);
         return products;
    }

}
