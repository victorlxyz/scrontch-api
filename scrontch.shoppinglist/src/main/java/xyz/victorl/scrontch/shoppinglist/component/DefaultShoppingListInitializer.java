package xyz.victorl.scrontch.shoppinglist.component;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.victorl.scrontch.common.entity.User;
import xyz.victorl.scrontch.common.repository.UserRepository;
import xyz.victorl.scrontch.shoppinglist.service.ShoppinglistService;

@Component
@RequiredArgsConstructor
public class DefaultShoppingListInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ShoppinglistService shoppinglistService;

    @Override
    public void run(String... args) {
        userRepository.findAll().forEach(user ->
                shoppinglistService.createDefaultListIfNotExists(user.getId())
        );
    }
}