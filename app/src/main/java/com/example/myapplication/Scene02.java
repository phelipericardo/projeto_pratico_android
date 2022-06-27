package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemeUtils;
import androidx.cardview.widget.CardView;

import com.example.myapplication.classes.Car;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.AppDatabase;
import com.example.myapplication.model.CarDao;
import com.example.myapplication.model.DateConverter;
import com.example.myapplication.model.Lib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Scene02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.scene02);

        //mask data
        EditText etDate = (EditText) findViewById(R.id.data_retirada);
        etDate.addTextChangedListener(Lib.insert("##/##/####", etDate));

        EditText etDateB = (EditText) findViewById(R.id.data_entrada);
        etDateB.addTextChangedListener(Lib.insert("##/##/####", etDateB));




        AppDatabase db = AppDatabase.getInstance(this);
        CarDao dao = db.cardao();
        List<Car> cars = dao.getAll();


        CardView button = (CardView) findViewById(R.id.button_search_car);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!cars.isEmpty()) {
                    EditText editText = findViewById(R.id.data_retirada);
                    EditText editTextB = findViewById(R.id.data_entrada);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date d = null,db = null;
                    try {
                        d = dateFormat.parse(etDate.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    try {
                        db = dateFormat.parse(etDateB.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

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

                    if (d.before(db)) {
                        Intent i = new Intent(Scene02.this, Scene04.class);

                        i.putExtra("checkin", editText.getText().toString());
                        i.putExtra("checkout", editTextB.getText().toString());
                        startActivity(i);
                        finish();
                    } else {
                        editText.setError("Você deve preencher com uma data válida");
                        return;
                    }

                }
            }
        });
    }

    public void returnToMainButton (View r){
        startActivity(new Intent(Scene02.this, Scene01.class));
        finish();
    }
    public void carSearch (View r){

    }
}