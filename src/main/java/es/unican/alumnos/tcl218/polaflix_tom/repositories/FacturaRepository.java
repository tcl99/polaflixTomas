package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    List<Factura> findByFechaOrderByImporteMensual(Date d);
    List<Factura> findByFechaBeforeOrderByFecha(Date d);
    List<Factura> findByFechaAfterOrderByFecha(Date d);
    List<Factura> findByImportesNombreSerie(String titulo);
}
