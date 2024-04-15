package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;

import java.util.List;

public class OwnProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, double price, String description, String image, String category) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, String title, double price, String description, String image, String category) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getProductsOfCategory(String category) {
        return null;
    }
}
