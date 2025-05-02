package com.example.longlive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TelaEditarConsumoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_agua);

        // Lógica SeekBar  ↓↓↓

        // 1) Referência ao botão "Salvar"
        Button salvarBtn = findViewById(R.id.salvarInput);

        // 2) Referência ao EditText onde o usuário insere a meta de consumo
        EditText inputMeta = findViewById(R.id.editMetaDiaria);

        // 3) Recuperar a meta de consumo salva previamente
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences",MODE_PRIVATE);
        int metaSalva = sharedPreferences.getInt("metaDiaria", 0); // Obtém a meta salva ou 0 se não existir
        inputMeta.setText(String.valueOf(metaSalva)); // Define a meta salva no EditText

        // 4) Definir o que ocorre quando o botão "Salvar" for clicado
        salvarBtn.setOnClickListener(v -> {
            // 5) Recuperar o valor digitado no EditText
            String valorDigitado = inputMeta.getText().toString();

            // 6) Verificar se o valor não está vazio
            if(!valorDigitado.isEmpty()){
                int meta = Integer.parseInt(valorDigitado); // Converter o valor digitado para inteiro

                // 7) Verificar se o valor excede o limite seguro de 6000 ml
                if(meta > 6000){
                    Toast.makeText(this,"O limite seguro é 6000 ml por dia", Toast.LENGTH_LONG).show();
                    return; // Interrompe o processo caso o valor seja superior a 6000 ml
                }

                // 8) Salvar a nova meta de consumo nas preferências compartilhadas
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("metaDiaria", meta); // Armazena a nova meta
                editor.apply(); // Aplica as alterações

                // 9) Redireciona para a tela principal após salvar a meta
                Intent intent = new Intent(TelaEditarConsumoActivity.this, TelaLogadoActivity.class);
                startActivity(intent);
            } else {
                // 10) Exibe uma mensagem de erro caso o valor digitado seja inválido (vazio)
                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show();
            }
        });

        // Logica retornar para página anterior ↓↓↓

        ImageButton imageButton = findViewById(R.id.voltar_inicial);
        imageButton.setOnClickListener(v1 -> {
            Intent intent = new Intent(TelaEditarConsumoActivity.this,TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
