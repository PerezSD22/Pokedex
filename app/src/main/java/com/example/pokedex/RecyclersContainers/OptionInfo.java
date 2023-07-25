package com.example.pokedex.RecyclersContainers;

public class OptionInfo {
    private String titulo;
    private int imagen;
    private String color;
    public OptionInfo(String titulo, int imagen, String color) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public String getColor() {
        return color;
    }
}
