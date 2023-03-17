package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

public class Serie {
    
    private Set<Temporada> temporadas;
    private InformacionSerie info;
    private String etiqueta;
    
    //CONSTRUCTORS

    public Serie(Set<Temporada> temporadas, InformacionSerie info, String etiqueta) {
        this.temporadas = temporadas;
        this.info = info;
        this.etiqueta = etiqueta;
    }

    //GETTERS & SETTERS

    public Set<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Set<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public InformacionSerie getInfo() {
        return info;
    }

    public void setInfo(InformacionSerie info) {
        this.info = info;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    //OPERATIONS

    public void mostrarCategoria(Serie s) {

    }

    public void verCapitulo(Capitulo c) {

    }

    public void mostrarInfoCapitulo(Capitulo c) {

    }


}
