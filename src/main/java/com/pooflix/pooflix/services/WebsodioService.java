package com.pooflix.pooflix.services;

import java.util.List;
import java.util.Optional;

import com.pooflix.pooflix.documents.Websodio;
import com.pooflix.pooflix.repository.WebsodioRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsodioService {
    @Autowired
    WebsodioRepository wRepo;

    public boolean crearNuevoWebsodio(Websodio websodio) {
        wRepo.save(websodio);
        return true;
    }

    boolean existeWebsodio(Integer numero) {
        Websodio websodio = wRepo.findByNumero(numero);
        if (websodio != null)
            return true;
        else
            return false;
    }

    public Websodio crearWebsodio(Integer numero, String titulo, double duracion, String url) {
        if (existeWebsodio(numero)) {
            return null;
        } else {
            Websodio websodio = new Websodio();
            websodio.setNumero(numero);
            websodio.setTitulo(titulo);
            websodio.setDuracion(duracion);
            websodio.setUrl(url);

            boolean webCreado = crearNuevoWebsodio(websodio);
            if (webCreado)
                return websodio;
            else
                return null;
        }

    }

    public List<Websodio> listarWebsodios() {
        return wRepo.findAll();
    }

    public Websodio obtenerWebsodioPorId(ObjectId _id) {
        Optional<Websodio> opWeb = wRepo.findById(_id);

        if (opWeb.isPresent())
            return opWeb.get();
        else
            return null;
    }

    public Websodio obtenerWebsodioPorNumero(Integer numero) {
        return wRepo.findByNumero(numero);
    }

    public Websodio obtenerWebsodioPorTitulo(String titulo) {
        return wRepo.findByTitulo(titulo);
    }

}
