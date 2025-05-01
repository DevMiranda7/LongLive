package com.example.longlive;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLogadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

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
                highPriorityContainer.setVisibility(View.VISIBLE);
            } else {
                highPriorityContainer.setVisibility(View.GONE);
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

    }
}
