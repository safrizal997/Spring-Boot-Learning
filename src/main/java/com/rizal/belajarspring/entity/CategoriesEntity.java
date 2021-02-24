package com.rizal.belajarspring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories_tbl")
public class CategoriesEntity {

    @Id
    @Column (name = "category_Id", nullable = false)
    private String category_Id;
    @Column (name = "category_name", nullable = false)
    private String category_name;

    public CategoriesEntity() {
    }

    public CategoriesEntity(String category_Id, String category_name) {
        this.category_Id = category_Id;
        this.category_name = category_name;
    }


    public String getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(String category_Id) {
        this.category_Id = category_Id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
