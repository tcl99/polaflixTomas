package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

public class Facturacion {
    
    private Set<Factura> f;

    
    //CONSTRUCTOR
    
    public Facturacion(Set<Factura> f) {
        this.f = f;
    }

    //GETTERS & SETTERS

    public Set<Factura> getF() {
        return f;
    }

    public void setF(Set<Factura> f) {
        this.f = f;
    }

    //OPERATIONS

    public void mostrarMes(Factura f) {

    }

    public Factura avanzarMes(Set<Factura> facturas) {
        return null;
    }

    public Factura retrocederMes(Set<Factura> facturas) {
        return null;
    }

}
