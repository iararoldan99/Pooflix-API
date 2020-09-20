package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

public class Genero {
    private ObjectId _id;
    @Field(order = 1)
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

    public Genero(ObjectId _id, String nombre) {
        this._id = _id;
        this.nombre = nombre;
    }

}
