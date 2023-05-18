package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Importe;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.VisualizacionCapitulo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

@Entity
public class Usuario {
    
    @Id 
    private String idUsuario;
    
    private String contrasena;
    private Boolean plan;
    private String IBAN;

    /*
     * 
     * OneToMany: LAZY
     * ManyToOne: EAGER
     * ManyToMany: LAZY
     * OneToOne: EAGER
     * 
     * Se ha decidido dejarlo por defecto todo, por lo tanto son eager
     */

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<VisualizacionCapitulo> vc = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("fecha")
    private List<Factura> facturas = new ArrayList<>();

    @ManyToMany
    private Set<Serie> empezadas = new HashSet<>() ;
    @ManyToMany
    private Set<Serie> pendientes = new HashSet<>();
    @ManyToMany
    private Set<Serie> terminadas = new HashSet<>();


    //CONSTRUCTORS

    protected Usuario() {}
    
    public Usuario(String idUsuario, String contrasena, Boolean plan, String iBAN) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.plan = plan;
        IBAN = iBAN;
    }

    //OPERATIONS
    
    public void agregarSerie(Serie s) {
        if(terminadas.contains(s) || empezadas.contains(s) || s == null) return;
        else pendientes.add(s);
    }

    public void marcarCapituloVisto(InformacionSerie infoSerie, int nTemporada, Capitulo c) {
        VisualizacionCapitulo visualizacionCapitulo = new VisualizacionCapitulo(this, c);
        this.vc.add(visualizacionCapitulo);
        //Se añade el importe al último mes
        facturas.get(facturas.size()-1).agregarImporte(new Importe(LocalDate.now(), infoSerie.getTitulo(), infoSerie.getCategoria(), nTemporada, c.getNumero()));
    }
    public Factura getFacturaByFecha(YearMonth fecha) {
        for (Factura f : facturas) {
            if(f.getFecha().equals(fecha)) return f;
        }
        return null;
    }

    //GETTERS & SETTERS

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getPlan() {
        return plan;
    }

    public void setPlan(Boolean plan) {
        this.plan = plan;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public Set<Serie> getEmpezadas() {
        return empezadas;
    }

    public void setEmpezadas(Set<Serie> empezadas) {
        this.empezadas = empezadas;
    }

    public Set<Serie> getPendientes() {
        return pendientes;
    }

    public void setPendientes(Set<Serie> pendientes) {
        this.pendientes = pendientes;
    }

    public Set<Serie> getTerminadas() {
        return terminadas;
    }

    public void setTerminadas(Set<Serie> terminadas) {
        this.terminadas = terminadas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }


    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        return true;
    }
    
}
