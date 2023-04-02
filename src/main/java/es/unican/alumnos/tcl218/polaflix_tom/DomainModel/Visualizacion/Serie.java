package es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion;

import java.util.Set;

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
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long idSerie;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Temporada> temporadas;

    @Embedded
    private InformacionSerie info;
    
    private String etiqueta;
    
    //CONSTRUCTORS

    public Serie(Set<Temporada> temporadas, InformacionSerie info, String etiqueta) {
        this.temporadas = temporadas;
        this.info = info;
        this.etiqueta = etiqueta;
    }

    //GETTERS & SETTERS

    public Set<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Set<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public InformacionSerie getInfo() {
        return info;
    }

    public void setInfo(InformacionSerie info) {
        this.info = info;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
        result = prime * result + ((etiqueta == null) ? 0 : etiqueta.hashCode());
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
        if (etiqueta == null) {
            if (other.etiqueta != null)
                return false;
        } else if (!etiqueta.equals(other.etiqueta))
            return false;
        return true;
    }


}
