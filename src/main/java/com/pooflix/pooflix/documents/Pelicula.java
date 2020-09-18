package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Peliculas")
public class Pelicula {

    private ObjectId _id;
    private String titulo;
    private double duracion;
    private Genero genero;
    private List<ObjectId> actores = new ArrayList<>();
    private List<Director> director;

    public ObjectId asignarActor(ObjectId _idActor) {
        this.actores.add(_idActor);
        return _idActor;
    }

    public Pelicula() {

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

    public List<Director> getDirector() {
        return director;
    }

    public void setDirector(List<Director> director) {
        this.director = director;
    }

    

}
