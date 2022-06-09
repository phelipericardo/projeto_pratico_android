package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Lib;

public class Scene03 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene03);

        EditText etDate = (EditText) findViewById(R.id.cpf_editText);
        etDate.addTextChangedListener(Lib.insert("###.###.###-##", etDate));

    }

    public void returnButton (View r){
        startActivity(new Intent(Scene03.this, Scene01.class));
        finish();
    }
    public void searchForAppointment (View r){

        EditText editText = findViewById(R.id.cpf_editText);
        EditText editTextB = findViewById(R.id.reserva_n_reserva);

        if(editText.getText().length()==0) {
            editText.setError("O campo de CPF não pode estar vázio");
            return;
        }
        if(!(Lib.isCPF(editText.getText().toString()))) {
            editText.setError("Você deve preencher com um CPF válido");
            return;
        }
        if(editTextB.getText().length()==0) {
            editTextB.setError("O campo de NºReserva não pode estar vázio");
            return;
        }
        //Necessário válidar a reserva se está em formato correto, tem que definir os criterios da validação para implementar
        startActivity(new Intent(Scene03.this, Scene09.class));
        finish();
    }

}