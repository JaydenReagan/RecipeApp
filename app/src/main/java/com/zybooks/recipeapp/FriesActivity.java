package com.zybooks.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fries);

        SharedPreferences storeInfo = getSharedPreferences("savedRecipes", MODE_PRIVATE);
        SharedPreferences.Editor editor = storeInfo.edit();

        Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("Fries", "Baked French Fries");
                editor.apply();

                Toast.makeText(FriesActivity.this, "Recipe Saved", Toast.LENGTH_LONG).show();
            }
        });

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriesActivity.this, AllRecipesActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_nav, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.menuAllRecipes){
            startActivity(new Intent(FriesActivity.this, AllRecipesActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuSavedRecipes){
            startActivity(new Intent(FriesActivity.this, MainActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuBreakfast){
            startActivity(new Intent(FriesActivity.this, BreakfastActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuLunch){
            startActivity(new Intent(FriesActivity.this, LunchActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDinner){
            startActivity(new Intent(FriesActivity.this, DinnerActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDessert){
            startActivity(new Intent(FriesActivity.this, DessertActivity.class));
            return true;
        }else{
            return false;
        }
    }
}