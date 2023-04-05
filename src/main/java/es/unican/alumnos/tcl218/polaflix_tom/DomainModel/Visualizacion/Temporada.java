package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Temporada {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long idTemporada;

    private int numero;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Capitulo> capitulos; //LinkHashedSet

    //CONSTRUCTORS

    public Temporada() {}

    public Temporada(int numero, Set<Capitulo> capitulos) {
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

    public Set<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Set<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((capitulos == null) ? 0 : capitulos.hashCode());
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
        if (numero != other.numero)
            return false;
        if (capitulos == null) {
            if (other.capitulos != null)
                return false;
        } else if (!capitulos.equals(other.capitulos))
            return false;
        return true;
    }

    

    
}
