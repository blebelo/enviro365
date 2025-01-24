package com.enviro.assessment.grad001.bennylebelo;

import com.enviro.assessment.grad001.bennylebelo.controllers.DefaultController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DefaultController.class)
class DefaultControllerTests{

    @Autowired
    private MockMvc mockMvc;

    @Test
    void defaultController_shouldReturnExpectedResponse() throws Exception {
        mockMvc.perform(get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Enviro 365\":\"API\"}"));
    }
}
