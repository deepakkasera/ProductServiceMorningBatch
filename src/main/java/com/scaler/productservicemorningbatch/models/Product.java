package com.scaler.productservicemorningbatch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
//    @Id
//    private long id; -> Moved to BaseModel class.
    private String title;
    private double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category; // EAGER FETCH
    private String description;
    private String image;
}

/*
  1     ->      1
Product ---- Category  ===> M : 1
  M      <-     1
-------------------------
  M             1


  1     ->     M
Movie ------- Actor ====> M:M
  M      <-    1
-----------------------
   M           M

*/


