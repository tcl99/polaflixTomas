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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((creadores == null) ? 0 : creadores.hashCode());
        result = prime * result + ((actores == null) ? 0 : actores.hashCode());
        return result;
    }

    //hashCode & equals

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InformacionSerie other = (InformacionSerie) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (creadores == null) {
            if (other.creadores != null)
                return false;
        } else if (!creadores.equals(other.creadores))
            return false;
        if (actores == null) {
            if (other.actores != null)
                return false;
        } else if (!actores.equals(other.actores))
            return false;
        return true;
    }

    
}

