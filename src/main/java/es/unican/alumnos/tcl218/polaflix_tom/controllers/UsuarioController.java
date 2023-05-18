package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/inicio")
    ResponseEntity<?> getSeriesUsuario(@RequestParam String usuario) {
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

    @PostMapping("/series/anadir")
    void anadirSerie(@RequestBody Serie s, @RequestBody String usuario) {
        us.agregarSeriePendientes(s, usuario);
        // return "redirect:/series";
    }

    @PostMapping("/series")
    void marcarCapituloVisto(@RequestBody InformacionSerie s, @RequestBody int nTemporada, @RequestBody Capitulo c,
            @RequestBody String usuario) {
        us.marcarCapituloVisto(s, nTemporada, c, usuario);
        // return "redirect:/appointments";
    }

    // Duda de si eta bien traer solo la info y como navegar desde inicio a las
    // series
    /**
     * duda de si aplicar bidirecionalidad para resolver esto
     */
}
