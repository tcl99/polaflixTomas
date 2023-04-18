package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario;

import java.util.HashSet;
import java.util.Set;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Facturacion;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Catalogo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {
    
    @Id 
    private String idUsuario;
    
    private String contrasena;
    private Boolean plan;
    private String IBAN;

    @Embedded
    private Catalogo c;

    @Embedded
    private Facturacion f;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Serie> empezadas = new HashSet<>() ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Serie> pendientes = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER) 
    private Set<Serie> terminadas = new HashSet<>();


    //CONSTRUCTORS

    protected Usuario() {}
    
    public Usuario(String idUsuario, String contrasena, Boolean plan, String iBAN) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.plan = plan;
        IBAN = iBAN;
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

    public Catalogo getC() {
        return c;
    }

    public void setC(Catalogo c) {
        this.c = c;
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

    public Facturacion getFacturacion() {
        return f;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.f = facturacion;
    }

    //OPERATIONS

    /* 
    
    De momento estas operaciones no han de estar aquí, pero se comentan para acordarme después de ponerlas en otro sitio 

    public void autenticacion() {
        //Ir a interfaz para autenticarse
    }

    public void accederEspacioPersonal() {
        //ir a interfaz del espacio personal
    }

    public void verSerie() {
        //Ir a interfaz de series
    }

    public void verCargos() {
        //Ir a interfaz de facturacion
    }

    */
    
    public void agregarSerie(Serie s) {
        if(terminadas.contains(s) || empezadas.contains(s)) return;
        else pendientes.add(s);
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
