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

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((f == null) ? 0 : f.hashCode());
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
        Facturacion other = (Facturacion) obj;
        if (f == null) {
            if (other.f != null)
                return false;
        } else if (!f.equals(other.f))
            return false;
        return true;
    }


    
}
