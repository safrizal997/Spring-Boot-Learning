package com.rizal.belajarspring.service.impl;

import com.rizal.belajarspring.entity.CategoriesEntity;
import com.rizal.belajarspring.repository.CategoriesEntityRepository;
import com.rizal.belajarspring.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesEntityRepository categoriesEntityRepository;



    @Override
    public List<CategoriesEntity> getCategories() {
        return categoriesEntityRepository.findAll();
    }

    @Override
    public CategoriesEntity addCategory(CategoriesEntity categoriesEntity) {
        return categoriesEntityRepository.save(categoriesEntity);
    }

    @Override
    public CategoriesEntity editCategory(String category_Id, CategoriesEntity categoriesEntity) {
        Optional<CategoriesEntity> categoriesFromDB = categoriesEntityRepository.findById(category_Id);

        if (categoriesFromDB.isPresent()){
            CategoriesEntity categories = categoriesFromDB.get();
            categories.setCategory_Id(categoriesEntity.getCategory_Id());
            categories.setCategory_name(categoriesEntity.getCategory_name());
            return categoriesEntityRepository.save(categories);
        }
        return null;
    }

    @Override
    public Integer deleteCategories(String category_Id) {
        Optional<CategoriesEntity> categoriesFromDB = categoriesEntityRepository
                .findById(category_Id);

        if (categoriesFromDB.isPresent()){
            categoriesEntityRepository.deleteById(category_Id);

            return 1;
        }

        return 0;
    }
}
