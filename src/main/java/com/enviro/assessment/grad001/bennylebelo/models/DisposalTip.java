package com.enviro.assessment.grad001.bennylebelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.relational.core.mapping.Table;


@Table("Disposal_Tips")
public class DisposalTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message= "Field may not be empty")
    private String category;
    @NotEmpty(message= "Field may not be empty")
    private String description;

    public DisposalTip() {
    }

    public DisposalTip(WasteCategory category, String description) {
        this.category = category.getName();
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(WasteCategory category) {
        this.category = category.getName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}