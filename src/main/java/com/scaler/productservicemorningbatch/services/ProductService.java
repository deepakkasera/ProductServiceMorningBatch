package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.dtos.FakeStoreProductDto;
import com.scaler.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;

    Page<Product> getAllProducts(int pageNumber, int pageSize, String sortDir);

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    Product createProduct(Product product);

    void deleteProduct();
}
