package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

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
        else if(tiempoVisionado >= duracion*0.95) estado = "Visto";
        else estado = "En curso";

        return estado;
    }


    //OPERATIONS

    public int tiempoRestante() {
        return 0;
    }
}
