package com.pooflix.pooflix.documents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Series")
public class Serie extends Contenido {
    @Field(order = 10)
    private List<Temporada> temporadas = new ArrayList<>();

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

}
