package com.pooflix.pooflix.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contenido")
public class Contenido {

    private String titulo;
    private double tiempoVisto;
    private Integer calificacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getTiempoVisto() {
        return tiempoVisto;
    }

    public void setTiempoVisto(double tiempoVisto) {
        this.tiempoVisto = tiempoVisto;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Contenido(String titulo, double tiempoVisto, Integer calificacion) {
        this.titulo = titulo;
        this.tiempoVisto = tiempoVisto;
        this.calificacion = calificacion;
    }

    public Contenido() {
    }

}
