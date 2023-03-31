package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

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

    public void mostrarInfoSerie(Serie s) {
        s.getInfo(); //dudas
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((series == null) ? 0 : series.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Catalogo other = (Catalogo) obj;
        if (series == null) {
            if (other.series != null)
                return false;
        } else if (!series.equals(other.series))
            return false;
        return true;
    }

    
}
