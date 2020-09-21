package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

public class Websodio {

  private ObjectId _id;
  private String url;
  private Integer totalWebsodios;
  private Integer numero;
  private String titulo;
  private double duracion;

  public ObjectId get_id() {
    return _id;
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Websodio() {
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

  public double getDuracion() {
    return duracion;
  }

  public void setDuracion(double duracion) {
    this.duracion = duracion;
  }

  public Websodio(ObjectId _id, String url, Integer numero, String titulo, double duracion) {
    this._id = _id;
    this.url = url;
    this.numero = numero;
    this.titulo = titulo;
    this.duracion = duracion;
  }

  public Integer getTotalWebsodios() {
    return totalWebsodios;
  }

  public void setTotalWebsodios(Integer totalWebsodios) {
    this.totalWebsodios = totalWebsodios;
  }

}
