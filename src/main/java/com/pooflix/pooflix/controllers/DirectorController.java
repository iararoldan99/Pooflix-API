package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Director;
import com.pooflix.pooflix.request.PersonaModifRequest;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.DirectorService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping("/directores")
    public ResponseEntity<GenericResponse> crearActor(@RequestBody Director director) {
        directorService.crearDirector(director);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = director.get_id(); // .toHexString();
        gR.mensaje = "Director creado con exito";
        return ResponseEntity.ok(gR);

    }

    @GetMapping("/directores")
    public ResponseEntity<List<Director>> listarDirectores() {
        return ResponseEntity.ok(directorService.listarDirectores());
    }

    @GetMapping("/api/directores/{_id}")
    public ResponseEntity<Director> buscarDirectorPorId(@PathVariable ObjectId _id) {
        Director director = directorService.obtenerDPorId(_id);
        if (director == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(director);

    }

    @GetMapping("/api/directores")
    public ResponseEntity<Director> buscarDirectorPorNombre(@RequestParam(value = "nombre") String fullName) {
        Director director = directorService.obtenerPorNombre(fullName);
        if (director == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(director);

    }

    @PutMapping(("/api/directores/{id}"))
    ResponseEntity<GenericResponse> actualizarDirectorPorId(@PathVariable ObjectId id, @RequestBody PersonaModifRequest dR) {
        Director director = directorService.obtenerDPorId(id);
        if (director == null) {
            return ResponseEntity.notFound().build();
        }

        director.setFullName(dR.fullName);
        Director newDirector = directorService.actualizarDirector(director);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.mensaje = "Director actualizado con éxito";
        r.id = newDirector.get_id();

        return ResponseEntity.ok(r);
    }
}
