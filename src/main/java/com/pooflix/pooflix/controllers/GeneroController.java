package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Genero;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
