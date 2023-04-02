package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import jakarta.persistence.Embeddable;

@Embeddable
public class VisualizacionCapitulo {
    
    private int tiempoVisionado;
    private int duracion;
    private String estado;

    //CONSTRUCTORS

    public VisualizacionCapitulo(int tiempoVisionado, int duracion) {
        this.tiempoVisionado = tiempoVisionado;
        this.duracion = duracion;
    }

    //GETTERS & SETTERS

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


    public String getEstado() {
        if(tiempoVisionado == 0) estado = "Pendiente";
        else if(tiempoVisionado > duracion*0.95) estado = "Visto";
        else estado = "En curso";

        return estado;
    }


    //OPERATIONS

    public int tiempoRestante() {
        return duracion - tiempoVisionado;
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
