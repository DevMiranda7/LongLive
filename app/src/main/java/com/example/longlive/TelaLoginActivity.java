package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);
        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaLoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });


    }
}
