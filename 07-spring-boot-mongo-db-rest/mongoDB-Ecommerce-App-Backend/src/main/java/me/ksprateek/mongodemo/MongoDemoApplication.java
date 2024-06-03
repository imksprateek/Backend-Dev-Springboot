package me.ksprateek.mongodemo;

import me.ksprateek.mongodemo.product.Category;
import me.ksprateek.mongodemo.product.Product;
import me.ksprateek.mongodemo.repository.CategoryRepository;
import me.ksprateek.mongodemo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository productRepository,
			CategoryRepository categoryRepository
	){
		return args -> {
			var cat1 = Category.builder()
					.name("cat1")
					.description("This is cat1")
					.build();

			var cat2 = Category.builder()
					.name("cat2")
					.description("This is cat2")
					.build();

			categoryRepository.insert(cat1);
			categoryRepository.insert(cat2);

			var product = Product.builder()
					.name("Samsung Galaxy M31")
					.description("Budget Smart phone")
					.build();

//			productRepository.insert(product);
		};
	}
}
