package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

public class Temporada {
    
    private int numero;
    private Set<Capitulo> capitulos;

    //CONSTRUCTORS

    public Temporada(int numero, Set<Capitulo> capitulos) {
        this.numero = numero;
        this.capitulos = capitulos;
    }

    //GETTERS & SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Set<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    
    
}
