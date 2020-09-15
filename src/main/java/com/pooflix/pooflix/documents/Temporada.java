package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temporada")
public class Temporada {

    private ObjectId _id;
    private Integer numero;
    private List<Episodio> episodios = new ArrayList<>();

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

    /*

    public Episodio getEpisodio(Integer numeroEpisodio) {

        for (Episodio epi : this.episodios) {
            if (epi.getNumero() == numeroEpisodio) {
                return epi;
            }
        }

        return null;
    }

    */

    /*
    /**
     * Obtiene un episodio en base al nombre (es una sobrecarga del metodo
     * getEpisodio(int nro))
     * 
     * @param nombre
     * @return
     
    public Episodio getEpisodio(String titulo) {
        // Recorrer cada episodio
        // Si el nombre de episodio del ciclo es igual a "nombre"
        // Devolver esa episodio

        for (Episodio epi : this.episodios) {
            if (epi.getTitulo().equalsIgnoreCase(titulo)) {
                return epi;
            }

        }

        return null;
    }

    /**
     * Obtiene un episodio en base a la posicion dentro del ArrayList. Recordar que
     * los arraylist la primer posicion es la 0
     * 
     * @param pos
     * @return
     
    public Episodio getEpisodioAtPosicion(int pos) {
        return this.episodios.get(pos);
    }

    /**
     * Obtiene el nro de posicion(no el nro de episodio) de un episodio dentro de la
     * lista
     * 
     * @param nro
     * @return
     
    public Integer getEpisodioPosition(Integer nro) {

        int pos = 0;
        for (Episodio epi : this.episodios) {
            if (epi.getNumero() == nro) {
                return pos;
            }
            pos++;
        }
        if (this.episodios.size() == pos)
            return -1;
        return pos;
    }

    */


   

}
