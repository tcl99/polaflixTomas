package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.sql.Date;

public class Capitulo {
    
    private int numero;
    private String titulo;
    private String descripcion;
    private String enlace;
    private Date fechaVisualizacion; //En duda
    private VisualizacionCapitulo vc;

    //CONSTRUCTORS

    public Capitulo(int numero, String titulo, String descripcion, String enlace, Date fechaVisualizacion, VisualizacionCapitulo vc) {
        this.numero = numero;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.fechaVisualizacion = fechaVisualizacion;
        this.vc = vc;
    }

    //GETTERS & SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public Date getFechaVisualizacion() {
        return fechaVisualizacion;
    }
    public void setFechaVisualizacion(Date fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }
    public VisualizacionCapitulo getVc() {
        return vc;
    }
    public void setVc(VisualizacionCapitulo vc) {
        this.vc = vc;
    }
    
}
