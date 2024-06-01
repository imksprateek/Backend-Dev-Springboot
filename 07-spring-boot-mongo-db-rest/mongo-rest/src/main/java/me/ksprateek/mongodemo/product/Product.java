package me.ksprateek.mongodemo.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

// Use @Document annotation for MongoDB document object
@Document
// @Data creates getters and setters, equals() method, toString() and a hashCode() method
@Data
@AllArgsConstructor
// @Builder for Builder design pattern
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    private BigDecimal price;
    private double quantity;
    private double rating;

    //Use @DBRef to link to documents in another repository(Collection)
    @DBRef
    private Category category;
}
