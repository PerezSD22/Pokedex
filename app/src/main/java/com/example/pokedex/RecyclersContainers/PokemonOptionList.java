package com.example.pokedex.RecyclersContainers;

import java.util.List;

public class PokemonOptionList {
    private String name;
    private List<String> types;
    private String sprite;

    public PokemonOptionList(String name, List<String> types, String sprite) {
        this.name = name;
        this.types = types;
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}
