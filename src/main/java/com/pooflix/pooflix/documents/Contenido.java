package com.pooflix.pooflix.documents;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contenido")
public class Contenido {

    // dentro de Contenido: Peliculas, Series, Documentales y Websodios

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

    /*
    public boolean visto() {

        return false;

    }

    public void reproducir() {

    }

    public void pausar() {

    }

   
    */

  


}