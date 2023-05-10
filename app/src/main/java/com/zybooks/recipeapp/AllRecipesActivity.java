package com.zybooks.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AllRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipes);

        ListView listRecipes = (ListView) findViewById(R.id.listAllRecipes);
        listRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(AllRecipesActivity.this, GrilledCheeseActivity.class);
                        break;
                    case 1:
                        intent = new Intent(AllRecipesActivity.this, ChickenActivity.class);
                        break;
                    case 2:
                        intent = new Intent(AllRecipesActivity.this, FriesActivity.class);
                        break;
                    case 3:
                        intent = new Intent(AllRecipesActivity.this, BananasFosterActivity.class);
                        break;
                    case 4:
                        intent = new Intent(AllRecipesActivity.this, CaramelPopcornActivity.class);
                        break;
                    case 5:
                        intent = new Intent(AllRecipesActivity.this, CookiesActivity.class);
                        break;
                    case 6:
                        intent = new Intent(AllRecipesActivity.this, MacaroniActivity.class);
                        break;
                    case 7:
                        intent = new Intent(AllRecipesActivity.this, OatmealActivity.class);
                        break;
                    case 8:
                        intent = new Intent(AllRecipesActivity.this, PancakesActivity.class);
                        break;
                    case 9:
                        intent = new Intent(AllRecipesActivity.this, EggsActivity.class);
                        break;
                    case 10:
                        intent = new Intent(AllRecipesActivity.this, PizzaActivity.class);
                        break;
                    case 11:
                        intent = new Intent(AllRecipesActivity.this, SandwichActivity.class);
                        break;
                    default:
                        intent = new Intent(AllRecipesActivity.this, AllRecipesActivity.class);
                        break;
                }
                startActivity(intent);
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
            startActivity(new Intent(AllRecipesActivity.this, AllRecipesActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuSavedRecipes){
            startActivity(new Intent(AllRecipesActivity.this, MainActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuBreakfast){
            startActivity(new Intent(AllRecipesActivity.this, BreakfastActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuLunch){
            startActivity(new Intent(AllRecipesActivity.this, LunchActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDinner){
            startActivity(new Intent(AllRecipesActivity.this, DinnerActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDessert){
            startActivity(new Intent(AllRecipesActivity.this, DessertActivity.class));
            return true;
        }else{
            return false;
        }
    }
}