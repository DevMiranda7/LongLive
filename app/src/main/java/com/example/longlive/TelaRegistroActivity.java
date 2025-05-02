package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaRegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro); // Define o layout da tela de registro

        // 1) Referência ao botão "Voltar" (imagem) que permite voltar para a tela principal
        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);
        // 2) Configuração do click listener para o botão de "voltar"
        btnAbrirRetornar.setOnClickListener(v -> {
            // 3) Quando o botão de voltar é clicado, a aplicação cria uma Intent para navegar de volta para a MainActivity
            Intent intent = new Intent(TelaRegistroActivity.this, MainActivity.class);

            // 4) Inicia a MainActivity (tela principal)
            startActivity(intent);

            // 5) Finaliza a TelaRegistroActivity para que ela não permaneça na pilha de atividades
            finish();
        });

        // 6) Referência ao botão de "Registrar"
        Button btnRegistrar = findViewById(R.id.buttonRegistrar);

        // 7) Configuração do click listener para o botão de "Registrar"
        btnRegistrar.setOnClickListener(v -> {
            // 8) Quando o botão de registrar é clicado, a aplicação cria uma Intent para navegar para a TelaLogadoActivity
            Intent intent = new Intent(TelaRegistroActivity.this, TelaLogadoActivity.class);

            // 9) Inicia a TelaLogadoActivity (onde o usuário estará logado após o registro)
            startActivity(intent);
        });
    }
}
