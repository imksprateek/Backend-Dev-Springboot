package me.ksprateek.mongodemo.repository;

import me.ksprateek.mongodemo.product.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
