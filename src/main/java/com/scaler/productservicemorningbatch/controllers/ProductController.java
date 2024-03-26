package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/30
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    //Partial Update.
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return new Product();
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }
}
