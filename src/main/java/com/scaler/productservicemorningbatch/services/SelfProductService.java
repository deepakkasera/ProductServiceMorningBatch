package com.scaler.productservicemorningbatch.services;

import com.scaler.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.models.Category;
import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.repositories.CategoryRepository;
import com.scaler.productservicemorningbatch.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository,
                       CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Fetch Product with the given id from DB.
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            //throw an Exception -> ProductNotFound
            throw new InvalidProductIdException(id, "Invalid Product Id");
//            return null;
        }

        return optionalProduct.get();
    }

    @Override
    //TODO
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String sortDir) {
        System.out.println(sortDir);
//        Sort sort;
//        if (sortDir.equals("asc")) {
//            sort = Sort.b
//        }

        return productRepository.findAll(PageRequest.of(pageNumber,
                pageSize,
                sortDir.equals("asc") ? Sort.by("price").ascending() :
                        Sort.by("price").descending()));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) throw new RuntimeException();

        if (product == null) throw new RuntimeException("Invalid input exception to update method");

        Product currentProduct = optionalProduct.get();

        if (product.getTitle() != null) {
            //If title isn't null that means we want to update the title.
            currentProduct.setTitle(product.getTitle());
        }

        if (product.getDescription() != null) {
            currentProduct.setDescription(product.getDescription());
        }

        return productRepository.save(currentProduct);
    }

    //TODO
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

//        if (category.getId() == null) {
//            //first save the category in the DB
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }

        return productRepository.save(product);
    }

    //TODO
    @Override
    public void deleteProduct() {

    }
}
