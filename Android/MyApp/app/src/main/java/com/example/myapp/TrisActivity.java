package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TrisActivity extends AppCompatActivity {
    private TextView lblTit;
    private TextView lblToccaA;
    private int mat[][];
    private boolean g1;
    Button b[][];
    Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tris);
        bindComponents();
        Intent intent;
        intent = getIntent();

        lblTit.setText(intent.getStringExtra("g1") + " VS " + intent.getStringExtra("g2"));
        g1 = true;

        mat = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                mat[i][j] = 0;
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                b[i][j].setTransitionName("button_" + i + "_" + j);
                b[i][j].setOnClickListener(new myListener());
            }
        }
        setupEventListener();
    }
    private void bindComponents(){
        lblTit = findViewById(R.id.lblTit);
        lblToccaA = findViewById(R.id.lblToccaA);
        reset = findViewById(R.id.buttonRes);

        b = new Button[3][3];
        b[0][0] = findViewById(R.id.button_0_0); //b[0][0].setTransitionName("btn_0_0");
        b[0][1] = findViewById(R.id.button_0_1); //b[0][1].setTransitionName("btn_0_1");
        b[0][2] = findViewById(R.id.button_0_2); //b[0][2].setTransitionName("btn_0_2");
        b[1][0] = findViewById(R.id.button_0_3); //b[1][0].setTransitionName("btn_1_0");
        b[1][1] = findViewById(R.id.button_0_4); //b[1][1].setTransitionName("btn_1_1");
        b[1][2] = findViewById(R.id.button_0_5); //b[1][2].setTransitionName("btn_1_2");
        b[2][0] = findViewById(R.id.button_0_6); //b[2][0].setTransitionName("btn_2_0");
        b[2][1] = findViewById(R.id.button_0_7); //b[2][1].setTransitionName("btn_2_1");
        b[2][2] = findViewById(R.id.button_0_8); //b[2][2].setTransitionName("btn_2_2");

    }

    private void setupEventListener(){
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        mat[i][j] = 0;
                        b[i][j].setBackgroundResource(R.color.colorGrigio);
                        sbloccaPulsanti();

                    }
                }

            }
        });

    }

    void bloccaPulsanti(){
       /* POSSIBILITA' 1
        b00.setEnabled(false);
        b01.setEnabled(false);
        b02.setEnabled(false);
        ....
        b22.setEnabled(false);
        */
        // POSSIBILITA' 2
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                b[i][j].setEnabled(false);
            }
        }
    }

    void sbloccaPulsanti(){
        // POSSIBILITA' 2
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                b[i][j].setEnabled(true);
            }
        }
    }

    void vince(String g){
        Toast.makeText(this, g, Toast.LENGTH_LONG).show();
    }

    class myListener implements View.OnClickListener{
        private static final String TAG = "ClassListener";
        @Override
        public void onClick(View v) {
            int x, y;
            boolean vittoria;
            Intent intent;
            intent = getIntent();
            // 1. rintracciare pulsante chiamante
            Button bL = (Button) v;
            Log.i(TAG, String.valueOf(bL.getTransitionName()));
            // 2. assegno a x y le coordinate lette dal Button
            x = Integer.parseInt(bL.getTransitionName().split("_")[1]);
            y = Integer.parseInt(bL.getTransitionName().split("_")[2]);

            if(g1){
                lblToccaA.setText("Tocca a : " + intent.getStringExtra("g1"));
                mat[x][y] = 1;
                g1 = false;
                bL.setBackgroundResource(R.color.colorBlu);
            }else{
                lblToccaA.setText("Tocca a : " + intent.getStringExtra("g2"));
                mat[x][y] = 2;
                g1 = true;
                bL.setBackgroundResource(R.color.colorArancio);
            }
            bL.setEnabled(false); // disabilitiamo il click del pulsante


            // stampo matrice
            for(int i=0; i<3; i++){
                Log.d("", String.valueOf(mat[i][0]) + " " + String.valueOf(mat[i][1]) + " " + String.valueOf(mat[i][2]));
            }
            // -------

            vittoria = false;
            // Controllo Vittoria

            // VERTICALE
            if(mat[0][y] == mat[x][y] && mat[1][y] == mat[x][y] && mat[2][y] == mat[x][y]){
                // vittoria verticale
                vittoria = true;
            }else{
                // ORIZZONTALE
                if(mat[x][0] == mat[x][y] && mat[x][1] == mat[x][y] && mat[x][2] == mat[x][y]){
                    // vittoria orizzontale
                    vittoria = true;
                }else{
                    // Diagonale principale
                    if(mat[0][0] == mat[x][y] && mat[1][1] == mat[x][y] && mat[2][2] == mat[x][y]){
                        // Vittoria diagonale p.
                        vittoria = true;
                    }else if(mat[0][2] == mat[x][y] && mat[1][1] == mat[x][y] && mat[2][0] == mat[x][y]){// Diagonale secondaria
                        // Vittoria diagonale s.
                        vittoria = true;
                    }
                }
            }
            if(vittoria){
                if(!g1){ // ho già invertito giocatore 1 con giocatore 2
                    Log.d(TAG, "VINCE : " + intent.getStringExtra("g1"));
                    vince("VINCE : " + intent.getStringExtra("g1"));
                }else{
                    Log.d(TAG, "VINCE : " + intent.getStringExtra("g2"));
                    vince("VINCE : " + intent.getStringExtra("g2"));
                }
                bloccaPulsanti();
            }



        }
    }
}
