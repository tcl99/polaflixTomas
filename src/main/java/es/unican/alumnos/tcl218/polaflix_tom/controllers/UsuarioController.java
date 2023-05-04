package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.service.UsuarioService;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService us; 

    @GetMapping("/inicio")
    ResponseEntity <?> getSeriesUsuario(@RequestBody String usuario) {
        return ResponseEntity.ok(us.getSeriesUsuario(usuario));
    }
    
    @GetMapping("/facturas/{fecha}")
    ResponseEntity <?> getFacturaByFecha (@RequestBody String usuario, @PathVariable YearMonth fecha) {
        Factura f = us.getFactura(usuario, fecha);
        if(f != null) return ResponseEntity.ok(f);
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/series/anadir")
    void anadirSerie(@RequestBody Serie s, @RequestBody String usuario) {
        us.agregarSeriePendientes(s, usuario);
        //return "redirect:/series";
    }

    @PostMapping("/series")
    void marcarCapituloVisto(@RequestBody Capitulo c, @RequestBody String usuario) {
        //us.marcarCapituloVisto(c);
        //return "redirect:/appointments";
    }

    //Duda de si eta bien traer solo la info y como navegar desde inicio a las series
    /**
     * duda de si aplicar bidirecionalidad para resolver esto
     */
}
