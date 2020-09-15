package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Series")
public class Serie {

    private ObjectId _id;
    private String titulo;
    private List<Temporada> temporadas = new ArrayList<>();
    private List<Actor> actores; 

    public void agregarActores(Actor actor) {
        this.actores.add(actor);
    }

    public void agregarTemporadas(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Temporada getTemporada(int numeroTemporada) {

        for (Temporada tempo : this.temporadas) {
            if (tempo.getNumero() == numeroTemporada) {
                return tempo;
            }
        }
        return null;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
