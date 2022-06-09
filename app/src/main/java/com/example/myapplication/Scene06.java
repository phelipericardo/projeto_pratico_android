package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Lib;

public class Scene06 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene06);



        // escuta e preenche a Mascara do numero
        EditText editTextNumero = (EditText) findViewById(R.id.numero_editText_cadastro);
        editTextNumero.addTextChangedListener(Lib.insert("(##)#####-####", editTextNumero));

        // escuta e preenche a Mascara do CPF
        EditText etDate = (EditText) findViewById(R.id.cpf_editText_cadastro);
        etDate.addTextChangedListener(Lib.insert("###.###.###-##", etDate));
    }

    public void returnDetail (View v) {
        startActivity(new Intent(Scene06.this, Scene05.class));
        finish();
    }
    public void payment (View v) {
        //valida CPF
        EditText editText = findViewById(R.id.cpf_editText_cadastro);
        if(editText.getText().length()==0) {
            editText.setError("O campo de CPF não pode estar vázio");
            return;
        }
        if(!(Lib.isCPF(editText.getText().toString()))) {
            editText.setError("Você deve preencher com um CPF válido");
            return;
        }
        //Valida email
        EditText email = findViewById(R.id.email_editText_cadastro);
        if(email.getText().length()==0) {
            email.setError("O campo de email não pode estar vázio");
            return;
        }
        if(!(Lib.isValidEmail(email.getText().toString()))) {
            email.setError("Você deve preencher com um email válido");
            return;
        }
        //valida nome
        EditText editTextName = findViewById(R.id.nome_editText_cadastro);
        if(editTextName.getText().length()==0) {
            editTextName.setError("O campo de nome não pode estar vázio");
            return;
        }
        //valida número
        EditText editTextNumero = findViewById(R.id.numero_editText_cadastro);
        if(editTextNumero.getText().length()==0) {
            editTextNumero.setError("O campo de número não pode estar vázio");
            return;
        }
        if(!(Lib.isValidNumber(editTextNumero.getText().toString()))) {
            editTextNumero.setError("Você deve preencher com um número válido");
            return;
        }

        startActivity(new Intent(Scene06.this, Scene07.class));
        finish();
    }
}