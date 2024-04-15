package dev.priyamvad.productservice.services;


import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(String title, double price, String description, String image, String category);
    List<Category> getAllCategories();
    Product updateProduct(Long id,String title,double price,String description,String image,String category);
    Product deleteProduct(Long productId);
    List<Product> getProductsOfCategory(String category);
}
