package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Episodios")
public class Episodio {

    private ObjectId _id;
    private Integer totalEpisodios;
    private Integer numero;
    private String titulo;
    private double duracion;

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Episodio(ObjectId _id, Integer numero, String titulo, double duracion) {
        this._id = _id;
        this.numero = numero;
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public Episodio() {
    }

    public Integer getTotalEpisodios() {
        return totalEpisodios;
    }

    public void setTotalEpisodios(Integer totalEpisodios) {
        this.totalEpisodios = totalEpisodios;
    }

}
