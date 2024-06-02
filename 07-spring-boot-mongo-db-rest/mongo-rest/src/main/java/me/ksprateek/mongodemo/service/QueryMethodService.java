package me.ksprateek.mongodemo.service;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMethodService {
    private final ProductRepository repository;

    //Querying by product name
    public List<Product> searchByName(String name){
        return repository.findAllByNameIgnoreCase(name);
    }

    //Querying by product name starting with specified string (name parameter)
    public List<Product> searchByNameStartsWith(String name){
        return repository.findAllByNameStartingWith(name);
    }

    //Querying by product name ending with specified String (name parameter)
    public List<Product> searchByNameEndsWith(String name){
        return repository.findAllByNameEndingWith(name);
    }
    public List<Product> searchByNameContaining(String name){
        return repository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Product> searchByPriceLowerThan(BigDecimal cost){
        return repository.findAllByPriceLessThan(cost);
    }

    public List<Product> searchByPriceGreaterThan(BigDecimal cost){
        return repository.findAllByPriceGreaterThan(cost);
    }

    public List<Product> searchByPriceBetween(BigDecimal cost1, BigDecimal cost2){
        return repository.findAllByPriceBetween(cost1, cost2);
    }



    public List<Product> searchByRatingLowerThan(Double rating){
        return null;
    }

    public List<Product> searchByRatingGreaterThan(Double rating){
        return null;
    }

    public List<Product> searchByQuantityLowerThan(Double count){
        return null;
    }

    public List<Product> searchByQuantityGreaterThan(Double count){
        return null;
    }

    public List<Product> searchAndSortAsc(String name){
        return repository.findAllByNameContainingIgnoreCaseOrderByPriceAsc(name);
    }
    public List<Product> searchAndSortAscPage(String name, int pageNo, int size){
        Pageable page = PageRequest.of(pageNo, size);

        return repository.findAllByNameContainingIgnoreCaseOrderByPriceAsc(name, page);
    }

    public List<Product> sortAndPageByField(String fieldName, String order, int pageNumber){
        return null;
    }
}
