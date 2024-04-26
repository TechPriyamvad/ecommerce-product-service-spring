package dev.priyamvad.productservice.repositories;

import dev.priyamvad.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    /*querying database using JPA query method*/
    Category findByTitle(String title);
    Category save(Category category);

    List<Category> findAll();
    /*querying database using JPQL method*/
}
