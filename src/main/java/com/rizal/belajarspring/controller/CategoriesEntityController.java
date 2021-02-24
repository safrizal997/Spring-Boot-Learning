package com.rizal.belajarspring.controller;

import com.rizal.belajarspring.entity.CategoriesEntity;
import com.rizal.belajarspring.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesEntityController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    List<CategoriesEntity> getCategories() {
        return categoriesService.getCategories();
    }

    @PostMapping
    CategoriesEntity addCategory(@RequestBody CategoriesEntity categoriesEntity) {
        return categoriesService.addCategory(categoriesEntity);
    }

    @PutMapping("/{category_Id}")
    CategoriesEntity editCategory(@PathVariable("category_Id") String category_Id, @RequestBody CategoriesEntity categoriesEntity) {
        return categoriesService.editCategory(category_Id, categoriesEntity);
    }

    @DeleteMapping("/{category_Id}")
    Integer deleteCategories(@PathVariable("category_Id") String category_Id) {
        return categoriesService.deleteCategories(category_Id);
    }

}
