package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.FacturaRepository;

@RestController
public class FacturaController {
    
    @Autowired
    private FacturaRepository fr; 

    @GetMapping("/facturas/{fecha}")
    List <Factura> getFacturaByFecha (@PathVariable YearMonth fecha) {
        //Como las facturas se generan el día 1 de cada mes, se busca siempre el día 1
        return fr.findByFecha(fecha);
    }

}
