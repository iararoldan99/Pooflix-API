package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Documentales")
public class Documental {

    private ObjectId _id;
    private String titulo;
    private Genero genero;
    private Director director;

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

    public Documental() {
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Documental(ObjectId _id, String titulo, Genero genero, Director director) {
        this._id = _id;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
    }

}
