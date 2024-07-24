package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrackingActivity extends AppCompatActivity {

    private TextView tvNutrientTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        tvNutrientTracking = findViewById(R.id.tvNutrientTracking);

        // Mostrar seguimiento simple de nutrientes
        String nutrientTracking = "Calorías: 1500/2000\n" +
                "Proteínas: 70g/100g\n" +
                "Carbohidratos: 200g/250g\n" +
                "Grasas: 50g/70g";
        tvNutrientTracking.setText(nutrientTracking);
    }
}