package es.unican.alumnos.tcl218.polaflix_tom.DomainModel;

import java.util.Set;

public class Usuario {
    
    private String idUsuario;
    private String contrasena;
    private Boolean plan;
    private String IBAN;
    private Catalogo c;
    private Set<Serie> empezadas;
    private Set<Serie> pendientes;
    private Set<Serie> terminadas;
    private Facturacion facturacion;
    

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
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    //OPERATIONS

    public void autenticacion() {

    }

    public void accederEspacioPersonal() {

    }

    public void verSerie() {

    }

    public void agregarSerie() {

    }

    public void verCargos() {

    }
}
