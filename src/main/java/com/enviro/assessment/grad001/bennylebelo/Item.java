package com.enviro.assessment.grad001.bennylebelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String wasteCategory;
    private String disposalTips;
    private String recyclingTips;


    public Item(String name, String wasteCategory, String disposalTips, String recyclingTips) {
        this.name = name;
        this.wasteCategory = wasteCategory;
        this.disposalTips = disposalTips;
        this.recyclingTips = recyclingTips;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
