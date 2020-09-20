package com.pooflix.pooflix.controllers;

import java.util.List;

import com.pooflix.pooflix.documents.Pelicula;
import com.pooflix.pooflix.models.request.ModifPeli;
import com.pooflix.pooflix.models.request.PeliCalif;
import com.pooflix.pooflix.models.request.PeliRequest;
import com.pooflix.pooflix.models.response.GenericResponse;
import com.pooflix.pooflix.services.PeliculaService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeliculaController {
  @Autowired
  PeliculaService peliculaService;

  @PostMapping("/peliculas")
  public ResponseEntity<GenericResponse> crearPelicula(@RequestBody PeliRequest peliReq) {

      Pelicula pelicula = peliculaService.crearPelicula(peliReq.titulo, peliReq.generos, peliReq.directores, peliReq.actores);
      if (pelicula == null) {
          return ResponseEntity.badRequest().build();
      }
      GenericResponse gR = new GenericResponse();
      gR.isOk = true;
      gR.id = pelicula.get_id();
      gR.mensaje = "La pelicula fue creada exitosamente";
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
  public ResponseEntity<Pelicula> buscarPeliculaPorTitulo(@RequestParam(value = "titulo") String titulo) {
    Pelicula pelicula = peliculaService.obtenerPeliculaPorTitulo(titulo);
    if (pelicula == null)
      return ResponseEntity.notFound().build();
    return ResponseEntity.ok(pelicula);

  }

  @PutMapping("/peliculas/{id}")
  public ResponseEntity<GenericResponse> modificarPelicula(@PathVariable ObjectId _id, ModifPeli modifPeli) {
      Pelicula pelicula = peliculaService.obtenerPeliculaPorId(_id);
      if (pelicula == null) {
          return ResponseEntity.notFound().build();
      }

      else {

          Pelicula peliModificada = peliculaService.modificarPelicula(pelicula, modifPeli);
          if (peliModificada == null) {
              return ResponseEntity.badRequest().build();
          } else {
              GenericResponse gR = new GenericResponse();
              gR.id = peliModificada.get_id();
              gR.isOk = true;
              gR.mensaje = "Los datos de la pelicula fueron actualizados exitosamente";

              return ResponseEntity.ok(gR);

          }
      }
  }

  @PutMapping("/api/peliculas/{_id}")
  ResponseEntity<GenericResponse> calificarLaPelicula(@PathVariable ObjectId _id, PeliCalif calificacion) {

      Pelicula pelicula = peliculaService.obtenerPeliculaPorId(_id);
      if (pelicula == null) {
          return ResponseEntity.notFound().build();
      } else {
          Pelicula peliCalificada = peliculaService.calificarPelicula(pelicula, calificacion);
          GenericResponse gR = new GenericResponse();
          gR.id = peliCalificada.get_id();
          gR.isOk = true;
          gR.mensaje = "enviaste tu calificacion exitosamente, el puntaje de la pelicula es: "
                  + peliCalificada.getCalificacion();
          return ResponseEntity.ok(gR);
      }

  }

}
