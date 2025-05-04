package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaSeusDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seus_dados); // Associa o XML de layout

        ImageButton botaoVoltar = findViewById(R.id.id_voltarInicio);
        botaoVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaSeusDadosActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish(); //
        });


    }
}
