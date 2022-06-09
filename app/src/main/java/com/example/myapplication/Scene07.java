package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Lib;

public class Scene07 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene07);

        EditText nomeTitular = (EditText) findViewById(R.id.cartao_titular_nome);
        nomeTitular.addTextChangedListener(Lib.insert("################", nomeTitular));

        EditText numeroCartao = (EditText) findViewById(R.id.cartao_titular_numero);
        numeroCartao.addTextChangedListener(Lib.insert("####-####-####-####", numeroCartao));

        EditText dataValidade = (EditText) findViewById(R.id.cartao_titular_data);
        dataValidade.addTextChangedListener(Lib.insert("##/##/####", dataValidade));

        EditText numeroCvc = (EditText) findViewById(R.id.cartao_titular_cvc);
        numeroCvc.addTextChangedListener(Lib.insert("###", numeroCvc));

    }
    public void terms (View v) {
        startActivity(new Intent(Scene07.this, Scene10.class));
        finish();
    }
    public void returnDetail (View v) {
        startActivity(new Intent(Scene07.this, Scene06.class));
        finish();
    }
    public void closeOrder (View v) {
        //CVC
        EditText editTextCvc = findViewById(R.id.cartao_titular_cvc);
        if(editTextCvc.getText().length()==0 && editTextCvc.getText().length()!=3) {
            editTextCvc.setError("Cvc inválido");
            return;
        }
        //Data
        EditText editTextData = findViewById(R.id.cartao_titular_data);
        if(editTextData.getText().length()==0) {
            editTextData.setError("Você deve preencher uma data de validade");
            return;
        }

        if (!(Lib.isDateValid(editTextData.getText().toString()))){
            editTextData.setError("Você deve preencher com uma data válida");
            return;
        }
        //numero cartão
        EditText editTextNumero = findViewById(R.id.cartao_titular_numero);
        if(editTextNumero.getText().length()!= 19) {
            editTextNumero.setError("Número do cartão inválido");
            return;
        }
        //nome titular
        EditText editTextNome = findViewById(R.id.cartao_titular_nome);
        if(editTextNome.getText().length() < 4) {
            editTextNome.setError("Você deve preencher com um nome valido");
            return;
        }

        startActivity(new Intent(Scene07.this, Scene08.class));
        finish();
    }


}