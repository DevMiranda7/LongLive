package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1) Habilita o modo "Edge-to-Edge", que usa toda a tela (incluindo áreas do sistema como a barra de status)
        EdgeToEdge.enable(this);

        // 2) Define o layout para esta atividade
        setContentView(R.layout.activity_main);

        // 3) Ajusta o preenchimento (padding) do layout para levar em consideração as barras do sistema (como a barra de status e a de navegação)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Obtém as áreas do sistema (barras de status e navegação)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Ajusta o padding da view para evitar sobreposição com essas barras
            return insets; // Retorna os insets para o sistema
        });

        // 4) Configura o botão para abrir a tela de registro
        Button btnAbrirRegistro = findViewById(R.id.id_registro);
        btnAbrirRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TelaRegistroActivity.class); // Cria uma intenção para abrir a tela de registro
            startActivity(intent); // Inicia a atividade de registro
        });

        // 5) Configura o botão para abrir a tela de login
        Button btnAbrirLogin = findViewById(R.id.id_login);
        btnAbrirLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TelaLoginActivity.class); // Cria uma intenção para abrir a tela de login
            startActivity(intent); // Inicia a atividade de login
        });
    }
}
