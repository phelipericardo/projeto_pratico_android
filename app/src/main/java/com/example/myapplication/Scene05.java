package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.classes.Car;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.CarDao;
import com.example.myapplication.model.CarItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class Scene05 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene05);


        Bundle extras = getIntent().getExtras();

        AppDatabase db = AppDatabase.getInstance(this);
        CarDao dao = db.cardao();
        Car car = dao.buscarPorId(extras.getInt("carid"));


        TextView textview = (TextView)  findViewById(R.id.car_title);
        textview.setText(car.title);


        textview = (TextView)  findViewById(R.id.car_door_amount);
        textview.setText(Integer.toString(car.door));

        textview = (TextView)  findViewById(R.id.car_offer_bagged_amount);
        textview.setText(Integer.toString(car.bagged));

        ImageView img = findViewById(R.id.car_image);
        if (car.model == 1){
            img.setImageResource(R.mipmap.a1);
        } else if (car.model == 2){
            img.setImageResource(R.mipmap.a2);
        } else if (car.model == 3){
            img.setImageResource(R.mipmap.a3);
        } else if (car.model == 4){
            img.setImageResource(R.mipmap.a4);
        }

    }
    public void returnAvalible (View v) {
        startActivity(new Intent(Scene05.this, Scene02.class));
        finish();
    }
    public void order (View v) {
        int carId = -1;
        Bundle extras = getIntent().getExtras();
        String value = "";
        String value1 = "";
        if (extras != null) {
            value = extras.getString("checkin");
            value1 = extras.getString("checkout");
            carId = extras.getInt("carid");
        }

        Intent i = new Intent(Scene05.this, Scene06.class);
        i.putExtra("checkin", value);
        i.putExtra("checkout", value1);
        i.putExtra("carid", carId);
        startActivity(i);
        finish();
    }

}