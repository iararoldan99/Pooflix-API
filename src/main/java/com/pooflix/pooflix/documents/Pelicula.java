package com.pooflix.pooflix.documents;

import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Peliculas")
public class Pelicula {

    private ObjectId _id;
    private String titulo;
    private double duracion;
    //private ObjectId generoId;
    private Genero genero;
    private List<Actor> actores; 
    private List<Director> directores;

    public void agregarActores(Actor actor) {
        this.actores.add(actor);
    }

    public void agregarDirectores(Director director) {
        this.directores.add(director);
    }
    
    public Pelicula(){

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

    
    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    

	
  
   
    
}
