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

    public ArrayList<String> estadisticasMemo = new ArrayList();
    private HashMap<Button,String> btnLetra = new HashMap<>();
    private final int[] botonesID = {R.id.btna1,R.id.btna2,R.id.btna3,R.id.btna4,R.id.btnb1,R.id.btnb2,R.id.btnb3,
            R.id.btnb4,R.id.btnc1,R.id.btnc2,R.id.btnc3,R.id.btnc4,R.id.btnd1,R.id.btnd2,R.id.btnd3,R.id.btnd4};
    private Instant instantStarted, instantStopped;
    private int contadorElecciones;
    private ArrayList<Button> btnElecciones = new ArrayList<>();

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    Button[] tablero = new Button[16];
    Button botonNuevo;
    String[] letras;
    //varibales
    //ArrayList<Integer> letrasdesordenadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_memoria);
        iniciar();
    }
    private void cargarTablero(){
        btn1 = findViewById(R.id.btna1);
        btn2 = findViewById(R.id.btnb1);
        btn3 = findViewById(R.id.btnc1);
        btn4 = findViewById(R.id.btnd1);

        btn5 = findViewById(R.id.btna2);
        btn6 = findViewById(R.id.btnb2);
        btn7 = findViewById(R.id.btnc2);
        btn8 = findViewById(R.id.btnd2);

        btn9 = findViewById(R.id.btna3);
        btn10 = findViewById(R.id.btnb3);
        btn11 = findViewById(R.id.btnc3);
        btn12 = findViewById(R.id.btnd3);

        btn13 = findViewById(R.id.btna4);
        btn14 = findViewById(R.id.btnb4);
        btn15 = findViewById(R.id.btnc4);
        btn16 = findViewById(R.id.btnd4);

        tablero[0]=btn1;
        tablero[1]=btn2;
        tablero[2]=btn3;
        tablero[3]=btn4;
        tablero[4]=btn5;
        tablero[5]=btn6;
        tablero[6]=btn7;
        tablero[7]=btn8;
        tablero[8]=btn9;
        tablero[9]=btn10;
        tablero[10]=btn11;
        tablero[11]=btn12;
        tablero[12]=btn13;
        tablero[13]=btn14;
        tablero[14]=btn15;
        tablero[15]=btn16;
    }

    private void cargarBotones(){
        botonNuevo=findViewById(R.id.btn_nuevoMem3);
        botonNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar();
            }
        });
    }

    private void cargarletras(){
    }

    private ArrayList<Integer> barajar(int longitud){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            result.add(i % longitud);
        }
        Collections.shuffle(result);
       return result;
    }

    private void iniciar(){
        cargarTablero();
        cargarBotones();
        cargarletras();
    }

    public void extraerLetraBoton(View view){
        if(contadorElecciones < 2){
            Button boton = (Button) view;
            String letra = btnLetra.get(boton);

            if(letra != null) {
                btnElecciones.add(boton);
                boton.setText(String.valueOf(letra));
                contadorElecciones++;

                if (btnElecciones.size() == 2) {

                    if(btnElecciones.get(0).getId() != btnElecciones.get(1).getId()) {
                        String letra1 = btnLetra.get(btnElecciones.get(0));
                        String letra2 = btnLetra.get(btnElecciones.get(1));

                        if (letra1.equalsIgnoreCase(letra2)) {
                            // Letras iguales
                            btnLetra.remove(btnElecciones.get(0));
                            btnLetra.remove(btnElecciones.get(1));

                        } else {
                            // Letras diferentes
                            Button btn1Selec = btnElecciones.get(0);
                            Button btn2Selec = btnElecciones.get(1);

                            Handler handler1 = new Handler();
                            handler1.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    btn1Selec.setText("-");
                                    btn2Selec.setText("-");
                                }
                            }, 500);

                        }
                    }else{
                        btnElecciones.get(0).setText("-");
                    }
                    btnElecciones.clear();
                    contadorElecciones = 0;
                }

                if (btnLetra.size() == 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        instantStopped = Instant.now();
                    }

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        long seconds = instantStopped.getEpochSecond() - instantStarted.getEpochSecond();


                        Log.d("msg", String.valueOf(seconds));
                        String tiempo = "Terminó en " + Math.round((seconds/60.0)*100.0)/100.0 + " minutos";

                        String estadistica = "Juego " + (estadisticasMemo.size() + 1) + " : " + tiempo;
                        estadisticasMemo.add(estadistica);

                        TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                        cronometro.setText(tiempo);
                    }
                }
            }
        }
    }

    public void openMemoriaEstadisticas(View view) {
        Intent intent = new Intent(this, ActivityMemoriaEstadisticas.class);
        intent.putExtra("estadisticas", estadisticasMemo);
        startActivity(intent);
    }
    public void inicioMemo(){
        for(int i=0;i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            botoncito.setText("-");
        }
    }
    public void memoInitalize(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            instantStarted = Instant.now();
        }

        contadorElecciones = 0;
        btnElecciones.clear();
        btnLetra.clear();
        TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
        cronometro.setText("");

        ArrayList<String> letrasMemoria = new ArrayList<>();
        letrasMemoria.add("A");
        letrasMemoria.add("B");
        letrasMemoria.add("C");
        letrasMemoria.add("D");
        letrasMemoria.add("E");
        letrasMemoria.add("F");
        letrasMemoria.add("G");
        letrasMemoria.add("H");

        ArrayList<String> letritas = new ArrayList<>();
        for(String letras : letrasMemoria){
            letritas.add(letras);
            letritas.add(letras);
        }

        Collections.shuffle(letritas);

        for(int i=0; i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            btnLetra.put(botoncito,letritas.get(i));
            botoncito.setText(String.valueOf(letritas.get(i)));
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                inicioMemo();
            }
        }, 1000);
    }

    public void rebootJuego(View view){

        if(btnLetra.size() != 0){
            String estadistica = "Juego " + (estadisticasMemo.size() + 1) + " : " + "Canceló";
            estadisticasMemo.add(estadistica);
        }
        memoInitalize();
    }

}