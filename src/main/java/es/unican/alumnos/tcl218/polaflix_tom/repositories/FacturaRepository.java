package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Date> {
    
}
