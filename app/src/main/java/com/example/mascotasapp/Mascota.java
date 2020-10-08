package com.example.mascotasapp;

public class Mascota {
    private int foto;
    private String nombre;
    private int like;
    private boolean favorito;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Mascota(int foto, String nombre, int like) {
        this.foto = foto;
        this.nombre = nombre;
        this.like = like;
        this.favorito = false;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLike() {
        return like;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
