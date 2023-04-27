package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    Serie findByInfoTitulo(String titulo);
    List<Serie> findByInfoGenero(String genero);
    List<Serie> findByInfoCategoria(String categoria);
}
