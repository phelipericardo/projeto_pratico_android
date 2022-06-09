package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class Scene05 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene05);
    }
    public void returnAvalible (View v) {
        startActivity(new Intent(Scene05.this, Scene04.class));
        finish();
    }
    public void order (View v) {
        startActivity(new Intent(Scene05.this, Scene06.class));
        finish();
    }



    // se vcê preferir buscar algum valor do botao para verificar se deixa ou não a variavel true, so apagar a funcao e mudar no botao
    public void orderInsurance (View v) {
        // Essa função tem que fazer algo continuar true até o final da ordem
        startActivity(new Intent(Scene05.this, Scene06.class));
        finish();
    }
}