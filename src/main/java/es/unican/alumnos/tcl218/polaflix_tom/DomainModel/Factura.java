package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.sql.Date;
import java.util.Set;

public class Factura {
    
    private Date fecha;
    private float importeMensual;
    private Set<Importe> importes;


    //CONSTRUCTOR
    public Factura(Date fecha, float importeMensual, Set<Importe> importes) {
        this.fecha = fecha;
        this.importeMensual = importeMensual;
        this.importes = importes;
    }

    //GETTERS & SETTERS

    public float getImporteMensual() {
        return importeMensual;
    }

    public void setImporteMensual(float importeMensual) {
        this.importeMensual = importeMensual;
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
    
}
