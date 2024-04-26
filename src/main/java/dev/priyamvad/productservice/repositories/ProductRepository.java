package dev.priyamvad.productservice.repositories;

import dev.priyamvad.productservice.models.Product;
import dev.priyamvad.productservice.projections.FindAllProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    /* using JPA query method*/

    Product save(Product poduct);

    /*
    * to find product by id
    */
    Product findByIdIs(long id);

    /*
    * find all products present in product table using JPA query method
    * */

    List<Product> findAll();

    /*find all products by category*/
    List<Product> findAllByCategory_Title(String category);

    @Transactional
    @Modifying
    int deleteProductById(Long id);

    /*querying database using java persistent query language*/


    /*
    find all products present in product table using Java persistent query language
    * */
    @Query("select p from Product p")
    List<Product> findAllProducts();

    @Query("select p from Product p where p.category.title = :category")
    List<Product> findAllProductsByCategory(String category);

    @Modifying
    @Transactional
    @Query("update Product p set p.title=:title,p.description=:description,p.price=:price,p.category.id=:catId where p.id=:id")
    int updateProductById(@Param("id") Long id,@Param("title") String title,@Param("description") String description,@Param("price") double price,@Param("catId") Long categoryId);

    @Query("select p from Product p where p.id=:id")
    Product findProductById(@Param("id") long id);
}
