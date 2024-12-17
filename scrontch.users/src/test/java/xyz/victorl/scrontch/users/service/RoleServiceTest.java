package xyz.victorl.scrontch.users.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.users.dto.RoleDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindAllRoles() {
        List<RoleDto> roles = roleService.findAll();
        assertFalse(roles.isEmpty());
    }
}

