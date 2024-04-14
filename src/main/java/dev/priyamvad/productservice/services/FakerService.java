package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("faker")
public class FakerService implements ProductService{
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product createProduct(String title, double price, String description, String image, String category) {
        return null;
    }
}
