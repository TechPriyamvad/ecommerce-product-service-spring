package dev.priyamvad.productservice;

import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.services.FakeStoreProductService;
import dev.priyamvad.productservice.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* Product service handles operation related to products
* */

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
