package dev.priyamvad.productservice.repositories;

import dev.priyamvad.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product poduct);
}
