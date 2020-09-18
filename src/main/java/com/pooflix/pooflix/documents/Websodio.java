package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

public class Websodio {

  private ObjectId _id;
  private String url;

  public Websodio(Integer numero, String titulo) {
    this.url = "http://movies.com";
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  public Websodio() {
  }

  public Websodio(ObjectId _id, String url) {
    this._id = _id;
    this.url = url;
  }

  /**
   * "envia" un mail de alerta cuando la serie este online. Este metodo NO esta en
   * EPISODIO.
   */
  // public void enviarAlertaDeQueEstaOnline() {
  // mandaria un mail a los usuarios avisando que ya esta disponible para ver.
  // System.out.println("Enviando mail con url " + this.url);
  // }

}
