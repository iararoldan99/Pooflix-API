package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Peliculas")
public class Pelicula {

    private ObjectId _id;
    private String titulo;
    private double duracion;
    private Genero genero;

    public Pelicula() {

    }

    public Pelicula(ObjectId _id, String titulo, double duracion, Genero genero) {
        this._id = _id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
