package me.ksprateek.mongodemo.service;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MongoTemplate mongoTemplate;

    public List<Product> searchByName(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
        return products;
    }
}
