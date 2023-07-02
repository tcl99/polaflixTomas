package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonPropertyOrder({ "idTemporada", "numero", "capitulos"})
public class Temporada {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idTemporada;

    private int numero;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Capitulo> capitulos; 

    //CONSTRUCTORS

    protected Temporada() {}

    public Temporada(int numero, List<Capitulo> capitulos) {
        this.numero = numero;
        this.capitulos = capitulos;
    }

    //GETTERS & SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idTemporada ^ (idTemporada >>> 32));
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
        Temporada other = (Temporada) obj;
        if (idTemporada != other.idTemporada)
            return false;
        return true;
    }
}
