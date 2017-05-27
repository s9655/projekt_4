package com.example.persistence;

import com.example.model.Category;
import com.example.model.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String name);
    Iterable<Product> findByCategory(Category category);

    @Query("SELECT p FROM Product p WHERE p.price > :_from AND p.price < :to")
    List<Product> findByPrice(
        @Param("_from") BigDecimal _from, @Param("to") BigDecimal to
    );
}
