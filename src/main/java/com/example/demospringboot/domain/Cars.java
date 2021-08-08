package com.example.demospringboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String color;
    private String origColor;
    private boolean isOriginalColor;

    private String model;

    private String vin;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOrigColor() {
        return origColor;
    }

    public void setOrigColor(String origColor) {
        this.origColor = origColor;
    }

    public boolean isOriginalColor() {
        return isOriginalColor;
    }

    public void setOriginalColor(boolean originalColor) {
        isOriginalColor = originalColor;


    }

}
