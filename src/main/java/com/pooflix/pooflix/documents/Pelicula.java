package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Peliculas")
public class Pelicula {

    private ObjectId _id;
    private String titulo;
    private double duracion;
    private Genero genero;
    private Actor actor;
    private Director director;

    public Pelicula() {

    }

    public Pelicula(ObjectId _id, String titulo, double duracion, Genero genero, Actor actor, Director director) {
        this._id = _id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.actor = actor;
        this.director = director;
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

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    /*
     * public ObjectId asignarActor(ObjectId _idActor) { this.actores.add(_idActor);
     * return _idActor; }
     * 
     * public ObjectId asignarDirector(ObjectId _idDirector) {
     * this.actores.add(_idDirector); return _idDirector; }
     */

}
