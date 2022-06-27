package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.classes.Car;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.CarAdapter;
import com.example.myapplication.model.CarDao;
import com.example.myapplication.model.CarItemAdapter;
import com.example.myapplication.model.RecycleViewInterface;

import java.util.ArrayList;
import java.util.List;

public class Scene04 extends AppCompatActivity implements RecycleViewInterface {
    int trigered = 0;
    List<Car> cars = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene04);

        AppDatabase db = AppDatabase.getInstance(this);
        CarDao dao = db.cardao();

        cars = dao.getAll();

        RecyclerView recyclerView = findViewById(R.id.car_list_recycle);
        CarAdapter carAdapter = new CarAdapter(this, cars, this);
        recyclerView.setAdapter(carAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void filter (View r){
        AppDatabase db = AppDatabase.getInstance(this);
        CarDao dao = db.cardao();
        RecyclerView recyclerView = findViewById(R.id.car_list_recycle);

        Button button1 = findViewById(R.id.button_filter_small);
        Button button2 = findViewById(R.id.button_filter_medium);
        Button button3 = findViewById(R.id.button_filter_suv);
        Button button4 = findViewById(R.id.button_filter_premium);

        if (r.getId() == button1.getId()) {
            if (trigered != 1) {
                cars = dao.buscarPorModelo(1);
                trigered = 1;
            } else {
                cars = dao.getAll();
                trigered = 0;
            }
        } else if (r.getId() == button2.getId()){
            if (trigered != 2) {
                cars = dao.buscarPorModelo(2);
                trigered = 2;
            } else {
                cars = dao.getAll();
                trigered = 0;
            }
        } else if (r.getId() == button3.getId()){
            if (trigered != 3) {
                cars = dao.buscarPorModelo(3);
                trigered = 3;
            } else {
                cars = dao.getAll();
                trigered = 0;
            }
        } else if (r.getId() == button4.getId()){
            if (trigered != 4) {
                cars = dao.buscarPorModelo(4);
                trigered = 4;
            } else {
                cars = dao.getAll();
                trigered = 0;
            }
        }
        CarAdapter carAdapter = new CarAdapter(this, cars, this);
        recyclerView.setAdapter(carAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void returnReserva (View r){
        startActivity(new Intent(Scene04.this, Scene02.class));
        finish();
    }

    @Override
    public void OnItemClick(int position) {
        Bundle extras = getIntent().getExtras();
        String value = "";
        String value1 = "";
        if (extras != null) {
            value = extras.getString("checkin");
            value1 = extras.getString("checkout");
        }

        Intent i = new Intent(Scene04.this, Scene05.class);
        i.putExtra("checkin", value);
        i.putExtra("checkout", value1);
        i.putExtra("carid", cars.get(position).id);
        startActivity(i);
        finish();
    }
}