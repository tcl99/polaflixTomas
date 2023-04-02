package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.sql.Date;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Importe {

    @Id
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

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaVisualizacion == null) ? 0 : fechaVisualizacion.hashCode());
        result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
        result = prime * result + nTemporada;
        result = prime * result + nCapitulo;
        result = prime * result + Float.floatToIntBits(cargo);
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
        Importe other = (Importe) obj;
        if (fechaVisualizacion == null) {
            if (other.fechaVisualizacion != null)
                return false;
        } else if (!fechaVisualizacion.equals(other.fechaVisualizacion))
            return false;
        if (nombreSerie == null) {
            if (other.nombreSerie != null)
                return false;
        } else if (!nombreSerie.equals(other.nombreSerie))
            return false;
        if (nTemporada != other.nTemporada)
            return false;
        if (nCapitulo != other.nCapitulo)
            return false;
        if (Float.floatToIntBits(cargo) != Float.floatToIntBits(other.cargo))
            return false;
        return true;
    }
    
    
}
