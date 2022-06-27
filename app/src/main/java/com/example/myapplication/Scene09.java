package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.classes.Car;
import com.example.myapplication.classes.Reserva;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.CarDao;
import com.example.myapplication.model.DateConverter;
import com.example.myapplication.model.ReservaDao;

public class Scene09 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene09);

        Bundle extras = getIntent().getExtras();
        int reservaid = -1;
        if (extras != null) {
            reservaid = extras.getInt("reservaid");
        }

        AppDatabase db = AppDatabase.getInstance(this);
        ReservaDao dao = db.reservadao();
        CarDao cardao = db.cardao();

        Reserva reserva = dao.buscarPorId(reservaid);

        Car carro = cardao.buscarPorId(reserva.carroId);

        TextView view = findViewById(R.id.reserva_id_reserva);
        view.setText(Integer.toString(reserva.id));

        view = findViewById(R.id.car_title);
        view.setText(carro.title);

        view = findViewById(R.id.car_door_amount);
        view.setText(String.valueOf(carro.door));

        view = findViewById(R.id.car_offer_paid_value);

        view.setText(Double.toString(carro.price));
        view = findViewById(R.id.check_in);

        view.setText(reserva.dataInicioReserva.toString());
        view = findViewById(R.id.check_out);
        view.setText(reserva.dataFimReserva.toString());


    }
    public void goHome (View v) {
        startActivity(new Intent(Scene09.this, Scene03.class));

        finish();
    }

    public void cancelar (View v) {

        AppDatabase db = AppDatabase.getInstance(this);
        ReservaDao dao = db.reservadao();
        TextView view = findViewById(R.id.reserva_id_reserva);
        dao.deleteWhere(Integer.parseInt(view.getText().toString()));

        startActivity(new Intent(Scene09.this, Scene03.class));

        finish();
    }

}