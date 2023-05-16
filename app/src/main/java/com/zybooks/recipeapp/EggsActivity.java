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

public class EggsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eggs);

        SharedPreferences storeInfo = getSharedPreferences("savedRecipes", MODE_PRIVATE);
        SharedPreferences.Editor editor = storeInfo.edit();

        Button btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("Eggs", "Scrambled Eggs");
                editor.apply();

                Toast.makeText(EggsActivity.this, "Recipe Saved", Toast.LENGTH_LONG).show();
            }
        });

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EggsActivity.this, AllRecipesActivity.class));
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
            startActivity(new Intent(EggsActivity.this, AllRecipesActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuSavedRecipes){
            startActivity(new Intent(EggsActivity.this, MainActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuBreakfast){
            startActivity(new Intent(EggsActivity.this, BreakfastActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuLunch){
            startActivity(new Intent(EggsActivity.this, LunchActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDinner){
            startActivity(new Intent(EggsActivity.this, DinnerActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDessert){
            startActivity(new Intent(EggsActivity.this, DessertActivity.class));
            return true;
        }else{
            return false;
        }
    }
}