package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TelaNotificacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacoes);

        ImageButton btnAbrirRetornar = findViewById(R.id.id_voltarInicio);
        btnAbrirRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaNotificacoesActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });

        ImageButton retornarSim = findViewById(R.id.id_sim);
        retornarSim.setOnClickListener(v -> {

            Toast.makeText(TelaNotificacoesActivity.this, "Notificações ativadas", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TelaNotificacoesActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });

        ImageButton retornarNao = findViewById(R.id.id_nao);
        retornarNao.setOnClickListener(v -> {

            Toast.makeText(TelaNotificacoesActivity.this, "Notificações desativadas", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TelaNotificacoesActivity.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
