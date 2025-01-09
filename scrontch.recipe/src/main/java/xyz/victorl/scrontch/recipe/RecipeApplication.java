package xyz.victorl.scrontch.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "xyz.victorl.scrontch")
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

}
