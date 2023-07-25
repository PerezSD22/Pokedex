package com.example.pokedex.api;

import com.example.pokedex.models.Pokemon;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonServices {
    @GET("pokemon")
    Call<PokemonListResponse> getAllPokemon();
    public class PokemonListResponse {
        private List<Map<String, Object>> results;

        public List<Map<String, Object>> getResults() {
            return results;
        }
    }
}
