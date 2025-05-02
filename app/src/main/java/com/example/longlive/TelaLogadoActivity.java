package com.example.longlive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.longlive.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import fragments.SeusDadosFragment;


public class TelaLogadoActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton menuButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial); // Define o layout da atividade

        // 1) Referências aos TextViews que funcionam como "toggle headers"
        TextView highPriorityText   = findViewById(R.id.highPriority);
        TextView mediumPriorityText = findViewById(R.id.mediumPriority);
        TextView lowPriorityText    = findViewById(R.id.lowPriority);

        // 2) Referências aos containers que contêm os CheckBoxes
        LinearLayout highPriorityContainer   = findViewById(R.id.highPriorityContainer);
        LinearLayout mediumPriorityContainer = findViewById(R.id.mediumPriorityContainer);
        LinearLayout lowPriorityContainer    = findViewById(R.id.lowPriorityContainer);

        // 3) Inicialmente ocultos
        // Click listener para Alta Prioridade
        highPriorityText.setOnClickListener(v -> {
            if (highPriorityContainer.getVisibility() == View.GONE) {
                highPriorityContainer.setVisibility(View.VISIBLE); // Torna visível o container
            } else {
                highPriorityContainer.setVisibility(View.GONE); // Torna invisível o container
            }
        });

        // Click listener para Média Prioridade
        mediumPriorityText.setOnClickListener(v -> {
            if (mediumPriorityContainer.getVisibility() == View.GONE) {
                mediumPriorityContainer.setVisibility(View.VISIBLE);
            } else {
                mediumPriorityContainer.setVisibility(View.GONE);
            }
        });

        // Click listener para Baixa Prioridade
        lowPriorityText.setOnClickListener(v -> {
            if (lowPriorityContainer.getVisibility() == View.GONE) {
                lowPriorityContainer.setVisibility(View.VISIBLE);
            } else {
                lowPriorityContainer.setVisibility(View.GONE);
            }
        });

        // 4) Botão para acessar a tela de edição do consumo de água
        Button button = findViewById(R.id.editButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(TelaLogadoActivity.this, TelaEditarConsumoActivity.class); // Cria a intenção para a tela de edição
            startActivity(intent); // Inicia a nova atividade
        });

        // 5) Recupera a meta diária de consumo de água do SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        int metaDiaria = sharedPreferences.getInt("metaDiaria", 0); // Pega o valor da meta diária

        // 6) Inicializa componentes do SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView valorAtual = findViewById(R.id.currentValue);
        TextView metaLabel = findViewById(R.id.metaLabel);

        // 7) Exibe a meta diária e o valor inicial do consumo (0 ml)
        metaLabel.setText("Meta: " + metaDiaria + "ml");
        valorAtual.setText("0 ml");

        // 8) Ajusta o SeekBar de acordo com a meta diária
        seekBar.setMax(metaDiaria);
        seekBar.setProgress(0);

        // 9) Configura o comportamento do SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorAtual.setText(progress + "ml"); // Atualiza o valor exibido com o progresso
                if (progress == metaDiaria) {
                    // Se a meta for alcançada, exibe uma mensagem de sucesso
                    Toast.makeText(TelaLogadoActivity.this, "Meta alcançada! Você atingiu a sua meta diária de consumo de água", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Método vazio, não está sendo utilizado
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Método vazio, não está sendo utilizado
            }
        });


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuButton = findViewById(R.id.menuButton);
        navigationView.inflateMenu(R.menu.drawer_menu);
        menuButton.setOnClickListener(v -> openMenu());

        configureNavigationView();
    }

    private void openMenu(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void configureNavigationView(){
        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_seusdados) {
                fragment = new SeusDadosFragment();
            }
            // else if (id == R.id.nav_tarefas) { ... }
            // else if (...) { ... }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

    }

    }


