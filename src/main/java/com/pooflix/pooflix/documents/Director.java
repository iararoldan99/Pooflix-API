package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;

public class Director {

    private ObjectId _id;
    private String fullName;

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
