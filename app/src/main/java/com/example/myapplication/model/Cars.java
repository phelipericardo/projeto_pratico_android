package com.example.myapplication.model;

import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class Cars {
    public static List<CarItem> fakeCars(){
        return Arrays.asList(
                CarItem.CarItemBuilder.builder()
                        .setPrice(25.000)
                        .setStar(3)
                        .setPicture(4)
                        .setDoor(3)
                        .setBagged(2)
                        .setTitle("carro 1")
                        .build(),
                CarItem.CarItemBuilder.builder()
                        .setPrice(20.000)
                        .setStar(3)
                        .setPicture(4)
                        .setDoor(3)
                        .setBagged(2)
                        .setTitle("carro 2")
                        .build(),
                CarItem.CarItemBuilder.builder()
                        .setPrice(28.0442)
                        .setStar(3)
                        .setPicture(4)
                        .setDoor(3)
                        .setBagged(2)
                        .setTitle("carro 3")
                        .build(),

                CarItem.CarItemBuilder.builder()
                        .setPrice(20.345)
                        .setStar(3)
                        .setPicture(4)
                        .setDoor(3)
                        .setBagged(2)
                        .setTitle("carro 4")
                        .build(),

                CarItem.CarItemBuilder.builder()
                        .setPrice(27.000)
                        .setStar(3)
                        .setPicture(4)
                        .setDoor(3)
                        .setBagged(2)
                        .setTitle("carro 5")
                        .build()
        );
    }
}
