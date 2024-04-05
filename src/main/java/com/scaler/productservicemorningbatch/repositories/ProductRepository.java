package com.scaler.productservicemorningbatch.repositories;

import com.scaler.productservicemorningbatch.models.Category;
import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
    extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Optional<Product> findByTitleAndDescription(String title,
                                                String description);

    List<Product> findByTitleContaining(String word);
    //Using like operator.

    List<Product> findTopThreeByTitle(String title); // limit the result by 3

    Optional<Product> findByCategory(Category category);

    void deleteById(Long id);

    void deleteByTitle(String title);

    Product save(Product product);

//    @Query("Custom Query") //HQL -> Hibernate Query Language
//    Optional<Product> someRandomQuery();
}

/*

C -> Create
R -> Read
U -> Update
D -> Delete

Create, Update => save()

Product save(Product product);

ProductRepository -> Product

Product findById(id) => select * from product where id = <id>
List<Product> findAll() => select * from product
Product findByTitle(String title) => select * from product where title = "";
 */
