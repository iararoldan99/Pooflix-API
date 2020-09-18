package com.pooflix.pooflix.documents;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

public class Actor {

	//@Field("actorId")
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

	public Actor(ObjectId _id, String fullName) {
		this._id = _id;
		this.fullName = fullName;
	}

	public Actor(){
		
	}

}
