package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capitulo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idCapitulo;

    private int numero;
    private String titulo;
    private String descripcion;
    private String enlace;


    //CONSTRUCTORS

    protected Capitulo(){}

    public Capitulo(int numero, String titulo, String descripcion, String enlace) {
        this.numero = numero;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.enlace = enlace;
    }


    //GETTERS & SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public long getIdCapitulo() {
        return idCapitulo;
    }



    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idCapitulo ^ (idCapitulo >>> 32));
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
        Capitulo other = (Capitulo) obj;
        if (idCapitulo != other.idCapitulo)
            return false;
        return true;
    }
}
