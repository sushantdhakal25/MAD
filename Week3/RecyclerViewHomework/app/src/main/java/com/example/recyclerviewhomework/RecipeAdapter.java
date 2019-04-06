package com.example.recyclerviewhomework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {

    private List<Recipe> recipeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            desc = (TextView) view.findViewById(R.id.desc);
        }
    }
    public RecipeAdapter(List<Recipe> recipesList) {
        this.recipeList = recipesList;
    }
    @NonNull

    @Override
    public RecipeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list, parent, false);

        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.MyViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.title.setText(recipe.getTitle());
        holder.desc.setText(recipe.getDesc());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
