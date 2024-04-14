package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

// Service to interact with fakestore api's
@Service("fakestore")
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(int productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, double price, String description, String image, Category category) {
        return null;
    }
}
