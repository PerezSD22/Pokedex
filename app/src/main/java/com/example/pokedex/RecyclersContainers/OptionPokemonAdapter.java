package com.example.pokedex.RecyclersContainers;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.pokedex.R;

import java.util.List;
public class OptionPokemonAdapter extends RecyclerView.Adapter<OptionPokemonAdapter.PokemonViewHolder> {
    private List<PokemonOptionList> pokemonList;
    public OptionPokemonAdapter(List<PokemonOptionList> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addPokemon(PokemonOptionList pokemon) {
        pokemonList.add(pokemon);
    }
    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_option, parent, false);
        return new PokemonViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        PokemonOptionList pokemon = pokemonList.get(position);
        holder.nameTextView.setText(pokemon.getName());
        holder.typeTextView.setText(pokemon.getTypes().toString());
        Glide.with(holder.itemView.getContext())
                .load(pokemon.getSprite())
                .into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView typeTextView;
        ImageView imageView;
        public PokemonViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.titleOptionID);
            typeTextView = itemView.findViewById(R.id.TypePokemonID);
            imageView = itemView.findViewById(R.id.ImageOptionID);
        }
    }
}