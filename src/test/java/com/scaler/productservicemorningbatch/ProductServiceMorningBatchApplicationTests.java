package com.scaler.productservicemorningbatch;

import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.repositories.ProductRepository;
import com.scaler.productservicemorningbatch.repositories.projections.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceMorningBatchApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries() {
//        List<ProductWithIdAndTitle> products = productRepository.someRandomQuery();
//
//        for (ProductWithIdAndTitle product : products) {
//            System.out.println(product.getId());
//            System.out.println(product.getTitle());
//        }

        ProductWithIdAndTitle product = productRepository.doSomething(3L);
        System.out.println(product.getId());
        System.out.println(product.getTitle());

        Product product1 = productRepository.doSomethingSQL();

        Optional<Product> productOptional = productRepository.findById(2L);
        Product product2 = null;
        if (productOptional.isPresent()) {
            product2 = productOptional.get();
        }

        System.out.println("DEBUG");
    }

}
