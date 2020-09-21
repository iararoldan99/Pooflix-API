package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Contenido")
public class Contenido {

    private ObjectId _id;
    @Field(order = 1)
    private String titulo;
    @Field(order = 2)
    private List<Director> directores;
    @Field(order = 3)
    private List<Actor> actores = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private Double tiempoVisto;
    private double calificacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    public Double getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(Double tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

}
