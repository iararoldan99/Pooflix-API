package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public ResponseEntity<GenericResponse> crearPelicula(@RequestBody Pelicula pelicula) {

        Pelicula p = peliculaService.crearPelicula(pelicula);

        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = p.get_id(); 
        gR.mensaje = "Pelicula creada con exito";
        return ResponseEntity.ok(gR);
    }

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        return ResponseEntity.ok(peliculaService.obtenerTodasLasPeliculas());
    }
}
