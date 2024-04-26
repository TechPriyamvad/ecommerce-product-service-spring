package dev.priyamvad.productservice.services;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.projections.FindAllProductProjection;
import dev.priyamvad.productservice.repositories.CategoryRepository;
import dev.priyamvad.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
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
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public Product updateProduct(Long id, String title, double price, String description, String image, String category) {
        Category cat = categoryRepository.findByTitle(category);
        int affectedRows = cat.getId() > 0 ? productRepository.updateProductById(id,title,description,price,cat.getId()) : 0;

        if(affectedRows > 0)
            return productRepository.findProductById(id);
        else
            return null;
    }

    @Transactional
    @Override
    public Product deleteProduct(Long productId) {
        Product product = productRepository.findByIdIs(productId);
        int affectedRow = productRepository.deleteProductById(productId);
        return affectedRow > 0 && product != null? product : null;
    }

    @Override
    public List<Product> getProductsOfCategory(String category) {
//        return productRepository.findAllByCategory_Title(category);
        return productRepository.findAllProductsByCategory(category);
    }
}
