package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.service.UsuarioService;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @GetMapping("/usuarios/{usuario}")
    ResponseEntity<?> getSeriesUsuario(@PathVariable String usuario) {
        return ResponseEntity.ok(us.getSeriesUsuario(usuario));
    }

    @GetMapping("/facturas")
    ResponseEntity<?> getFacturaByFecha(@RequestParam String usuario, @RequestParam YearMonth fecha) {
        Factura f = us.getFactura(usuario, fecha);
        if (f != null)
            return ResponseEntity.ok(f);
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/series")
    void anadirSerie(@RequestBody Serie s) {
        us.agregarSeriePendientes(s, "socio");
        // return "redirect:/series";
    }

    @PostMapping("/series/cap")
    void marcarCapituloVisto(@RequestBody InformacionSerie s, @RequestBody int nTemporada, @RequestBody Capitulo c,
            @RequestBody String usuario) {
        us.marcarCapituloVisto(s, nTemporada, c, usuario);
        // return "redirect:/appointments";
    }
}
