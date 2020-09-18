package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.request.PeliRequest;
import com.pooflix.pooflix.response.GenericResponse;
import com.pooflix.pooflix.services.PeliculaService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/peliculas/{_id}")
  public ResponseEntity<Pelicula> buscarPeliculaPorId(@PathVariable ObjectId _id) {
    Pelicula pelicula = peliculaService.obtenerPeliculaPorId(_id);
    if (pelicula == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pelicula);

  }

  @GetMapping("/api/peliculas")
  public ResponseEntity<Pelicula> buscarPeliculaPorTitulo(@RequestParam(value="titulo") String titulo) {
    Pelicula pelicula = peliculaService.obtenerPeliculaPorTitulo(titulo);
    if (pelicula == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pelicula);

  }

  @PutMapping(("/api/peliculas/{_id}"))
    ResponseEntity<GenericResponse> actualizarPeliculaPorId(@PathVariable ObjectId _id, @RequestBody PeliRequest pR) {
        Pelicula pelicula = peliculaService.obtenerPeliculaPorId(_id);
        if (pelicula == null) {
            return ResponseEntity.notFound().build();
        }

        pelicula.setTitulo(pR.titulo);
        pelicula.setDuracion(pR.duracion);
        Pelicula newMovie = peliculaService.actualizarPelicula(pelicula);

        GenericResponse r = new GenericResponse();
        r.isOk = true;
        r.mensaje = "Pelicula actualizada con éxito";
        r.id = newMovie.get_id();

        return ResponseEntity.ok(r);
    }

  
  /*
  @GetMapping("/api/pooflix/peliculas/{_directorId}")
  public ResponseEntity<Pelicula> buscarPeliculaPorDirector(@RequestParam(value="director") ObjectId _directorId) {
    Pelicula pelicula = peliculaService.obtenerPeliculaPorDirector(_directorId);
    if (pelicula == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pelicula);

  }

  @GetMapping("/api/pooflix/peliculas/{_actorId}")
  public ResponseEntity<Pelicula> buscarPeliculaPorActor(@PathVariable ObjectId _actorId) {
    Pelicula pelicula = peliculaService.obtenerPeliculaPorActor(_actorId);
    if (pelicula == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pelicula);

  }

  @PostMapping("/peliculas/{_id}/actores")
  public ResponseEntity<GenericResponse> asignarActor(@PathVariable ObjectId _id,
      @RequestBody PeliculaAsigActor paa) {
    GenericResponse gR = new GenericResponse();
    if (peliculaService.asignarActor(_id, paa._idActor)) {

      gR.isOk = true;
      gR.mensaje = "Actor asignado con éxito a la pelicula";
      return ResponseEntity.ok(gR);
    }
    gR.isOk = false;
    gR.mensaje = "El actor no pudo ser asignado.";
    return ResponseEntity.badRequest().body(gR);

  }
  */
}
