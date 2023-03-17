package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

public class InformacionSerie {
    
    private String titulo;
    private String categoria;
    private String genero;
    private String descripcion;
    private Set <String> creadores;
    private Set <String> actores;

    //CONSTRUCTOR
    
    public InformacionSerie(String titulo, String categoria, String genero, String descripcion, Set<String> creadores,
            Set<String> actores) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.genero = genero;
        this.descripcion = descripcion;
        this.creadores = creadores;
        this.actores = actores;
    }

    //GETTERS & SETTERS

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<String> getCreadores() {
        return creadores;
    }

    public void setCreadores(Set<String> creadores) {
        this.creadores = creadores;
    }

    public Set<String> getActores() {
        return actores;
    }

    public void setActores(Set<String> actores) {
        this.actores = actores;
    }

    
}

