package dev.priyamvad.productservice.repositories;

import dev.priyamvad.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByTitle(String title);
    Category save(Category category);
}
