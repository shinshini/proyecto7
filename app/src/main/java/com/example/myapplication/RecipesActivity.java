package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recyclerView = findViewById(R.id.recyclerViewRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipes = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(recipes);
        recyclerView.setAdapter(recipeAdapter);

        // Agregar algunas recetas iniciales
        recipes.add(new Recipe("Ensalada de Quinoa", "Ingredientes: Quinoa, tomate, pepino, limón.", R.drawable.quinoa_salad));
        recipes.add(new Recipe("Batido de Fresas", "Ingredientes: Fresas, plátano, leche de almendra.", R.drawable.strawberry_smoothie));

        recipeAdapter.notifyDataSetChanged();


        Button btnAddRecipe = findViewById(R.id.btnAddRecipe);
        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddRecipeDialog();
            }
        });
    }

    private void showAddRecipeDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_recipe, null);
        builder.setView(dialogView);

        final EditText etName = dialogView.findViewById(R.id.etName);
        final EditText etIngredients = dialogView.findViewById(R.id.etIngredients);
        final Spinner spImage = dialogView.findViewById(R.id.spImage);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.image_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spImage.setAdapter(adapter);

        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString();
                String ingredients = etIngredients.getText().toString();
                int imageResId = getImageResourceId(spImage.getSelectedItemPosition());

                recipes.add(new Recipe(name, ingredients, imageResId));
                recipeAdapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.create().show();
    }

    private int getImageResourceId(int position) {
        switch (position) {
            case 0:

                return R.drawable.quinoa_salad;
            case 1:
                return R.drawable.strawberry_smoothie;
            default:
                return R.drawable.placeholder;
        }
    }
}