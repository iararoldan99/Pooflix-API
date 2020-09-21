package com.pooflix.pooflix.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

}
