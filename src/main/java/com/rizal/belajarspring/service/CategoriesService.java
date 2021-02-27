package com.rizal.belajarspring.service;

import com.rizal.belajarspring.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesService {

    List<CategoriesEntity> getCategories ();

    CategoriesEntity addCategory(CategoriesEntity categoriesEntity);

    CategoriesEntity editCategory(String category_Id, CategoriesEntity categoriesEntity);

    Integer deleteCategory(String category_Id);
}
