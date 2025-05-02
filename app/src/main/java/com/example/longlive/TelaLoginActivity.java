package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Define o layout da tela de login

        // 1) Referência ao botão "Voltar" (imagem) que permite voltar para a tela principal
        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);

        // 2) Configuração do click listener para o botão de "voltar"
        btnAbrirRetornar.setOnClickListener(v -> {
            // 3) Quando o botão é clicado, a aplicação cria uma Intent para navegar de volta para a MainActivity
            Intent intent = new Intent(TelaLoginActivity.this, MainActivity.class);

            // 4) Inicia a nova tela (MainActivity)
            startActivity(intent);

            // 5) Finaliza a tela atual (TelaLoginActivity) para que ela não permaneça na pilha de atividades
            finish();
        });
    }
}
