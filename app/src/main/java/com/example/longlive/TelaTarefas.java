package com.example.longlive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class TelaTarefas extends AppCompatActivity {

    private EditText editTextTarefa;
    private Button btnAdicionarTarefa;
    private LinearLayout tarefasContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        // Referências aos elementos do layout
        editTextTarefa = findViewById(R.id.editTextTarefa);
        btnAdicionarTarefa = findViewById(R.id.btnAdicionarTarefa);
        tarefasContainer = findViewById(R.id.tarefasContainer);

        // Adicionar tarefa ao clicar no botão
        btnAdicionarTarefa.setOnClickListener(v -> {
            String tarefa = editTextTarefa.getText().toString().trim();

            if (!tarefa.isEmpty()) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText(tarefa);
                tarefasContainer.addView(checkBox);
                editTextTarefa.setText(""); // Limpa o campo após adicionar
            }
        });
    }
}
