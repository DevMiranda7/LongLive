package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaContatosProfissionais extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissionais); // Define o layout da tela de registro


        ImageButton btnAbrirRetornar = findViewById(R.id.id_voltarInicio);
        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaContatosProfissionais.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
