package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private EditText etAge, etWeight, etHeight;
    private Spinner spGoals;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inicializar los elementos de la interfaz de usuario
        etAge = findViewById(R.id.etAge);
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        spGoals = findViewById(R.id.spGoals);
        btnSave = findViewById(R.id.btnSave);

        // Configurar el spinner con opciones de objetivos de salud
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.goals_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGoals.setAdapter(adapter);

        // Configurar el botón de guardar
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardar información del usuario en SharedPreferences o en la base de datos
                SharedPreferences sharedPreferences= getSharedPreferences("Userprofile",MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("age", Integer.parseInt(etAge.getText().toString()));
                editor.putFloat("weight", Float.parseFloat(etWeight.getText().toString()));
                editor.putFloat("height", Float.parseFloat(etHeight.getText().toString()));
                editor.putString("goal", spGoals.getSelectedItem().toString());
                editor.apply();

                // Mostrar un mensaje de éxito
                Toast.makeText(ProfileActivity.this, "Perfil guardado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}