package com.example.demo.service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GroupDto {

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
