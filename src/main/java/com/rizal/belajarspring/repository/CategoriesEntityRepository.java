package com.rizal.belajarspring.repository;

import com.rizal.belajarspring.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesEntityRepository extends JpaRepository <CategoriesEntity, String> {

}
