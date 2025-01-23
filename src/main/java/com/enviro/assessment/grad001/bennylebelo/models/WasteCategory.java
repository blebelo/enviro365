package com.enviro.assessment.grad001.bennylebelo.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.relational.core.mapping.Table;


@Table("Waste_Categories")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message= "Field may not be empty")
    private String name;

    @NotEmpty(message= "Field may not be empty")
    private Boolean recyclable;

    public WasteCategory() {
    }

    public WasteCategory(String name, Boolean recyclable) {
        this.name = name;
        this.recyclable = recyclable;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isRecyclable() {
        return recyclable;
    }

    public void setRecyclable(Boolean recyclable) {
        this.recyclable = recyclable;
    }
}