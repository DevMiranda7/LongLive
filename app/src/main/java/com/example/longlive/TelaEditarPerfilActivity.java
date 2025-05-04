package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaEditarPerfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);


        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);

        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaEditarPerfilActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
        Button btnRegistrar = findViewById(R.id.btnSalvar);
        btnRegistrar.setOnClickListener(v -> {

        });
    }
}


