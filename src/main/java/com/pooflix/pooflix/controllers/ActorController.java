package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Actor;
import com.pooflix.pooflix.request.PersonaModifRequest;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.ActorService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActorController {
    @Autowired
    ActorService actorService;

    @PostMapping("/actores")
    public ResponseEntity<GenericResponse> crearActor(@RequestBody Actor actor) {
        actorService.crearActor(actor);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = actor.get_id(); // .toHexString();
        gR.mensaje = "Actor creado con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/actores")
    public ResponseEntity<List<Actor>> listarActores() {
        return ResponseEntity.ok(actorService.listarActores());
    }

    @GetMapping("/api/actores/{_id}")
    public ResponseEntity<Actor> buscarActorPorId(@PathVariable ObjectId _id) {
        Actor actor = actorService.obtenerAPorId(_id);
        if (actor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actor);

    }

    @GetMapping("/api/actores")
    public ResponseEntity<Actor> buscarActorPorNombre(@RequestParam(value = "nombre") String fullName) {
        Actor actor = actorService.obtenerPorNombre(fullName);
        if (actor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actor);

    }

    @PutMapping(("/api/actores/{id}"))
    ResponseEntity<GenericResponse> actualizarActorPorId(@PathVariable ObjectId id,
            @RequestBody PersonaModifRequest aR) {
        Actor actor = actorService.obtenerAPorId(id);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }

        actor.setFullName(aR.fullName);
        Actor newActor = actorService.actualizarActor(actor);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.mensaje = "Actor actualizado con éxito";
        r.id = newActor.get_id();

        return ResponseEntity.ok(r);
    }
}
