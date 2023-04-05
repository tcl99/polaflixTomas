package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.sql.Date;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capitulo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long idCapitulo;

    private int numero;
    private String titulo;
    private String descripcion;
    private String enlace;
    private Date fechaVisualizacion;

    @Embedded
    private VisualizacionCapitulo vc;

    //CONSTRUCTORS

    public Capitulo(){}

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

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((enlace == null) ? 0 : enlace.hashCode());
        result = prime * result + ((fechaVisualizacion == null) ? 0 : fechaVisualizacion.hashCode());
        result = prime * result + ((vc == null) ? 0 : vc.hashCode());
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
        Capitulo other = (Capitulo) obj;
        if (numero != other.numero)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (enlace == null) {
            if (other.enlace != null)
                return false;
        } else if (!enlace.equals(other.enlace))
            return false;
        if (fechaVisualizacion == null) {
            if (other.fechaVisualizacion != null)
                return false;
        } else if (!fechaVisualizacion.equals(other.fechaVisualizacion))
            return false;
        if (vc == null) {
            if (other.vc != null)
                return false;
        } else if (!vc.equals(other.vc))
            return false;
        return true;
    }
    

    
}
