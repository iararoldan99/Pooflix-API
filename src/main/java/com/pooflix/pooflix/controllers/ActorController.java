package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    @Autowired
    ActorService actorService;

    @PostMapping("/actores")
    public ResponseEntity<GenericResponse> crearActor(@RequestBody Actor actor){
        actorService.crearActor(actor);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = actor.get_id(); //.toHexString();
        gR.mensaje = "Actor creado con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/actores")
    public ResponseEntity<List<Actor>> listarActores() {
        return ResponseEntity.ok(actorService.listarActores());
    }
}
