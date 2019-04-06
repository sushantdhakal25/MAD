package com.example.recyclerviewhomework;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Recipe> recipeList = new ArrayList<>();
    private RecipeAdapter rAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.item_seperator)));
        rAdapter = new RecipeAdapter(recipeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rAdapter);

        prepareFoodData();

        recyclerView.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
                recyclerView, new RecyclerItemListener.RecyclerTouchListener() {
            @Override
            public void onClickItem(View v, int position) {

                if (position==0) {
                    Intent intent = new Intent(MainActivity.this, Recipe1.class);
                    startActivity(intent);
                }
                if (position==1) {
                    Intent intent = new Intent(MainActivity.this, Recipe2.class);
                    startActivity(intent);
                }
                if (position==2) {
                    Intent intent = new Intent(MainActivity.this, Recipe3.class);
                    startActivity(intent);
                }
                if (position==3) {
                    Intent intent = new Intent(MainActivity.this, Recipe4.class );
                    startActivity(intent);
                }
                if (position==4) {
                    Intent intent = new Intent(MainActivity.this, Recipe4.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClickItem(View v, int position) {
                Toast.makeText(getApplicationContext(), "Long Pressed: " +
                        recipeList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            }
        }));

    }
    private void prepareFoodData() {
        Recipe food = new Recipe("Kale/Lemon Sandwiches", "This sandwich is stunningly delicious and tastes as good as it is healthy. Any greens of choice will work. The lemon adds an almost sweet taste. Be generous with it!");
        recipeList.add(food);

        Recipe food1 = new Recipe("Lala/Carrot Sandwiches", "This sandwich is stunningly delicious and tastes as good as it is healthy. Any greens of choice will work. The lemon adds an almost sweet taste. Be generous with it!");
        recipeList.add(food1);

        Recipe food2 = new Recipe("Oale/Onion Sandwiches", "This sandwich is stunningly delicious and tastes as good as it is healthy. Any greens of choice will work. The lemon adds an almost sweet taste. Be generous with it!");
        recipeList.add(food2);

        Recipe food3 = new Recipe("Choclate Sandwiches", "This sandwich is stunningly delicious and tastes as good as it is healthy. Any greens of choice will work. The lemon adds an almost sweet taste. Be generous with it!");
        recipeList.add(food3);

        Recipe food4 = new Recipe("Chicken Sandwiches", "This sandwich is stunningly delicious and tastes as good as it is healthy. Any greens of choice will work. The lemon adds an almost sweet taste. Be generous with it!");
        recipeList.add(food4);


        rAdapter.notifyDataSetChanged();
    }


}
