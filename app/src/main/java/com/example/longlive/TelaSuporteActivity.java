package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TelaSuporteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suporte);

        ImageButton btnAbrirRetornar = findViewById(R.id.botao_voltar);
        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaSuporteActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });

        Button btnEnviarReport = findViewById(R.id.buttonEnviarSuporte);
        btnEnviarReport.setOnClickListener(v -> {
            Toast.makeText(TelaSuporteActivity.this, "Sua mensagem foi enviada!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TelaSuporteActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
    }

}
