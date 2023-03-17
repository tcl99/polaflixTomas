package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Catalogo {
    
    private Set <Serie> series;

    //CONSTRUCTORS
    
    public Catalogo(Set <Serie> series) {
        this.series = series;
    }

    //GETTERS & SETTERS

    public Set <Serie> getSeries() {
        return series;
    }

    public void setSeries(Set <Serie> series) {
        this.series = series;
    }

    //OPERATIONS (this.series)

    public Set<Serie> clasificarPorInicial(char inicial) {
        Set<Serie> match = new TreeSet<>();

        for (Serie serie : match) {
           if(serie.getInfo().getTitulo().charAt(0) == inicial) {
                match.add(serie);
           } 
        }

        return match;
    }

    public Set<Serie> buscarNombre(String nombre) {
        Set<Serie> match = new HashSet<>();

        for (Serie serie : series) {
            if(serie.getInfo().getTitulo().contains(nombre)) {
                match.add(serie);
            }
        }

        return match;
    }

    public Serie agregarSerie() {
        Serie s = new Serie(null, null, null);
        //DEvolver serie para que el usuario guarde;
        return s;
    }

    public void mostrarInfoSerie() {

    }
}
