package dev.priyamvad.productservice.controllers;

import dev.priyamvad.productservice.dtos.RequestBodySingleProductDto;
import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

// Handles all http request related to products
@RestController
public class ProductController {
    ProductService productService;
    // Qualifier is used to identify the dependency to be injected here
    public ProductController(@Qualifier("fakestore")ProductService productService){
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodySingleProductDto request){
        return productService.createProduct(request.getTitle(),request.getPrice(),request.getDescription(), request.getImage(),request.getCategory());
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public void getAllProducts(){}
}
