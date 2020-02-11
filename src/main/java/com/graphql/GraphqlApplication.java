package com.graphql;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(FoodService foodService) {
	    return args -> {
	        Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
	            Food food = new Food();
	            food.setName(name);
	            foodService.saveFood(food);
	        });
	        foodService.getFoods().forEach(System.out::println);
	    };
	}

}
