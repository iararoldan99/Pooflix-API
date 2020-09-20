package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temporada")
public class Temporada {

    private ObjectId _id;
    private Integer totalTemporadas;
    private Integer numero;
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

    public Temporada(ObjectId _id, Integer numero, List<Episodio> episodios) {
        this._id = _id;
        this.numero = numero;
        this.episodios = episodios;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public List<Websodio> getWebsodios() {
        return websodios;
    }

    public void setWebsodios(List<Websodio> websodios) {
        this.websodios = websodios;
    }

}
