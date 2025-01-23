package com.enviro.assessment.grad001.bennylebelo.models;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("DISPOSAL_TIPS")
public class DisposalTip {
    @Id
    private Integer id;

    @NotEmpty(message= "Field may not be empty")
    private String category;
    @NotEmpty(message= "Field may not be empty")
    private String description;

    public DisposalTip() {
    }

    public DisposalTip(String category, String description) {
        this.category = category;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}