package com.scaler.productservicemorningbatch.controllers;

import com.scaler.productservicemorningbatch.commons.AuthenticationCommons;
import com.scaler.productservicemorningbatch.dtos.Role;
import com.scaler.productservicemorningbatch.dtos.UserDto;
import com.scaler.productservicemorningbatch.exceptions.InvalidProductIdException;
import com.scaler.productservicemorningbatch.exceptions.ProductControllerSpecificException;
import com.scaler.productservicemorningbatch.models.Product;
import com.scaler.productservicemorningbatch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private AuthenticationCommons authenticationCommons;
    private RestTemplate restTemplate;

    ProductController(@Qualifier("fakeStoreProductService") ProductService productService,
                      AuthenticationCommons authenticationCommons,
                      RestTemplate restTemplate) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
        this.restTemplate = restTemplate;
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
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
//                "http://UserServiceMorningBatch/users/10", String.class
//        );

        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //localhost:8080/products
//    @GetMapping("/all/{token}")
    @GetMapping("/")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                                        @RequestParam("pageSize") int pageSize,
                                                        @RequestParam("sortDir") String sortDir) {

        //Validate the token using UserService.
//        UserDto userDto = authenticationCommons.validateToken(token);

//        if (userDto == null) {
//            //token is invalid
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

//        boolean isAdmin = false;
//        for (Role role : userDto.getRoles()) {
//            if (role.equals("ADMIN")) {
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if (!isAdmin) {
//            //throw some exception
//            return null;
//        }

        Page<Product> products = productService.getAllProducts(pageNumber, pageSize, sortDir); // @76589

        //products = new ArrayList<>(); // @98123

//        products.get(0).setImage("sample url1");
//        products.get(1).setImage("sample url2");
//        products.get(2).setImage("sample url3");

        return new ResponseEntity<>(products, HttpStatus.OK); //@98123
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
