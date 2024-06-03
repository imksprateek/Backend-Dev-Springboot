package me.ksprateek.mongodemo.service;

import lombok.RequiredArgsConstructor;
import me.ksprateek.mongodemo.dto.Response;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor creates constructor with all the final fields (attributes) in this class
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public String save(Product product) {
        //mongo repository insert() only inserts data into the database, doesn't update data if already exists
        //whereas mongo repository save() inserts data if the id is not specified and updates the existing data if id is specified
        return repository.save(product).getId();
    }

    public Response findById(String id) {
        Optional<Product> product = repository.findById(id);

        if(product.isPresent()) {
            return Response.builder()
                    .status(200)
                    .message("Product found")
                    .product(product.get())
                .build();
        }
        return Response.builder()
                .status(400)
                .message("Product not found")
                .build();
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Response delete(String id) {

        Product product = repository.findById(id).orElse(null);
        if(product != null) {
            repository.deleteById(id);

            return Response.builder()
                    .status(200)
                    .message("Product deleted successfully")
                    .product(product)
                    .build();
        }

        return Response.builder()
                .status(400)
                .message("Product not found. Check if the provided id is right")
                .build();

    }
}
