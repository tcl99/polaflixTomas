package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long idImporte;

    private Date fecha;
    private float importeMensual;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Importe> importes;


    //CONSTRUCTORS
    
    protected Factura() {}
    
    public Factura(Date fecha) {
        this.fecha = fecha;
    }

    public Factura(Date fecha, Set<Importe> importes) {
        this.fecha = fecha;
        this.importes = importes;
    }
    

    //GETTERS & SETTERS


    public float getImporteMensual() {
        return importeMensual;
    }

    public Set<Importe> getImportes() {
        return importes;
    }

    public void setImportes(Set<Importe> importes) {
        this.importes = importes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //OPERATIONS

    public void calculaImporteMensual(boolean plan) {
        if(plan) this.importeMensual = 20f;
        else {
            for (Importe importe : importes) {
                this.importeMensual += importe.getCargo();
            }
        }
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + Float.floatToIntBits(importeMensual);
        result = prime * result + ((importes == null) ? 0 : importes.hashCode());
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
        Factura other = (Factura) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (Float.floatToIntBits(importeMensual) != Float.floatToIntBits(other.importeMensual))
            return false;
        if (importes == null) {
            if (other.importes != null)
                return false;
        } else if (!importes.equals(other.importes))
            return false;
        return true;
    }

    
    
}
