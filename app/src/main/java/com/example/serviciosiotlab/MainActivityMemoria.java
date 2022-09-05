package com.example.serviciosiotlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivityMemoria extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    Button[] tablero = new Button[16];
    Button botonNuevo;
    int[] imagenes;
    //letras
    //varibales
    ArrayList<String> letrasdesordenadas;

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
        imagenes=new int[]{
               R.drawable.ic_action_A
        };
    }



    private void iniciar(){
        cargarTablero();
        cargarBotones();
    }
}