package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.service.SerieService;

@RestController
public class SerieController {
    
    @Autowired
    private SerieService ss;

    /**
     * 
     * @param titulo
     * @return Serie si se busca por el título, puesto que el título es único
     * @return List <Serie> si se devuelven todas o filtradas por la letra inicial del título
     */
    
    @GetMapping("/series")
    ResponseEntity <?> getSeries (@RequestParam(required = false) String titulo) {
        
        //Si no hay parámetro, se devuelven todas
        if(titulo == null) {
            return ResponseEntity.ok(ss.getAllSeries());
        }
        //Si no, se comprueba si se ha recibido un caracter
        else if(titulo.length()==1) {
            List<InformacionSerie> s = ss.getAllSeriesByInicial(titulo);
            if(s != null) {
                return ResponseEntity.ok(s);
            }
        }
        //Si no es ninguna de las otras dos, se ha recibido la búsqueda de un título
        else {
            Serie s = ss.getSerieByTitulo(titulo);
            if(s != null) {
                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.notFound().build(); 
    }


    /** DUDA, QUE ES MEJOR, TENER: 
     * PENDIENTE, HACER LOS NOTFOUND
     * 
     * duda de como hacer el añadirserie
     * 
     * duda de si es legitimo tener mas de un repo en los controller
        */
}
