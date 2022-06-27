package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.classes.Reserva;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.Lib;
import com.example.myapplication.model.ReservaDao;

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

        if(editText.getText().length()==0) {
            editText.setError("O campo de CPF não pode estar vázio");
            return;
        }
        if(!(Lib.isCPF(editText.getText().toString()))) {
            editText.setError("Você deve preencher com um CPF válido");
            return;
        }

        AppDatabase db = AppDatabase.getInstance(this);
        ReservaDao dao = db.reservadao();

        EditText txt = findViewById(R.id.cpf_editText);

        String stringid = Lib.unmask(txt.getText().toString());

        Reserva reserva = dao.buscarReserva(stringid);

        if (reserva != null){
                Intent i = new Intent(Scene03.this, Scene09.class);
                i.putExtra("reservaid", reserva.id);
                startActivity(i);
                finish();
            }
        }
}