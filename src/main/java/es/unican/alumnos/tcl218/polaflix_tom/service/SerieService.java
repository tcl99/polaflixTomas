package es.unican.alumnos.tcl218.polaflix_tom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;

@Service
public class SerieService {
    
    @Autowired
    protected SerieRepository sr;

    //En todas las funciones si no se encuentra nada, se devuelve una lista vacía
    //y esta se gestiona en el controlador

    public List<Serie> getAllSeries() {
        return sr.findAllSeries();
    }

    public List<Serie> getAllSeriesByInicial (String inicial) {

        List<Serie> s = new ArrayList<>();
        char c = inicial.charAt(0);

        if(Character.isAlphabetic(c)) {
            s = sr.findSerieByInicialLetra(inicial.toUpperCase());
        }
        else if (Character.isDigit(c)) {
            s = sr.findSerieByInicialNumero();
        }
        
        return s;
    }

    public List<Serie> getSerieByTitulo (String titulo) {
        
        List<Serie> s = new ArrayList<>();
        Serie serie = sr.findByInfoTitulo(titulo);

        if(serie != null) s.add(serie);

        return s;
    }

}
