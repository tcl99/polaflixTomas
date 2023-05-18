package es.unican.alumnos.tcl218.polaflix_tom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;

@Service
public class SerieService {
    
    @Autowired
    protected SerieRepository sr;

    public List<Serie> getAllSeries() {
        return sr.findAllSeries();
    }

    public List<Serie> getAllSeriesByInicial (String inicial) {
        char c = inicial.charAt(0);

        if(Character.isAlphabetic(c)) {
            return sr.findSerieByInicialLetra(inicial.toUpperCase());
        }
        else if (Character.isDigit(c)) {
            return sr.findSerieByInicialNumero();
        }
        else return null;
    }

    public Serie getSerieByTitulo (String titulo) {
        return sr.findByInfoTitulo(titulo);
    }

}
