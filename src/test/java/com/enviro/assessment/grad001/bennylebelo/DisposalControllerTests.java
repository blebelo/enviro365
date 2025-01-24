package com.enviro.assessment.grad001.bennylebelo;

import com.enviro.assessment.grad001.bennylebelo.controllers.DisposalTipController;
import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.services.DisposalTipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class DisposalTipControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DisposalTipService service;

    @InjectMocks
    private DisposalTipController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllCategories() throws Exception {
        when(service.getAllTips()).thenReturn(List.of(new DisposalTip("Food Waste", "Compost organic food waste to reduce landfill usage.")));

        mockMvc.perform(get("/api/v1/disposal-tip"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category").value("Food Waste"));
    }

    @Test
    void getTipById() throws Exception {
        when(service.getTipById(1)).thenReturn(Optional.of(new DisposalTip("Food Waste", "Compost organic food waste to reduce landfill usage.")));

        mockMvc.perform(get("/api/v1/disposal-tip/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category").value("Food Waste"));
    }

    @Test
    void getTipByIdNotFound() throws Exception {
        when(service.getTipById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/disposal-tip/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value("Error"))
                .andExpect(jsonPath("$.details").value("ID@1:Field is empty"));
    }

    @Test
    void createTip() throws Exception {
        DisposalTip tip = new DisposalTip("Plastic Bottles", "Rinse bottles before placing them in the recycling bin.");
        doNothing().when(service).createTip(any());

        mockMvc.perform(post("/api/v1/disposal-tip")
                        .contentType("application/json")
                        .content("{\"category\": \"Plastic Bottles\", \"description\": \"Rinse bottles before placing them in the recycling bin.\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }

    @Test
    void updateTip() throws Exception {
        DisposalTip updatedTip = new DisposalTip("Food Waste", "Updated description");
        when(service.updateTip(eq(1), any())).thenReturn(true);

        mockMvc.perform(put("/api/v1/disposal-tip/update/1")
                        .contentType("application/json")
                        .content("{\"category\": \"Food Waste\", \"description\": \"Updated description\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }

    @Test
    void updateTipNotFound() throws Exception {
        when(service.updateTip(eq(1), any())).thenReturn(false);

        mockMvc.perform(put("/api/v1/disposal-tip/update/1")
                        .contentType("application/json")
                        .content("{\"category\": \"Food Waste\", \"description\": \"Updated description\"}"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{\"ID@ 1\":\"Field is empty\"}"));
    }
    @Test
    void deleteTip() throws Exception {
        doNothing().when(service).deleteTip(1);

        mockMvc.perform(delete("/api/v1/disposal-tip/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }
}
