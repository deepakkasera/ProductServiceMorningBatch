package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testGetProductByIdValidCase() throws InvalidProductIdException {
//        productController.getProductById(10L);

        //3 A's
        Product product = new Product();
        product.setId(10L);
        product.setTitle("iphone 15");
        product.setPrice(100000.0);

        Product product1 = new Product();
        product1.setId(10L);
        product1.setTitle("iphone 15");
        product1.setPrice(100000.0);

        when(productService.getProductById(10L))
                .thenReturn(product);

        ResponseEntity<Product> expectedResponse =
                productController.getProductById(10L);

        assertEquals(product,
                expectedResponse.getBody());

        assertEquals(HttpStatus.OK, expectedResponse.getStatusCode());
    }

    @Test
    void testGetProductByIdInValidCase() throws InvalidProductIdException {
        when(productService.getProductById(1000L))
                .thenThrow(new InvalidProductIdException(1000L, "Invalid Product Id"));

        assertThrows(
                InvalidProductIdException.class,
                () -> productController.getProductById(1000L)
        );
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("iPhone 15");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("iPhone 15 pro");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("iPhone 15 pro max");

        products.add(p1);
        products.add(p2);
        products.add(p3);

        when(productService.getAllProducts())
                .thenReturn(products); // @76589

//        for (Product product : products) {
//            System.out.println(product.getImage());
////        }
//
//        assertEquals(products, // @76589
//                productController.getAllProducts() ); //@98123

//        for (Product product : products) {
//            System.out.println(product.getImage());
//        }
    }
}