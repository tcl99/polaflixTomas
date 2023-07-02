package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;

public class RequestBodyMarcarCapituloVisto {
    
    private InformacionSerie s;
    private int nTemporada;
    private Capitulo c;

    public InformacionSerie getS() {
        return s;
    }
    public void setS(InformacionSerie s) {
        this.s = s;
    }
    public int getnTemporada() {
        return nTemporada;
    }
    public void setnTemporada(int nTemporada) {
        this.nTemporada = nTemporada;
    }
    public Capitulo getC() {
        return c;
    }
    public void setC(Capitulo c) {
        this.c = c;
    }
    
}
