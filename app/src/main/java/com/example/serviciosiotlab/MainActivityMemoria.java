package com.example.serviciosiotlab;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivityMemoria extends AppCompatActivity {

   public ArrayList<String> memoriaEstadistica = new ArrayList<>();
   private ArrayList<Button> presionarBotones = new ArrayList<>();
   Integer[] botones =new Integer[] {R.id.btna1,R.id.btnb1,R.id.btnc1,R.id.btnd1,R.id.btna2,R.id.btnb2,R.id.btnc2,R.id.btnd2,R.id.btna3,R.id.btnb3,R.id.btnc3,R.id.btnd3,R.id.btna4,R.id.btnb4,R.id.btnc4,R.id.btnd4};
   private int contador;
    private HashMap<Button,String> letraBoton = new HashMap<>();
   private Instant instantInicio, instantFin;

    //varibales
    //ArrayList<Integer> letrasdesordenadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memoria);
        getSupportActionBar().setTitle("Inicio");
        iniciarJuego();
        Intent intent = getIntent();
        int i = intent.getIntExtra("Nuevo Inicio",0);
        if (i == 1) {
            cargarletras();
        }

    }

    private void cargarletras(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            instantInicio = Instant.now();
        }

        ArrayList<String> letras = new ArrayList<>();
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        letras.add("E");
        letras.add("F");
        letras.add("G");
        letras.add("H");

        contador=0;
        presionarBotones.clear();
        letraBoton.clear();;

        ArrayList<String> letras1 = new ArrayList<>();
        for (String letras2 : letras ){
            letras1.add(letras2);
            letras1.add(letras2);
        }

        Collections.shuffle(letras1);

        for(int i=0; i<botones.length; i++){
            Button boton = (Button) findViewById(botones[i]);
            letraBoton.put(boton,letras1.get(i));
            boton.setText(String.valueOf(letras1.get(i)));
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cargarBotones();
            }
        }, 1000);

    }

    private void cargarBotones(){
        for(int i=0;i<botones.length;i++){
            Button boton = (Button) findViewById(botones[i]);
            boton.setText("-");
        }
    }

    public void colocarletra(View view) {

        if (contador < 2) {
            Button boton1 = (Button) view;
            String letraBTN = letraBoton.get(boton1);

            if (letraBoton != null) {

                presionarBotones.add(boton1);
                boton1.setText(String.valueOf(letraBTN));
                contador++;

                if (presionarBotones.size() == 2) {

                    if (presionarBotones.get(0).getId() != presionarBotones.get(1).getId()) {
                        String letraA = letraBoton.get(presionarBotones.get(0));
                        String letraB = letraBoton.get(presionarBotones.get(1));

                        if (letraA.equalsIgnoreCase(letraB)) {
                            // Pares Iguales
                            letraBoton.remove(presionarBotones.get(0));
                            letraBoton.remove(presionarBotones.get(1));

                        } else {
                            // Pares Diferentes
                            Button boton1A = presionarBotones.get(0);
                            Button boton1B = presionarBotones.get(1);

                            Handler handler1 = new Handler();
                            handler1.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    boton1A.setText("-");
                                    boton1B.setText("-");
                                }
                            }, 350);
                        }
                    }else {
                        presionarBotones.get(0).setText("-");

                    }
                    presionarBotones.clear();
                    contador=0;
                }
                if(letraBoton.size()==0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        instantFin = Instant.now();
                    }
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        long seconds = instantFin.getEpochSecond() - instantInicio.getEpochSecond();

//                        if (seconds < 60){
                        String tiempoJuego = "Terminó en " + Math.round((seconds/60.0)*100.0)/100.0 + " minutos";

                        String estadisticas = "Juego " + (memoriaEstadistica.size() + 1) + " : " + tiempoJuego;
                        memoriaEstadistica.add(estadisticas);

                        TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                        cronometro.setText(tiempoJuego);
                    }
                }
            }
        }
    }

    public void iniciarJuego(){
        cargarletras();
    }

    public void reiniciarJuego(View view){

        if(letraBoton.size() != 0){
            String estadisticas = "Juego " + (memoriaEstadistica.size() + 1) + " : " + "Canceló";
            memoriaEstadistica.add(estadisticas);
        }
        cargarletras();
    }

    public void abrirEstadisticas(View view) {
        Intent intent = new Intent(this, ActivityMemoriaEstadisticas.class);
        intent.putExtra("estadisticas", memoriaEstadistica);
        startActivity(intent);
    }

}