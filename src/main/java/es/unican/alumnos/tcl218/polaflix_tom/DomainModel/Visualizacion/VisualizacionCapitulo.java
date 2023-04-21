package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VisualizacionCapitulo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Capitulo capitulo;

    private Boolean estado;
    private int tiempoVisionado;
    private int duracion;

    //CONSTRUCTORS

    protected VisualizacionCapitulo(){}

    public VisualizacionCapitulo(int tiempoVisionado, int duracion) {
        this.tiempoVisionado = tiempoVisionado;
        this.duracion = duracion;
    }

    //OPERATIONS

    public int tiempoRestante() {
        return duracion - tiempoVisionado;
    }


    //GETTERS & SETTERS

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public int getTiempoVisionado() {
        return tiempoVisionado;
    }

    public void setTiempoVisionado(int tiempoVisionado) {
        this.tiempoVisionado = tiempoVisionado;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tiempoVisionado;
        result = prime * result + duracion;
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
        VisualizacionCapitulo other = (VisualizacionCapitulo) obj;
        if (tiempoVisionado != other.tiempoVisionado)
            return false;
        if (duracion != other.duracion)
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        return true;
    }

}
