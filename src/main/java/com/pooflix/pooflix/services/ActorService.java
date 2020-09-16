package com.pooflix.pooflix.services;

import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.repository.ActorRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    public Actor crearActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor crearActor(String fullName) {
        Actor actor = new Actor();
        actor.setFullName(fullName);
        actorRepository.save(actor);
        return actor;
    }

    public List<Actor> listarActores() {
        return actorRepository.findAll();
    }

    public Actor obtenerActorPorId(ObjectId _id) {
        return actorRepository.findBy_id(_id);
    }
}
