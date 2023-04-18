package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long idSerie;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Temporada> temporadas;

    @Embedded
    private InformacionSerie info;
    
    //CONSTRUCTORS

    protected Serie(){}

    public Serie(List<Temporada> temporadas, InformacionSerie info) {
        this.temporadas = temporadas;
        this.info = info;
    }

    //GETTERS & SETTERS

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public InformacionSerie getInfo() {
        return info;
    }

    public void setInfo(InformacionSerie info) {
        this.info = info;
    }

    //OPERATIONS


    public void verCapitulo(Capitulo c) {
        //Play
    }

    //hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((temporadas == null) ? 0 : temporadas.hashCode());
        result = prime * result + ((info == null) ? 0 : info.hashCode());
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
        Serie other = (Serie) obj;
        if (temporadas == null) {
            if (other.temporadas != null)
                return false;
        } else if (!temporadas.equals(other.temporadas))
            return false;
        if (info == null) {
            if (other.info != null)
                return false;
        } else if (!info.equals(other.info))
            return false;
        return true;
    }


}
