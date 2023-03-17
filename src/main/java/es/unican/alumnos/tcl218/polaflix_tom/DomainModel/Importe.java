package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.sql.Date;


public class Importe {

    private Date fechaVisualizacion;
    private String nombreSerie;
    private int nTemporada;
    private int nCapitulo;
    private float cargo;

    //CONSTRUCTOR
    public Importe(Date fechaVisualizacion, Serie serie, int nTemporada, int nCapitulo) {
        this.fechaVisualizacion = fechaVisualizacion;
        this.nombreSerie = serie.getInfo().getTitulo();
        this.nTemporada = nTemporada;
        this.nCapitulo = nCapitulo;
        switch(serie.getInfo().getCategoria()) {
            case "Estandar":
                this.cargo = 0.50f;
                break;
            case "Silver": 
                this.cargo = 0.75f;
                break;
            case "Gold":
                this.cargo = 1.50f;
                break;
        }
    }

    //GETTERS & SETTERS

    public Date getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(Date fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public int getnTemporada() {
        return nTemporada;
    }

    public void setnTemporada(int nTemporada) {
        this.nTemporada = nTemporada;
    }

    public int getnCapitulo() {
        return nCapitulo;
    }

    public void setnCapitulo(int nCapitulo) {
        this.nCapitulo = nCapitulo;
    }

    public float getCargo() {
        return cargo;
    }
    
}
