package dev.priyamvad.productservice.controllers;

import dev.priyamvad.productservice.dtos.RequestBodySingleProductDto;
import dev.priyamvad.productservice.dtos.UpdateProductDto;
import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles all http request related to products
@RestController
public class ProductController {
    ProductService productService;
    // Qualifier is used to identify the dependency to be injected here
    public ProductController(@Qualifier("ownproductservice")ProductService productService){
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
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return productService.getAllCategories();
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody UpdateProductDto request){
        return productService.updateProduct(id,request.getTitle(),request.getPrice(),request.getDescription(),request.getImage(),request.getCategory());
    }
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id")Long id){
        return productService.deleteProduct(id);
    }
    @GetMapping("/products/category/{category}")
    public List<Product> getProductsOfCategory(@PathVariable("category") String category){
        return productService.getProductsOfCategory(category);
    }
}
