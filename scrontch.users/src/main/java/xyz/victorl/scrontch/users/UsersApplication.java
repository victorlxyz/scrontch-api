package xyz.victorl.scrontch.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {
		"xyz.victorl.scrontch.users.entity",
		"xyz.victorl.scrontch.common.entity"
})
@ComponentScan(basePackages = {
		"xyz.victorl.scrontch.users",
		"xyz.victorl.scrontch.common"
})
@EnableJpaRepositories(basePackages = {
		"xyz.victorl.scrontch.users.repository",
		"xyz.victorl.scrontch.common.repository"
})
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UsersApplication.class);
		app.run(args);
	}
}