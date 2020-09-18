package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.GeneroService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneroController {
    @Autowired
    GeneroService generoService;

    @PostMapping("/generos")
    public ResponseEntity<GenericResponse> crearGenero(@RequestBody Genero genero) {

        generoService.crearGenero(genero);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = genero.get_id(); // .toHexString();
        gR.mensaje = "Genero creado con exito";
        return ResponseEntity.ok(gR);
    }

    @GetMapping("/generos")
    public ResponseEntity<List<Genero>> listarGeneros() {
        return ResponseEntity.ok(generoService.obtenerGeneros());
    }

    @GetMapping("/api/generos/{_id}")
    public ResponseEntity<Genero> buscarGeneroPorId(@PathVariable ObjectId _id) {
        Genero genero = generoService.obtenerGeneroById(_id);
        if (genero == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(genero);

    }

    @GetMapping("/api/generos")
    public ResponseEntity<Genero> buscarGeneroPorNombre(@RequestParam(value = "nombre") String nombre) {
        Genero genero = generoService.obtenerGeneroPorNombre(nombre);
        if (genero == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(genero);

    }
}
