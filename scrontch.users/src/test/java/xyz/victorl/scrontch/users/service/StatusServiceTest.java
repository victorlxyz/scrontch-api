package xyz.victorl.scrontch.users.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.users.dto.StatusDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class StatusServiceTest {

    @Autowired
    private StatusService statusService;

    @Test
    public void testFindAllStatuses() {
        List<StatusDto> statuses = statusService.findAll();
        assertFalse(statuses.isEmpty());
    }
}

