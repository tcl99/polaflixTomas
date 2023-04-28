package es.unican.alumnos.tcl218.polaflix_tom.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/inicio")
    List < Set<InformacionSerie> > getSeriesUsuario(@RequestBody String usuario) {

        /** 
         * Se devuelve en una lista, los tres sets de las series del usuario 
         * Se devuelve solo la información porque se ha decidido cargar una serie solo
         * cuando se acceda individualmente a ella.
         * 
         * Lo que se hace es buscar al usuario, si se encuentra, se mete en 3 sets
         * la información de las series, que a su vez se meten en la lista que va a devolverse
        */

        List< Set<InformacionSerie> > listaSeriesUsuario = new ArrayList<>();
        Optional<Usuario> isUser = ur.findById(usuario);

        if(!isUser.isPresent()) return null;

        Usuario tempUser = isUser.get();

        Set<InformacionSerie> s1 = new HashSet<>();
        Set<InformacionSerie> s2 = new HashSet<>();
        Set<InformacionSerie> s3 = new HashSet<>();
        
        for (Serie s : tempUser.getEmpezadas()) {
            s1.add(s.getInfo());
        }
        for (Serie s : tempUser.getPendientes()) {
            s2.add(s.getInfo());
        }
        for (Serie s : tempUser.getTerminadas()) {
            s3.add(s.getInfo());
        }

        listaSeriesUsuario.add(s1);
        listaSeriesUsuario.add(s2);
        listaSeriesUsuario.add(s3);

        return listaSeriesUsuario;
    }

    //Duda de si eta bien traer solo la info y como navegar desde inicio a las series
    /**
     * duda de si aplicar bidirecionalidad para resolver esto
     */
}
