package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

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

    public void clasificarPorInicial() {

    }

    public void buscarNombre() {

    }

    public void anadirSerie() {

    }

    public void mostrarInfoSerie() {

    }
}
