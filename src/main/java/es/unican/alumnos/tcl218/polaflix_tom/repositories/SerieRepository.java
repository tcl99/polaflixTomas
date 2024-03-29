package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    Serie findByInfoTitulo(String titulo);

    @Query("SELECT s FROM Serie s")
    List<Serie> findAllSeries();

    @Query("SELECT s FROM Serie s WHERE SUBSTRING(info.titulo, 1, 1) = :inicial ORDER BY info.titulo")
    List<Serie> findSerieByInicialLetra(@Param("inicial") String inicial);

    @Query("SELECT s FROM Serie s WHERE SUBSTRING(info.titulo, 1, 1) IN ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') ORDER BY info.titulo ASC ")
    List<Serie> findSerieByInicialNumero();
}
