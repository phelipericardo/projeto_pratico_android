package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.CarItemAdapter;
import com.example.myapplication.model.Cars;

import java.util.ArrayList;

public class Scene04 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene04);
        try {
            CarItemAdapter carListAdapter = new CarItemAdapter(new ArrayList<>(Cars.fakeCars()));

            RecyclerView v = findViewById(R.id.car_list_recycle);
            v.setAdapter(carListAdapter);
        }catch (Exception e){
        }
    }

    public void returnReserva (View r){
        startActivity(new Intent(Scene04.this, Scene02.class));
        finish();
    }

    public void carInfo (View r){
        startActivity(new Intent(Scene04.this, Scene05.class));
        finish();
    }

}