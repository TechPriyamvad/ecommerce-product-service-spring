package dev.priyamvad.productservice.controllers;

import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// Handles all http request related to products
@RestController
public class ProductController {
    ProductService productService;
    // Qualifier is used to identify the dependency to be injected here
    public ProductController(@Qualifier("fakestore")ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public void createProduct(){}

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") int id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public void getAllProducts(){}
}
