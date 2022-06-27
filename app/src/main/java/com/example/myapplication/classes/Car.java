package com.example.myapplication.classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {

    @PrimaryKey
    public int id;
    public String title;
    public Double price;
    public int star;
    public int picture;
    public int door;
    public int bagged;
    public int model;
    public String status;

    public Car(int id, String title, Double price, int star, int picture, int door, int bagged, int model, String status) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.star = star;
        this.picture = picture;
        this.door = door;
        this.bagged = bagged;
        this.model = model;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public int getStar() {
        return star;
    }

    public int getPicture() {
        return picture;
    }

    public int getDoor() {
        return door;
    }

    public int getBagged() {
        return bagged;
    }

    public int getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

}
