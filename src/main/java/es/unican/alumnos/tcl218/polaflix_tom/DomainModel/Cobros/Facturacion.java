package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Embeddable
public class Facturacion {
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Factura> f;

    
    //CONSTRUCTOR
    public Facturacion() {
    }

    public Facturacion(ArrayList<Factura> f) {
        this.f = f;
    }

    //GETTERS & SETTERS

    public ArrayList<Factura> getF() {
        return f;
    }

    public void setF(ArrayList<Factura> f) {
        this.f = f;
    }

    //OPERATIONS

    public void mostrarMes(Factura f) {
        //Mostrar mes
    }

    // Estas dos funciones no se implementan porque se ha decidido que se puede navegar sobre el array directamente sin llamar a funciones
    /* 
    
    public Factura avanzarMes(Factura f) {
        return null;
    }

    public Factura retrocederMes(Factura f) {
        return null;
    }
    
    */

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
