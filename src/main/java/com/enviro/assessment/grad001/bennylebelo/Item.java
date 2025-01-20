package com.enviro.assessment.grad001.bennylebelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity(name = "waste_table")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotEmpty(message = "Field may not be empty")
    @Column(name = "item_name")
    private String name;
    @NotEmpty(message = "Field may not be empty")
    private String wasteCategory;
    @NotEmpty(message = "Field may not be empty")
    private String disposalTips;
    @NotEmpty(message = "Field may not be empty")
    private String recyclingTips;


    public Item() {
    }

    public Item(String name, String wasteCategory, String disposalTips, String recyclingTips) {
        this.name = name;
        this.wasteCategory = wasteCategory;
        this.disposalTips = disposalTips;
        this.recyclingTips = recyclingTips;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String item_name) {
        this.name = item_name;
    }

    public String getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getDisposalTips() {
        return disposalTips;
    }

    public void setDisposalTips(String disposalTips) {
        this.disposalTips = disposalTips;
    }

    public String getRecyclingTips() {
        return recyclingTips;
    }

    public void setRecyclingTips(String recyclingTips) {
        this.recyclingTips = recyclingTips;
    }

}
