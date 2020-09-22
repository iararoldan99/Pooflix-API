package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temporada")
public class Temporada {

    private ObjectId _id;
    private Integer numero;
    private Integer numTotalEpisodios;
    private List<Episodio> episodios = new ArrayList<>();
    private List<Websodio> websodios = new ArrayList<>();

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Temporada() {
    }

    public List<Websodio> getWebsodios() {
        return websodios;
    }

    public void setWebsodios(List<Websodio> websodios) {
        this.websodios = websodios;
    }

    public Integer getNumTotalEpisodios() {
        return numTotalEpisodios;
    }

    public void setNumTotalEpisodios(Integer numTotalEpisodios) {
        this.numTotalEpisodios = numTotalEpisodios;
    }

    public Temporada(Integer numero, Integer numTotalEpisodios, List<Episodio> episodios,
            List<Websodio> websodios) {
        this.numero = numero;
        this.numTotalEpisodios = numTotalEpisodios;
        this.episodios = episodios;
        this.websodios = websodios;
    }

}
