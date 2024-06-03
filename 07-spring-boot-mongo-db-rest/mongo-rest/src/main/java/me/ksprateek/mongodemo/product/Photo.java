package me.ksprateek.mongodemo.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
@Data
@AllArgsConstructor
@Builder
public class Photo {
    @Id
    private String id;
    private Binary image;

}
