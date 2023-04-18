package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

@Embeddable
public class Facturacion {
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Factura> f = new ArrayList<>();

    //CONSTRUCTOR
    protected Facturacion() {}

    public Facturacion(List<Factura> f) {
        this.f = f;
    }

    //GETTERS & SETTERS

    public List<Factura> getF() {
        return f;
    }

    public void setF(List<Factura> f) {
        this.f = f;
    }

    //OPERATIONS

    public void mostrarMes(Factura f) {
        //Mostrar mes
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
