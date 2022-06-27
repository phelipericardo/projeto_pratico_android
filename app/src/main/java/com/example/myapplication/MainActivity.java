package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.classes.Car;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.CarDao;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        AppDatabase db = AppDatabase.getInstance(this);
        CarDao dao = db.cardao();

        Car aluno = new Car(1,"Flex One",(400.0),1,1,4,4, 1, "livre");
        dao.insertAll(aluno);
        Car aluno1 = new Car(2,"LXS 16",350.0,3,1,4,4, 1, "livre");
        dao.insertAll(aluno1);
        Car aluno2 = new Car(3,"Golf",700.0,4,1,4,4, 2, "livre");
        dao.insertAll(aluno2);
        Car aluno3 = new Car(4,"Honda Civic",200.0,2,1,4,4, 2, "livre");
        dao.insertAll(aluno3);
        Car aluno4 = new Car(5,"Chevrolet Onix",1.0,1,1,1,1, 1, "livre");
        dao.insertAll(aluno4);
        Car aluno5 = new Car(6,"Chevrolet Tracker 1.0",840.0,3,1,1,1, 3, "livre");
        dao.insertAll(aluno5);
        Car aluno6 = new Car(7,"Ford EcoSport",760.0,1,2,2,1, 3, "livre");
        dao.insertAll(aluno6);
        Car aluno7 = new Car(8,"Honda HR-V Touring",550.0,5,1,1,1, 4, "livre");
        dao.insertAll(aluno7);
        Car aluno8 = new Car(9,"Suzuki S-Cross",1000.0,1,1,1,4, 4, "livre");
        dao.insertAll(aluno8);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, Scene01.class));
            finish();
        }, 2000);
    }
}