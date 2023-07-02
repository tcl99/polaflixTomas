package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.time.YearMonth;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuarios/{usuario}")
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @GetMapping("")
    ResponseEntity< List<Set<Serie>> > getSeriesUsuario(@PathVariable String usuario) {
        return ResponseEntity.ok(us.getSeriesUsuario(usuario));
    }

    @GetMapping("/facturas")
    ResponseEntity<Factura> getFacturaByFecha(@PathVariable String usuario, @RequestParam YearMonth fecha) {
        Factura f = us.getFactura(usuario, fecha);
        if (f != null)
            return ResponseEntity.ok(f);
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/series/capitulos")
    ResponseEntity<List<Long>> getCapitulosVistos(@PathVariable String usuario) {
        return ResponseEntity.ok(us.getCapitulosUsuario(usuario));
    }

     @PutMapping("/series")
     ResponseEntity<String> anadirSerie(@PathVariable String usuario, @RequestBody Serie s) {
        us.agregarSeriePendientes(s, usuario);
        return ResponseEntity.ok("Serie añadida");
    }

    @PutMapping("/series/{idCapitulo}")
    ResponseEntity<String> marcarCapituloVisto(@RequestBody RequestBodyMarcarCapituloVisto body, @PathVariable String usuario) {
        us.marcarCapituloVisto(body.getS(), body.getnTemporada(), body.getC(), usuario);
        return ResponseEntity.ok("Capitulo visto");
    }
}

