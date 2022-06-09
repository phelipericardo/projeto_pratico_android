package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Lib;

public class Scene02 extends AppCompatActivity {

//    private FusedLocationProviderClient fusedLocationClient;
    private TextView dateLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene02);

        EditText etDate = (EditText) findViewById(R.id.data_retirada);
        etDate.addTextChangedListener(Lib.insert("##/##/####", etDate));

        EditText etDateB = (EditText) findViewById(R.id.data_entrada);
        etDateB.addTextChangedListener(Lib.insert("##/##/####", etDateB));

        Spinner spinnerCidades = findViewById(R.id.data_location);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cidades, R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_item);
        spinnerCidades.setAdapter(adapter);
    }
    public void returnToMainButton (View r){
        startActivity(new Intent(Scene02.this, Scene01.class));
        finish();
    }
    public void carSearch (View r){
        EditText editText = findViewById(R.id.data_retirada);
        EditText editTextB = findViewById(R.id.data_entrada);

        if(editText.getText().length()==0) {
            editText.setError("Você deve preencher uma data para retirada");
            return;
        }
        if(editTextB.getText().length()==0) {
            editTextB.setError("Você deve preencher uma data para entrega");
            return;
        }
        if (!(Lib.isDateValid(editText.getText().toString()))){
            editText.setError("Você deve preencher com uma data válida");
            return;
        }
        if (!(Lib.isDateValid(editTextB.getText().toString()))){
            editTextB.setError("Você deve preencher com uma data válida");
            return;
        }
            startActivity(new Intent(Scene02.this, Scene04.class));
            finish();
    }
}