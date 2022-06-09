package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

public class Scene01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene01);

    }
    public void searchButton (View r){
        startActivity(new Intent(Scene01.this, Scene02.class));
        finish();
    }
    public void appointmentButton (View r){
        startActivity(new Intent(Scene01.this, Scene03.class));
        finish();
    }
}