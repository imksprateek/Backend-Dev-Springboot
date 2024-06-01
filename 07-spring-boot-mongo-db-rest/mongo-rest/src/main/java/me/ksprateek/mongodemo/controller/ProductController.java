package me.ksprateek.mongodemo.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.dto.Response;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Response> getProductById(@PathVariable String productId) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Response> deleteProductById(@PathVariable String productId) {
        return ResponseEntity.ok(service.delete(productId));
    }

}
