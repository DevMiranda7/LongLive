package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaInformacoesFisicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_fisicas); // Define o layout da tela de registro

        // 1) Referência ao botão "Voltar" (imagem) que permite voltar para a tela principal
        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);
        // 2) Configuração do click listener para o botão de "voltar"
        btnAbrirRetornar.setOnClickListener(v -> {

            Intent intent = new Intent(TelaInformacoesFisicasActivity.this, TelaRegistroActivity.class);

            startActivity(intent);

            finish();
        });
        Button btnRegistrar = findViewById(R.id.buttonRegistrarr);

        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaInformacoesFisicasActivity.this, TelaLogadoActivity.class);

            startActivity(intent);
            finish();
        });
    }
}

