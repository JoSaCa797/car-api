package com.example.carapi.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String VIN;
    private String name;
    private String INO;
    private double cost;

    public Vehicle(){
    }

    public Vehicle(String VIN, String name, String INO, double cost) {
        this.VIN = VIN;
        this.name = name;
        this.INO = INO;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getINO() {
        return INO;
    }

    public void setINO(String INO) {
        this.INO = INO;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
