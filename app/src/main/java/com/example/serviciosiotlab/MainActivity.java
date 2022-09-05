package com.example.serviciosiotlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);

    }

    public void openMemoria (View view){
        Intent intent = new Intent(this, MainActivityMemoria.class);
        startActivity(intent);
    }

    public void openTresEnRaya (View view){
        Intent intent = new Intent(this, MainActivityTresEnRaya.class);
        startActivity(intent);
    }
}