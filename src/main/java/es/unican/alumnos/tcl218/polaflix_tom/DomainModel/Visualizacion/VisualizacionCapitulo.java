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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Capitulo capitulo;

    private int tiempoVisionado;
    private int duracion;

    //CONSTRUCTORS

    protected VisualizacionCapitulo(){}

    public VisualizacionCapitulo(int tiempoVisionado, int duracion) {
        this.tiempoVisionado = tiempoVisionado;
        this.duracion = duracion;
    }

    
    public VisualizacionCapitulo(Usuario usuario, Capitulo capitulo) {
        this.usuario = usuario;
        this.capitulo = capitulo;
        this.tiempoVisionado = 0;
        this.duracion = 0;
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


    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((capitulo == null) ? 0 : capitulo.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (capitulo == null) {
            if (other.capitulo != null)
                return false;
        } else if (!capitulo.equals(other.capitulo))
            return false;
        return true;
    }

}
