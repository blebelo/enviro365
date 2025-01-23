package com.enviro.assessment.grad001.bennylebelo.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("WASTE_CATEGORIES")
public class WasteCategory {
    @Id
    private Integer id;

    @NotEmpty(message= "Field may not be empty")
    private String name;

    @NotNull(message= "Field may not be null")
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