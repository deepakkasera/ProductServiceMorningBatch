package com.scaler.productservicemorningbatch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
//    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
//    private List<Product> products;
    private String title;
}
