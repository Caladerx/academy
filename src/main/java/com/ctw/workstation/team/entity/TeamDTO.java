package com.ctw.workstation.team.entity;

public record TeamDTO(String name,
                      String product,
                      String defaultLocation) {


    public TeamDTO(String name, String product, String defaultLocation) {
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;

    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }
}
