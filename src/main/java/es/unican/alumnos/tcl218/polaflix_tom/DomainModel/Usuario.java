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
    //se ha cambiado esta parte respecto al diagrama, he decidido que el usuario sea quien separe el estado de las series
    // y que no se haga en la clase series, que puede causar problemas, pues un usuario puede haber visto una serie y otro no
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
        //TODO
        //Ir a interfaz para autenticarse
    }

    public void accederEspacioPersonal() {
        //TODO
        //ir a interfaz del espacio personal
    }

    public void verSerie() {
        //TODO
        //Ir a interfaz de series
    }

    public void agregarSerie(Serie s) {
        pendientes.add(s);
    }

    public void verCargos() {
        //TODO
        //Ir a interfaz de facturacion
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
        result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
        result = prime * result + ((plan == null) ? 0 : plan.hashCode());
        result = prime * result + ((IBAN == null) ? 0 : IBAN.hashCode());
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + ((empezadas == null) ? 0 : empezadas.hashCode());
        result = prime * result + ((pendientes == null) ? 0 : pendientes.hashCode());
        result = prime * result + ((terminadas == null) ? 0 : terminadas.hashCode());
        result = prime * result + ((facturacion == null) ? 0 : facturacion.hashCode());
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
        if (contrasena == null) {
            if (other.contrasena != null)
                return false;
        } else if (!contrasena.equals(other.contrasena))
            return false;
        if (plan == null) {
            if (other.plan != null)
                return false;
        } else if (!plan.equals(other.plan))
            return false;
        if (IBAN == null) {
            if (other.IBAN != null)
                return false;
        } else if (!IBAN.equals(other.IBAN))
            return false;
        if (c == null) {
            if (other.c != null)
                return false;
        } else if (!c.equals(other.c))
            return false;
        if (empezadas == null) {
            if (other.empezadas != null)
                return false;
        } else if (!empezadas.equals(other.empezadas))
            return false;
        if (pendientes == null) {
            if (other.pendientes != null)
                return false;
        } else if (!pendientes.equals(other.pendientes))
            return false;
        if (terminadas == null) {
            if (other.terminadas != null)
                return false;
        } else if (!terminadas.equals(other.terminadas))
            return false;
        if (facturacion == null) {
            if (other.facturacion != null)
                return false;
        } else if (!facturacion.equals(other.facturacion))
            return false;
        return true;
    }
    
}
