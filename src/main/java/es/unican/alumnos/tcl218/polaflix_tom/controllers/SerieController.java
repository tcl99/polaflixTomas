package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;

@RestController
public class SerieController {
    
    @Autowired
    private SerieRepository sr;

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
            List<InformacionSerie> series = new ArrayList<>();
            for(Serie s : sr.findAll()) {
                series.add(s.getInfo());
            }
            return ResponseEntity.ok(series);
        }
        //Si no, se comprueba si se ha recibido un caracter
        else if(titulo.length()==1) {
            char inicial = titulo.charAt(0);

            if(Character.isAlphabetic(inicial)) {
                List<InformacionSerie> series = sr.findSerieByInicialLetra(titulo.toUpperCase());
                return ResponseEntity.ok(series);
            }
            else if (Character.isDigit(inicial)) {
                List<InformacionSerie> series = sr.findSerieByInicialNumero();
                return ResponseEntity.ok(series);
            }
            else ResponseEntity.notFound().build();
        }
        //Si no es ninguna de las otras dos, se ha recibido la búsqueda de un título
        else {
            Serie s = sr.findByInfoTitulo(titulo);
            if(s != null) {
                return ResponseEntity.ok(s);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.notFound().build(); //???
    }

    //DUDASSSSSSSS
    @PostMapping("/catalogo/id/{id}")
    void putSerie(@RequestBody String titulo, @RequestBody Usuario usuario) {
        usuario.agregarSerie(sr.findByInfoTitulo(titulo));
    }


    /** DUDA, QUE ES MEJOR, TENER:
     * /catalogo/titulo/The Office
     * /catalogo/a
     * 
     * O
     * 
     * /catalogo/a
     * /catalogo/?titulo=The Office 
     * 
     * 
     * PENDIENTE, HACER LOS NOTFOUND
     * 
     * duda de como hacer el añadirserie
     * 
     * duda de si es legitimo tener mas de un repo en los controller
        */
}
