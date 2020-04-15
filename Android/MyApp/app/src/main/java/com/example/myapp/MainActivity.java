package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView txtSaluta;
    private Button btnSaluta, btnAltobasso, btnAccelerometro, btnFotocamera, btnTris;
    private boolean stato = true;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Collego componenti grafiche
        bindComponents();
        // Collego Listener per gestione eventi
        setupEventListener();
    }

    private void bindComponents(){
        //assegna ad una variabile i componenti di activity_main
        txtSaluta = findViewById(R.id.lblTitolo);
        btnSaluta = findViewById(R.id.btnSaluta);
        btnAltobasso = findViewById(R.id.btnAltobasso);
        btnAccelerometro = findViewById(R.id.btnAccel);
        btnFotocamera = findViewById(R.id.btnFoto);
        btnTris = findViewById(R.id.btnTris);
        text = (String) txtSaluta.getText();
    }

    private void setupEventListener(){
        btnSaluta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaluta.setText("Ciao Gianlu");
            }
        });
        //al click su questi button si apre una nuova activity
        btnAltobasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AltobassoActivity.class);
                startActivity(intent);
            }
        });
        btnAccelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccActivity.class);
                startActivity(intent);
            }
        });
        btnFotocamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(MainActivity.this, FotoActivity.class);
                // startActivity(intent);
            }
        });
        btnTris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrisActivity.class);
                intent.putExtra("g1", "Luca");
                intent.putExtra("g2", "Giorgio");
                startActivity(intent);
            }
        });
    }
}