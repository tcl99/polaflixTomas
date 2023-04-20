package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.util.Date;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Importe {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long idImporte;

    private Date fechaVisualizacion;
    private String nombreSerie;
    private int nTemporada;
    private int nCapitulo;
    private float cargo;

    //CONSTRUCTOR
    protected Importe() {}
    
    public Importe(Date fechaVisualizacion, Serie serie, int nTemporada, int nCapitulo) {
        this.fechaVisualizacion = fechaVisualizacion;
        this.nombreSerie = serie.getInfo().getTitulo();
        this.nTemporada = nTemporada;
        this.nCapitulo = nCapitulo;
        switch(serie.getInfo().getCategoria()) {
            case ESTANDAR:
                this.cargo = 0.50f;
                break;
            case SILVER:
                this.cargo = 0.75f;
                break;
            case GOLD:
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
        result = prime * result + (int) (idImporte ^ (idImporte >>> 32));
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
        if (idImporte != other.idImporte)
            return false;
        return true;
    }    
    
}
