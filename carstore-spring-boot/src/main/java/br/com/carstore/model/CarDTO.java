package br.com.carstore.model;

import br.com.carstore.model.Car; // ajuste se o entity estiver em outro pacote

public class CarDTO {
    private String id;
    private String name;
    private String color;

    public CarDTO() {}

    // construtor para mapear entity -> dto
    public CarDTO(Car car) {
        this.name = car.getName();
        this.color = car.getColor();
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}