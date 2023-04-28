package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.time.YearMonth;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByFecha(YearMonth d);
    List<Factura> findByFechaOrderByImporteMensual(YearMonth d);
    List<Factura> findByFechaBeforeOrderByFecha(YearMonth d);
    List<Factura> findByFechaAfterOrderByFecha(YearMonth d);
    List<Factura> findByImportesNombreSerie(String titulo);
}
