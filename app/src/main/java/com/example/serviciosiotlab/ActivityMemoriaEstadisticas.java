package com.example.serviciosiotlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityMemoriaEstadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memoria_estadisticas);
        getSupportActionBar().setTitle("Juego - Memoria");

        Intent intent = getIntent();
        ArrayList<String> estadisticas = intent.getStringArrayListExtra("estadisticas");
        if (estadisticas != null && !estadisticas.isEmpty()) {
            String estadisticasStr = "";
            for (String i : estadisticas) {
                estadisticasStr = estadisticasStr + i + '\n';
            }
            TextView textView = findViewById(R.id.textStatsTic);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            textView.setText(estadisticasStr);
        }
    }

    public void nuevoJuego(View view) {
        Intent intent = new Intent(this, MainActivityMemoria.class);
        intent.putExtra("nuevoJuego", 1);
        startActivity(intent);
    }

}
