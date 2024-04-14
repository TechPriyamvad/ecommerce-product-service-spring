package dev.priyamvad.productservice.dtos;

import dev.priyamvad.productservice.models.Category;
import dev.priyamvad.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBodySingleProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setImageUrl(image);
        product.setDescription(description);
        product.setPrice(price);
        Category category1 = new Category();
        category1.setTitle(category);
        product.setCategory(category1);
        return product;
    }
}
