package me.ksprateek.mongodemo.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.dto.Response;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.service.ProductService;
import me.ksprateek.mongodemo.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final SearchService searchService;

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

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByName(name));
    }

    @GetMapping("/search/starts-with")
    public ResponseEntity<List<Product>> getProductsByNameStartsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByNameStartsWith(name));
    }

    @GetMapping("/search/ends-with")
    public ResponseEntity<List<Product>> getProductsByNameEndsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByNameEndsWith(name));
    }

    @GetMapping("/search/price-greater-than")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(searchService.searchByPriceGreaterThan(price));
    }

    @GetMapping("/search/price-lower-than")
    public ResponseEntity<List<Product>> getProductsByPriceLowerThan(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(searchService.searchByPriceLowerThan(price));
    }

    @GetMapping("/search/rating-greater-than")
    public ResponseEntity<List<Product>> getProductsByRatingGreaterThan(@RequestParam("rating") Double rating) {
        return ResponseEntity.ok(searchService.searchByRatingGreaterThan(rating));
    }

    @GetMapping("/search/rating-lower-than")
    public ResponseEntity<List<Product>> getProductsByRatingLowerThan(@RequestParam("rating") Double rating) {
        return ResponseEntity.ok(searchService.searchByRatingLowerThan(rating));
    }

    @GetMapping("/search/quantity-greater-than")
    public ResponseEntity<List<Product>> getProductsByQuantityGreaterThan(@RequestParam("quantity") Double qty) {
        return ResponseEntity.ok(searchService.searchByQuantityGreaterThan(qty));
    }

    @GetMapping("/search/quantity-lower-than")
    public ResponseEntity<List<Product>> getProductsByQuantityLowerThan(@RequestParam("quantity") Double qty) {
        return ResponseEntity.ok(searchService.searchByQuantityLowerThan(qty));
    }

    @GetMapping("/sort/by-field")
    public ResponseEntity<List<Product>> getProductsSortedByField(@RequestParam("field") String fieldName, @RequestParam("order") String order) {
        return ResponseEntity.ok(searchService.sortByField(fieldName, order));
    }

    @GetMapping("/sort/page-by-field")
    public ResponseEntity<List<Product>> getProductsPagedByField(@RequestParam("field") String fieldName, @RequestParam("order") String order, @RequestParam("page") int pageNumber) {
        return ResponseEntity.ok(searchService.sortAndPageByField(fieldName, order, pageNumber));
    }

}
