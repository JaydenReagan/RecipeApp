package com.zybooks.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //Establishing variables
    ListView listSavedRecipes;
    ArrayList<String> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating an ArrayList and adapter to update the ListView
        myList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);

        listSavedRecipes = (ListView) findViewById(R.id.listSavedRecipes);
        listSavedRecipes.setAdapter(adapter);

        //Creating SharedPreferences
        SharedPreferences storeInfo = getSharedPreferences("savedRecipes", MODE_PRIVATE);

        //Will only add to the list if it can find in sharedPreferences
        myList.add(storeInfo.getString("GrilledCheese", ""));
        myList.add(storeInfo.getString("Chicken", ""));
        myList.add(storeInfo.getString("Fries", ""));
        myList.add(storeInfo.getString("BananasFoster", ""));
        myList.add(storeInfo.getString("CaramelPopcorn", ""));
        myList.add(storeInfo.getString("Cookies", ""));
        myList.add(storeInfo.getString("Macaroni", ""));
        myList.add(storeInfo.getString("Oatmeal", ""));
        myList.add(storeInfo.getString("Pancakes", ""));
        myList.add(storeInfo.getString("Eggs", ""));
        myList.add(storeInfo.getString("Pizza", ""));
        myList.add(storeInfo.getString("Sandwich", ""));

        //Loop to get rid of any List item that is blank due to not being saved
        for (int i = myList.size() - 1; i > 0; i--){
            if (Objects.equals(myList.get(i), "")){
                myList.remove(i);
            }
        }

        //A click event to create links to pull up the recipe when clicked
        listSavedRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent;
                String itemSelected = String.valueOf(listSavedRecipes.getItemAtPosition(position));

                if (itemSelected.equals("Apple & Bacon Grilled Cheese")){
                    intent = new Intent(MainActivity.this, GrilledCheeseActivity.class);
                }else if (itemSelected.equals("Baked Chicken Tenders")){
                    intent = new Intent(MainActivity.this, ChickenActivity.class);
                }else if (itemSelected.equals("Baked French Fries")){
                    intent = new Intent(MainActivity.this, FriesActivity.class);
                }else if (itemSelected.equals("Bananas Foster")){
                    intent = new Intent(MainActivity.this, BananasFosterActivity.class);
                }else if (itemSelected.equals("Caramel Popcorn")){
                    intent = new Intent(MainActivity.this, CaramelPopcornActivity.class);
                }else if (itemSelected.equals("Chocolate Chip Cookies")){
                    intent = new Intent(MainActivity.this, CookiesActivity.class);
                }else if (itemSelected.equals("Macaroni & Cheese")){
                    intent = new Intent(MainActivity.this, MacaroniActivity.class);
                }else if (itemSelected.equals("Oatmeal")){
                    intent = new Intent(MainActivity.this, OatmealActivity.class);
                }else if (itemSelected.equals("Pancakes")){
                    intent = new Intent(MainActivity.this, PancakesActivity.class);
                }else if (itemSelected.equals("Scrambled Eggs")){
                    intent = new Intent(MainActivity.this, EggsActivity.class);
                }else if (itemSelected.equals("Skillet Pizza")){
                    intent = new Intent(MainActivity.this, PizzaActivity.class);
                }else if (itemSelected.equals("Sweet & Spicy Chicken Sandwich")){
                    intent = new Intent(MainActivity.this, SandwichActivity.class);
                }else {
                    intent = new Intent(MainActivity.this, AllRecipesActivity.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflater to pull up the menu
        getMenuInflater().inflate(R.menu.recipe_nav, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        //Creation of links for menu items to take you to the proper activity
        if(item.getItemId() == R.id.menuAllRecipes){
            startActivity(new Intent(MainActivity.this, AllRecipesActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuSavedRecipes){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuBreakfast){
            startActivity(new Intent(MainActivity.this, BreakfastActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuLunch){
            startActivity(new Intent(MainActivity.this, LunchActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDinner){
            startActivity(new Intent(MainActivity.this, DinnerActivity.class));
            return true;
        }else if (item.getItemId() == R.id.menuDessert){
            startActivity(new Intent(MainActivity.this, DessertActivity.class));
            return true;
        }else{
            return false;
        }
    }
}