package com.example.longlive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TelaLogadoActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton menuButton;

    private List<String> tarefasList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        initUIComponents();
        loadUserData();
        configureNavigationView();
        loadSavedTasks();
    }

    private void initUIComponents() {
        TextView highPriorityText = findViewById(R.id.highPriority);
        TextView mediumPriorityText = findViewById(R.id.mediumPriority);
        TextView lowPriorityText = findViewById(R.id.lowPriority);

        LinearLayout highPriorityContainer = findViewById(R.id.highPriorityContainer);
        LinearLayout mediumPriorityContainer = findViewById(R.id.mediumPriorityContainer);
        LinearLayout lowPriorityContainer = findViewById(R.id.lowPriorityContainer);

        highPriorityText.setOnClickListener(v -> toggleVisibility(highPriorityContainer));
        mediumPriorityText.setOnClickListener(v -> toggleVisibility(mediumPriorityContainer));
        lowPriorityText.setOnClickListener(v -> toggleVisibility(lowPriorityContainer));

        Button button = findViewById(R.id.editButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(TelaLogadoActivity.this, TelaEditarConsumoActivity.class);
            startActivity(intent);
            finish();
        });

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView valorAtual = findViewById(R.id.currentValue);
        TextView metaLabel = findViewById(R.id.metaLabel);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        int metaDiaria = sharedPreferences.getInt("metaDiaria", 0);
        metaLabel.setText("Meta: " + metaDiaria + "ml");
        valorAtual.setText("0 ml");

        seekBar.setMax(metaDiaria);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorAtual.setText(progress + "ml");
                if (progress == metaDiaria) {
                    Toast.makeText(TelaLogadoActivity.this, "Meta alcançada!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void toggleVisibility(LinearLayout container) {
        if (container.getVisibility() == View.GONE) {
            container.setVisibility(View.VISIBLE);
        } else {
            container.setVisibility(View.GONE);
        }
    }

    private void loadUserData() {
        // Carrega dados do usuário, como a meta diária
    }

    private void configureNavigationView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_seusdados) {
                startActivity(new Intent(TelaLogadoActivity.this, TelaSeusDadosActivity.class));
            } else if (id == R.id.nav_tarefas) {
                startActivity(new Intent(TelaLogadoActivity.this, TelaTarefas.class));
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void loadSavedTasks() {
        SharedPreferences sharedPreferences = getSharedPreferences("TarefaPrefs", MODE_PRIVATE);
        String tarefasSalvas = sharedPreferences.getString("taskList", "");

        if (!tarefasSalvas.isEmpty()) {
            String[] tarefas = tarefasSalvas.split(",");
            for (String item : tarefas) {
                String[] partes = item.split("\\|");
                if (partes.length == 2) {
                    String tarefa = partes[0];
                    int prioridade = Integer.parseInt(partes[1]);

                    CheckBox checkBox = new CheckBox(this);
                    checkBox.setText(tarefa);

                    int color = getPriorityColor(prioridade);
                    checkBox.setTextColor(ContextCompat.getColor(this, color));

                    // Verifique se o estado do checkbox foi salvo
                    boolean isChecked = sharedPreferences.getBoolean(tarefa, false);
                    checkBox.setChecked(isChecked);

                    // Adicionar ouvinte para salvar o estado do checkbox
                    checkBox.setOnCheckedChangeListener((buttonView, isChecked1) -> {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(tarefa, isChecked1); // Salva o estado do checkbox
                        editor.apply();
                    });

                    addTaskToPriorityContainer(prioridade, checkBox);
                }
            }
        }
    }


    private int getPriorityColor(int prioridade) {
        switch (prioridade) {
            case 1: return R.color.red;
            case 2: return R.color.yellow;
            case 3: return R.color.green;
            default: return R.color.black;
        }
    }

    private void addTaskToPriorityContainer(int prioridade, CheckBox checkBox) {
        LinearLayout container;
        switch (prioridade) {
            case 1:
                container = findViewById(R.id.highPriorityContainer);
                break;
            case 2:
                container = findViewById(R.id.mediumPriorityContainer);
                break;
            case 3:
                container = findViewById(R.id.lowPriorityContainer);
                break;
            default:
                return;
        }
        container.addView(checkBox);
    }
}
