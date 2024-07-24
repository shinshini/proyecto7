package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MealPlanActivity extends AppCompatActivity {

    private TextView tvMealPlan;
    private Button btnGeneratePlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        tvMealPlan = findViewById(R.id.tvMealPlan);
        btnGeneratePlan = findViewById(R.id.btnGeneratePlan);

        btnGeneratePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generar plan de comidas basado en la información del usuario
                String mealPlan = "Desayuno: Avena con frutas\n" +
                        "Almuerzo: Ensalada de pollo\n" +
                        "Cena: Salmón con vegetales";
                tvMealPlan.setText(mealPlan);
            }
        });
    }
}