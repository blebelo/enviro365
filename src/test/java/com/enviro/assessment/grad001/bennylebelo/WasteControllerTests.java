package com.enviro.assessment.grad001.bennylebelo;

import com.enviro.assessment.grad001.bennylebelo.controllers.WasteCategoryController;
import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.services.WasteCategoryService;
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

class WasteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WasteCategoryService service;

    @InjectMocks
    private WasteCategoryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllCategories() throws Exception {
        when(service.getAllCategories()).thenReturn(List.of(new WasteCategory("Plastic Bottles", true)));

        mockMvc.perform(get("/api/v1/waste-categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Plastic Bottles"))
                .andExpect(jsonPath("$[0].recyclable").value(true));
    }

    @Test
    void getCategoryById() throws Exception {
        when(service.getCategoryById(1)).thenReturn(Optional.of(new WasteCategory("Plastic Bottles", true)));

        mockMvc.perform(get("/api/v1/waste-categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Plastic Bottles"))
                .andExpect(jsonPath("$.recyclable").value(true));
    }

    @Test
    void getCategoryByIdNotFound() throws Exception {
        when(service.getCategoryById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/waste-categories/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value("Error"))
                .andExpect(jsonPath("$.details").value("ID@1:Field is empty"));
    }

    @Test
    void createCategory() throws Exception {
        WasteCategory category = new WasteCategory("Plastic Bottles", true);
        doNothing().when(service).createCategory(any());

        mockMvc.perform(post("/api/v1/waste-categories")
                        .contentType("application/json")
                        .content("{\"name\": \"Plastic Bottles\", \"recyclable\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }

    @Test
    void updateCategory() throws Exception {
        WasteCategory updatedCategory = new WasteCategory("Plastic Bottles", true);
        when(service.updateCategory(eq(1), any())).thenReturn(true);

        mockMvc.perform(put("/api/v1/waste-categories/update/1")
                        .contentType("application/json")
                        .content("{\"name\": \"Plastic Bottles\", \"recyclable\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }

    @Test
    void updateCategoryNotFound() throws Exception {
        when(service.updateCategory(eq(1), any())).thenReturn(false);

        mockMvc.perform(put("/api/v1/waste-categories/update/1")
                        .contentType("application/json")
                        .content("{\"name\": \"Plastic Bottles\", \"recyclable\": true}"))
                .andExpect(jsonPath("$.status").value("Error"))
                .andExpect(jsonPath("$.details").value("ID@1:Field is empty"));
    }

    @Test
    void deleteCategory() throws Exception {
        doNothing().when(service).deleteCategory(1);

        mockMvc.perform(delete("/api/v1/waste-categories/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Status").value("Success"));
    }
}
