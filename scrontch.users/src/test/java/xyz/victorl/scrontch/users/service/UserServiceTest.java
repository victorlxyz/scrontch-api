package xyz.victorl.scrontch.users.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.users.dto.UserDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAllUsers() {
        List<UserDto> users = userService.findAll();
        assertFalse(users.isEmpty());
    }
}

