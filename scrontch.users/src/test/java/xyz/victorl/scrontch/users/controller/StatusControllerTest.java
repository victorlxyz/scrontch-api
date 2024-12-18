package xyz.victorl.scrontch.users.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import xyz.victorl.scrontch.users.service.StatusService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatusController.class)
public class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatusService statusService;

    @Test
    public void testGetAllStatuses() throws Exception {
        mockMvc.perform(get("/api/v1/statuses"))
                .andExpect(status().isOk());
    }
}

