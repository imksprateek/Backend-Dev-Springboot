package me.ksprateek.mongodemo.repository;

import me.ksprateek.mongodemo.product.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
