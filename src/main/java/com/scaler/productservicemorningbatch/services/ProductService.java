package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct();

    Product replaceProduct();

    Product createProduct();

    void deleteProduct();
}
