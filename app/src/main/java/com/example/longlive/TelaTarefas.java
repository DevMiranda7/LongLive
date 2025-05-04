package com.example.longlive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TelaTarefas extends AppCompatActivity {

    private EditText editTextTarefa;
    private Button btnAdicionarTarefa;
    private LinearLayout taskListLayout;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TarefaPrefs";
    private static final String TASK_LIST_KEY = "taskList";

    private int prioridadeSelecionada = -1;

    private List<String> tarefasSalvasList = new ArrayList<>(); // Armazena as tarefas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);

        editTextTarefa = findViewById(R.id.editTextTarefa);
        btnAdicionarTarefa = findViewById(R.id.id_addTask);
        taskListLayout = findViewById(R.id.taskListLayout);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        carregarTarefas();

        Button btnPrioridadeMaxima = findViewById(R.id.id_prioridadeMaxima);
        Button btnPrioridadeMedia = findViewById(R.id.id_prioridadeMedia);
        Button btnPrioridadeBaixa = findViewById(R.id.id_prioridadeBaixa);

        btnPrioridadeMaxima.setOnClickListener(v -> prioridadeSelecionada = 1);
        btnPrioridadeMedia.setOnClickListener(v -> prioridadeSelecionada = 2);
        btnPrioridadeBaixa.setOnClickListener(v -> prioridadeSelecionada = 3);

        btnAdicionarTarefa.setOnClickListener(v -> {
            String tarefa = editTextTarefa.getText().toString().trim();

            if (!tarefa.isEmpty()) {
                if (prioridadeSelecionada == -1) {
                    Toast.makeText(this, "Selecione uma prioridade para a tarefa", Toast.LENGTH_SHORT).show();
                    return;
                }

                adicionarTarefaVisual(tarefa, prioridadeSelecionada);
                salvarTarefa(tarefa, prioridadeSelecionada);

                editTextTarefa.setText("");
                prioridadeSelecionada = -1;
            } else {
                Toast.makeText(this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btnRetornar = findViewById(R.id.id_voltarInicio);
        btnRetornar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaTarefas.this, TelaLogadoActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void carregarTarefas() {
        String tarefasSalvas = sharedPreferences.getString(TASK_LIST_KEY, "");
        if (!tarefasSalvas.isEmpty()) {
            String[] tarefas = tarefasSalvas.split(",");
            for (String item : tarefas) {
                String[] partes = item.split("\\|");
                if (partes.length == 2) {
                    String tarefa = partes[0];
                    int prioridade = Integer.parseInt(partes[1]);

                    tarefasSalvasList.add(item);
                    adicionarTarefaVisual(tarefa, prioridade);
                }
            }
        }
    }

    private void adicionarTarefaVisual(String tarefa, int prioridade) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(tarefa);

        switch (prioridade) {
            case 1:
                checkBox.setTextColor(getResources().getColor(R.color.red));
                break;
            case 2:
                checkBox.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case 3:
                checkBox.setTextColor(getResources().getColor(R.color.green));
                break;
        }

        taskListLayout.addView(checkBox);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox.postDelayed(() -> {
                    taskListLayout.removeView(checkBox);
                    removerTarefa(tarefa, prioridade);
                }, 3000);
            }
        });
    }

    private void salvarTarefa(String tarefa, int prioridade) {
        String novaTarefa = tarefa + "|" + prioridade;
        tarefasSalvasList.add(novaTarefa);

        atualizarSharedPreferences();
    }

    private void removerTarefa(String tarefa, int prioridade) {
        String tarefaFormatada = tarefa + "|" + prioridade;
        tarefasSalvasList.remove(tarefaFormatada);

        atualizarSharedPreferences();
    }

    private void atualizarSharedPreferences() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tarefasSalvasList.size(); i++) {
            sb.append(tarefasSalvasList.get(i));
            if (i < tarefasSalvasList.size() - 1) {
                sb.append(",");
            }
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TASK_LIST_KEY, sb.toString());
        editor.apply();
    }
}