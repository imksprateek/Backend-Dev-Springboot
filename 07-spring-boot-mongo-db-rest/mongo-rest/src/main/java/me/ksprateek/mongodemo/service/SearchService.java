package me.ksprateek.mongodemo.service;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Product;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MongoTemplate mongoTemplate;

    //Querying by product name
    public List<Product> searchByName(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Product> products = mongoTemplate.find(query, Product.class);
        System.out.println(products);
        return products;
    }

    //Querying by product name starting with specified string (name parameter)
    public List<Product> searchByNameStartsWith(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^" + name));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    //Querying by product name ending with specified String (name parameter)
    public List<Product> searchByNameEndsWith(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name + "$"));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByPriceLowerThan(BigDecimal cost){
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lt(cost));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByPriceGreaterThan(BigDecimal cost){
        Query query = new Query();
        query.addCriteria(Criteria.where("price").gt(cost));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByRatingLowerThan(Double rating){
        Query query = new Query();
        query.addCriteria(Criteria.where("rating").lt(rating));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByRatingGreaterThan(Double rating){
        Query query = new Query();
        query.addCriteria(Criteria.where("rating").gt(rating));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByQuantityLowerThan(Double count){
        Query query = new Query();
        query.addCriteria(Criteria.where("quantity").lt(count));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByQuantityGreaterThan(Double count){
        Query query = new Query();
        query.addCriteria(Criteria.where("quantity").gt(count));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }
}
