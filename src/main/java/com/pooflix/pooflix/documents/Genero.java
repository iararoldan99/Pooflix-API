package com.pooflix.pooflix.documents;


import org.bson.types.ObjectId;

public class Genero {
    private ObjectId _id;
    private String nombre;

    public Genero() {

    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setGeneroId(String hexString) {
    }

}
