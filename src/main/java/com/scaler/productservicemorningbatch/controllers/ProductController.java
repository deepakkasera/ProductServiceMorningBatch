package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.exceptions.ProductControllerSpecificException;
import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/30
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws InvalidProductIdException {
        //throw new RuntimeException("Something went wrong");
//        Product product = null;
//        try {
//            product = productService.getProductById(id);
//        } catch (RuntimeException e) {
//            System.out.println("Something went wrong");
//            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return
//        }
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //Partial Update.
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {

        return productService.updateProduct(id, product);
    }

    //Replace Product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
