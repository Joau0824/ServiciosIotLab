package com.example.serviciosiotlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityTresEnRaya extends AppCompatActivity {

    //TextView WinnerText;
    //Integer[] buttons; //array de enteros

    /*int[] tablero = new int[]{ //array de enteros
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
    };

    int estado = 10; //-1 -> gana x; 1 -> gana O; 0 -> empate
    int fichas = 0;
    int turno = 1; //quien coloco la ultima ficha
    int[] gana = new int[]{-1,-1,-1}; //array de enteros, que conteiene las posiciones de la juagada ganadora

    public ArrayList<String> estadisticasTresEnRaya = new ArrayList();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tres_en_raya);
        getSupportActionBar().setTitle("Inicio");

        //WinnerText = (TextView) findViewById(R.id.WinnerText);
        //WinnerText.setVisibility(View.INVISIBLE);

        /*buttons = new Integer[]{
                R.id.b1, R.id.b2, R.id.b3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.b7, R.id.b8, R.id.b9,
        };

        Intent intent = getIntent();
        int i = intent.getIntExtra("nuevoJuego",0);
        if (i == 1) {
            rebootGame();
        }*/

        //Descomentar para ver un ejemplo de cómo se verian las estadisticas
//        estadisticasTic.add("Juego 1 : Ganó X");
//        estadisticasTic.add("Juego 2 : Canceló");
//        estadisticasTic.add("Juego 3 : Ganó O");
//        estadisticasTic.add("Juego 4 : Empate");
    }

    /*public void selectficha(View view){
        Button button = (Button) view;
        if(estado == 0){ //jugando

            int numBoton = Arrays.asList(buttons).indexOf(view.getId());

            if(tablero[numBoton] == 0){
                if (turno == 1) {
                    turno = -1;
                    tablero[numBoton] = -1;
                    button.setText("X");

                    fichas += 1;
                    estado = comprobarEstado();
                    System.out.println("test1");
                    System.out.println(estado);
                    Log.d("msg", Integer.toString(estado));
                    terminarPartida();
                    return;
                }
                if (turno == -1){
                    turno = 1;
                    tablero[numBoton] = 1;
                    //view.setBackgroundResource(R.drawable.circle_icon);
                    button.setText("O");

                    fichas += 1;
                    estado = comprobarEstado();
                    System.out.println("test2");
                    System.out.println(estado);
                    Log.d("msg", Integer.toString(estado));
                    terminarPartida();
                    return;
                }
            }
        }
    }

    public int comprobarEstado(){
        int nuevoEstado = 0;
        if(Math.abs(tablero[0]+tablero[1]+tablero[2])==3){
            gana = new int[]{0,1,2};
            nuevoEstado = 1*turno;

        }
        else if(Math.abs(tablero[3]+tablero[4]+tablero[5]) == 3){
            gana = new int[]{3,4,5};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[6]+tablero[7]+tablero[8]) == 3){
            gana = new int[]{6,7,8};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[0]+tablero[3]+tablero[6]) == 3){
            gana = new int[]{0,3,6};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[1]+tablero[4]+tablero[7]) == 3){
            gana = new int[]{1,4,7};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[2]+tablero[5]+tablero[8]) == 3){
            gana = new int[]{2,5,8};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[0]+tablero[4]+tablero[8]) == 3){
            gana = new int[]{0,4,8};
            nuevoEstado = 1*turno;


        }
        else if(Math.abs(tablero[2]+tablero[4]+tablero[6]) == 3){
            gana = new int[]{2,4,6};
            nuevoEstado = 1*turno;

        }
        else if(fichas == 9){
            nuevoEstado = 2;

        }

        return nuevoEstado;
    }

    public void terminarPartida(){
        if(estado == 1 || estado == -1){
            if(estado == -1){
                WinnerText.setVisibility(View.VISIBLE);
                WinnerText.setText("Ganó X");
                System.out.println("aqui van los botones llenos" + buttons );
                System.out.println("aqui van los tablero llenos" + tablero );

                String estadistica = "Juego " + (estadisticasTresEnRaya.size() + 1) + " : Ganó X";
                estadisticasTresEnRaya.add(estadistica);
                estado = -10;

            }else{
                WinnerText.setVisibility(View.VISIBLE);
                WinnerText.setText("Ganó O");

                String estadistica = "Juego " + (estadisticasTresEnRaya.size() + 1) + " : Ganó O";
                estadisticasTresEnRaya.add(estadistica);
                estado = -10;
            }
        }
        else if(estado == 2){
            WinnerText.setVisibility(View.VISIBLE);
            WinnerText.setText("Empate");

            String estadistica = "Juego " + (estadisticasTresEnRaya.size() + 1) + " : Empate";
            estadisticasTresEnRaya.add(estadistica);
            estado = -10;
        }

    }

    public void nuevo(View view){

        if (estado == 0) {
            String estadistica = "Juego " + (estadisticasTresEnRaya.size() + 1) + " : Canceló";
            estadisticasTresEnRaya.add(estadistica);
        }
        rebootGame();

    }

    public void rebootGame() {
        tablero = new int[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0,
        };

        System.out.println("aqui van los botones vacios" + buttons );
        System.out.println("aqui van los tablero vacio" + tablero );

        estado = 0; //veremos que -1 cuando gana x
        //1 cunado gana el o
        //0 cuando hay empate
        fichas = 0;
        turno = 1; //indica quien coloco la ultima ficha,para determinar el ganador
        gana = new int[]{-1,-1,-1}; //array de enteros, que contiene las posiciones de la juagada ganadora

        Button btn1 = (Button) findViewById(R.id.b1);
        btn1.setText("-");
        Button btn2 = (Button) findViewById(R.id.b2);
        btn2.setText("-");
        Button btn3 = (Button) findViewById(R.id.b3);
        btn3.setText("-");
        Button btn4 = (Button) findViewById(R.id.b4);
        btn4.setText("-");
        Button btn5 = (Button) findViewById(R.id.b5);
        btn5.setText("-");
        Button btn6 = (Button) findViewById(R.id.b6);
        btn6.setText("-");
        Button btn7 = (Button) findViewById(R.id.b7);
        btn7.setText("-");
        Button btn8 = (Button) findViewById(R.id.b8);
        btn8.setText("-");
        Button btn9 = (Button) findViewById(R.id.b9);
        btn9.setText("-");
        WinnerText.setVisibility(View.INVISIBLE);

        estado = 0;
    }

    public void openTresEnRayaEstadisticas(View view) {
        Intent intent = new Intent(this, ActivityTresEnRayaEstadisticas.class);
        intent.putExtra("estadisticas", estadisticasTresEnRaya);
        startActivity(intent);
    }*/

}
