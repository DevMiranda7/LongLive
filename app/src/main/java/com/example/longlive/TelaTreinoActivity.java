package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaTreinoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diasde_treino);


        ImageButton btnAbrirRetornar = findViewById(R.id.id_voltarInicio);

        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaTreinoActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });

        Button btnPeitoral = findViewById(R.id.buttonPeitoral);

        Button btnCostas   = findViewById(R.id.buttonCostas);

        Button btnPerna    = findViewById(R.id.buttonPerna);

        Button btnBraco    = findViewById(R.id.buttonBraco);

        Button btnAbs      = findViewById(R.id.buttonAbs);

        Button btnOmbro    = findViewById(R.id.buttonOmbro);


    }
}
