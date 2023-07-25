package com.example.pokedex.ui.pokemonlist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.RecyclersContainers.OptionPokemonAdapter;
import com.example.pokedex.RecyclersContainers.PokemonOptionList;
import com.example.pokedex.api.PokemonServices;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonList extends Fragment {
    private RecyclerView recyclerView;
    private List<PokemonOptionList> pokemonList;
    private OptionPokemonAdapter adapter;
    private Retrofit retrofit;
    private PokemonServices pokemonApi;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crea una instancia de la interfaz de la API
        pokemonApi = retrofit.create(PokemonServices.class);

        // Obtiene los datos de los Pokémon desde la API
        obtenerDatosPokemon();

        // Configura el RecyclerView y el adaptador
        recyclerView = view.findViewById(R.id.PokemonListID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new OptionPokemonAdapter(pokemonList);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private void obtenerDatosPokemon() {
        Call<PokemonServices.PokemonListResponse> call = pokemonApi.getAllPokemon();
        call.enqueue(new Callback<PokemonServices.PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonServices.PokemonListResponse> call, Response<PokemonServices.PokemonListResponse> response) {
                if (response.isSuccessful()) {
                    PokemonServices.PokemonListResponse pokemonListResponse = response.body();
                    List<Map<String, Object>> pokemonList = pokemonListResponse.getResults();
                    String name = null;
                    List<String> types = null;
                    String spriteUrl = null;
                    for (Map<String, Object> pokemon : pokemonList) {
                        // Aquí debes adaptar los datos del modelo Pokemon al modelo PokemonOptionList
                        // que usas en tu adaptador. Necesitarás obtener el nombre, los tipos y la imagen
                        // de cada Pokemon.
                        name = (String) pokemon.get("name");
                        types = (List<String>) pokemon.get("types"); // Debes obtener los tipos de cada Pokemon
                        Map<String, String> sprites = (Map<String, String>) pokemon.get("sprites");
                        spriteUrl = sprites.get("front_default"); // Debes obtener la imagen de cada Pokemon
                        ImageView imageView = getView().findViewById(R.id.ImageOptionID);
                        Picasso.get().load(spriteUrl).into(imageView);
                        PokemonOptionList pokemonOption = new PokemonOptionList(name, types, spriteUrl);
                        adapter.addPokemon(pokemonOption);
                    }
                    adapter.notifyDataSetChanged();
                    PokemonOptionList pokemonOption = new PokemonOptionList(name, types, spriteUrl);
                    adapter.addPokemon(pokemonOption);
                } else {
                    Log.e("PokemonList", "onResponse: " + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<PokemonServices.PokemonListResponse> call, Throwable t) {
                Log.e("PokemonList", "onFailure: " + t.getMessage());
            }
        });
    }


}
