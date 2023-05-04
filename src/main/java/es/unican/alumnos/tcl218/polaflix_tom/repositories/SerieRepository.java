package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    Serie findByInfoTitulo(String titulo);
    List<Serie> findByInfoGenero(String genero);
    List<Serie> findByInfoCategoria(String categoria);

    @Query("SELECT info FROM Serie")
    List<InformacionSerie> findAllSeries();
    @Query("SELECT info FROM Serie WHERE SUBSTRING(info.titulo, 1, 1) = :inicial ORDER BY info.titulo")
    List<InformacionSerie> findSerieByInicialLetra(@Param("inicial")String inicial);
    @Query("SELECT info FROM Serie WHERE SUBSTRING(info.titulo, 1, 1) IN ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') ORDER BY info.titulo ASC ")
    List<InformacionSerie> findSerieByInicialNumero();
}
