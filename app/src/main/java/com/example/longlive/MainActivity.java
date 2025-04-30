package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Abrir tela de registro
        Button btnAbrirRegistro = findViewById(R.id.id_registro);
        btnAbrirRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,TelaRegistroActivity.class);
            startActivity(intent);
        });
        // Abrir tela de login
        Button btnAbrirLogin = findViewById(R.id.id_login);
        btnAbrirLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,TelaLoginActivity.class);
            startActivity(intent);
        });
        }
    }


