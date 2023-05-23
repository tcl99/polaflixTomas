package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long idSerie;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Temporada> temporadas;

    @Embedded
    private InformacionSerie info;

    // CONSTRUCTORS

    protected Serie() {
    }

    public Serie(List<Temporada> temporadas, InformacionSerie info) {
        this.temporadas = temporadas;
        this.info = info;
    }

    // GETTERS & SETTERS

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

    public long getIdSerie() {
        return idSerie;
    }

    // hashCode & equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idSerie ^ (idSerie >>> 32));
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
        if (idSerie != other.idSerie)
            return false;
        return true;
    }

}
