package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long idFactura;

    private LocalDate fecha;
    private float importeMensual;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Importe> importes;


    //CONSTRUCTORS
    
    protected Factura() {}
    
    public Factura(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Factura(LocalDate fecha, List<Importe> importes) {
        this.fecha = fecha;
        this.importes = importes;
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

    public void agregarImporte (Importe i) {
        this.importes.add(i);
    }

    //GETTERS & SETTERS


    public float getImporteMensual() {
        return importeMensual;
    }

    public List<Importe> getImportes() {
        return importes;
    }

    public void setImportes(List<Importe> importes) {
        this.importes = importes;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idFactura ^ (idFactura >>> 32));
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
        if (idFactura != other.idFactura)
            return false;
        return true;
    }
    
}
