package me.ksprateek.mongodemo.dto;

import lombok.*;
import me.ksprateek.mongodemo.product.Product;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private Integer status;
    private String message;
    private Product product;
}
