package me.ksprateek.mongodemo.controller;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.service.QueryMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/method-queries")
@RequiredArgsConstructor
public class QueryMethodController {
    private final QueryMethodService service;

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping("/search/starts-with")
    public ResponseEntity<List<Product>> getProductsByNameStartsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.searchByNameStartsWith(name));
    }

    @GetMapping("/search/ends-with")
    public ResponseEntity<List<Product>> getProductsByNameEndsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.searchByNameEndsWith(name));
    }
    @GetMapping("/search/containing")
    public ResponseEntity<List<Product>> getProductsByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.searchByNameContaining(name));
    }

    @GetMapping("/search/price-greater-than")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(service.searchByPriceGreaterThan(price));
    }

    @GetMapping("/search/price-lower-than")
    public ResponseEntity<List<Product>> getProductsByPriceLowerThan(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(service.searchByPriceLowerThan(price));
    }

    @GetMapping("/search/price-between")
    public ResponseEntity<List<Product>> getProductsByPriceLowerThan(@RequestParam("price1") BigDecimal price1, @RequestParam("price2") BigDecimal price2) {
        return ResponseEntity.ok(service.searchByPriceBetween(price1, price2));
    }

    @GetMapping("/search/rating-greater-than")
    public ResponseEntity<List<Product>> getProductsByRatingGreaterThan(@RequestParam("rating") Double rating) {
        return ResponseEntity.ok(service.searchByRatingGreaterThan(rating));
    }

    @GetMapping("/search/rating-lower-than")
    public ResponseEntity<List<Product>> getProductsByRatingLowerThan(@RequestParam("rating") Double rating) {
        return ResponseEntity.ok(service.searchByRatingLowerThan(rating));
    }

    @GetMapping("/search/quantity-greater-than")
    public ResponseEntity<List<Product>> getProductsByQuantityGreaterThan(@RequestParam("quantity") Double qty) {
        return ResponseEntity.ok(service.searchByQuantityGreaterThan(qty));
    }

    @GetMapping("/search/quantity-lower-than")
    public ResponseEntity<List<Product>> getProductsByQuantityLowerThan(@RequestParam("quantity") Double qty) {
        return ResponseEntity.ok(service.searchByQuantityLowerThan(qty));
    }

    @GetMapping("/sort/search-and-sort-by-price")
    public ResponseEntity<List<Product>> getProductsSortedByPrice(@RequestParam("product") String product) {
        return ResponseEntity.ok(service.searchAndSortAsc(product));
    }

    //I'll set default values for the request parameters page and size
    @GetMapping("/sort/search-and-sort-by-price-page")
    public ResponseEntity<List<Product>> getProductsSortedByPricePage(@RequestParam("product") String product, @RequestParam(value = "page", required = false, defaultValue = "0") int pageNo, @RequestParam(value = "size", required = false, defaultValue = "2") int size) {
        return ResponseEntity.ok(service.searchAndSortAscPage(product, pageNo, size));
    }

    @GetMapping("/sort/page-by-field")
    public ResponseEntity<List<Product>> getProductsPagedByField(@RequestParam("field") String fieldName, @RequestParam("order") String order, @RequestParam("page") int pageNumber) {
        return ResponseEntity.ok(service.sortAndPageByField(fieldName, order, pageNumber));
    }

}
