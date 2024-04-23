package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.repositories.CategoryRepository;
import dev.priyamvad.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownproductservice")
public class OwnProductService implements ProductService{
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    public OwnProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
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
        Product p = new Product();
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(image);
        // check if category exists in database
        Category categoryFromDatabase = categoryRepository.findByTitle(category);
        if(categoryFromDatabase==null){
            Category category1 = new Category();
            category1.setTitle(category);
            categoryFromDatabase = category1;
        }
        p.setCategory(categoryFromDatabase);
        Product savedProduct = productRepository.save(p);
        return savedProduct;
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
