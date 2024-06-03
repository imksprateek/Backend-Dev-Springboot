package me.ksprateek.mongodemo.repository;

import me.ksprateek.mongodemo.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    //Just specify what you want to do in method name and spring will do it automatically
    List<Product> findAllByNameIgnoreCase(String name);
    List<Product> findAllByNameStartingWith(String name);
    List<Product> findAllByNameEndingWith(String name);
    List<Product> findAllByNameContainingIgnoreCase(String name);
    List<Product> findAllByPriceLessThan(BigDecimal price);
    List<Product> findAllByPriceGreaterThan(BigDecimal price);
    List<Product> findAllByPriceBetween(BigDecimal price1, BigDecimal price2);
    List<Product> findAllByNameContainingIgnoreCaseOrderByPriceAsc(String name);
    List<Product> findAllByNameContainingIgnoreCaseOrderByPriceAsc(String name, Pageable page);
}
