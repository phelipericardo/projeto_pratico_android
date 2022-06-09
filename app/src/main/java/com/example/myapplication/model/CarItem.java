package com.example.myapplication.model;

public class CarItem {
    String title;
    Double price;
    int star;
    int picture;
    int door;
    int bagged;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getStar() {
        return star;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public int getPicture() {
        return picture;
    }
    public void setPicture(int picture) {
        this.picture = picture;
    }
    public int getDoor() {
        return door;
    }
    public void setDoor(int door) {
        this.door = door;
    }
    public int getBagged() {
        return bagged;
    }
    public void setBagged(int bagged) {
        this.bagged = bagged;
    }


    public static class CarItemBuilder {
        String title;
        Double price;
        int star;
        int picture;
        int door;
        int bagged;

        public CarItemBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CarItemBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public CarItemBuilder setStar(int star) {
            this.star = star;
            return this;
        }

        public CarItemBuilder setPicture(int picture) {
            this.picture = picture;
            return this;
        }

        public CarItemBuilder setDoor(int door) {
            this.door = door;
            return this;
        }

        public CarItemBuilder setBagged(int bagged) {
            this.bagged = bagged;
            return this;
        }


        private CarItemBuilder () {}

        public static CarItemBuilder builder (){
        return new CarItemBuilder();
        }
        public CarItem build() {
            CarItem carItem = new CarItem();
            carItem.price = price;
            carItem.star = star;
            carItem.picture = picture;
            carItem.door = door;
            carItem.bagged = bagged;
            carItem.title = title;
            return carItem;
        }
    }


}
