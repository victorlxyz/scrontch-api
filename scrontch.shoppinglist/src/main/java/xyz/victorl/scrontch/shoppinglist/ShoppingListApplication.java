package xyz.victorl.scrontch.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {
		"xyz.victorl.scrontch.shoppinglist.entity",
		"xyz.victorl.scrontch.common.entity"
})
@ComponentScan(basePackages = {
		"xyz.victorl.scrontch.shoppinglist",
		"xyz.victorl.scrontch.common"
})
@EnableJpaRepositories(basePackages = {
		"xyz.victorl.scrontch.shoppinglist.repository",
		"xyz.victorl.scrontch.common.repository"
})
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ShoppingListApplication.class);
		app.run(args);
	}
}
