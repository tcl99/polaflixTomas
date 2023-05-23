package es.unican.alumnos.tcl218.polaflix_tom.service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    protected UsuarioRepository ur;

    public List<Set<Serie>> getSeriesUsuario(String nombreUsuario) {
        /**
         * Se devuelve en una lista, los tres sets de las series del usuario
         * Se devuelve solo la información porque se ha decidido cargar una serie solo
         * cuando se acceda individualmente a ella.
         * 
         * Lo que se hace es buscar al usuario, si se encuentra, se mete en 3 sets
         * la información de las series, que a su vez se meten en la lista que va a
         * devolverse
         */
        Optional<Usuario> isUser = ur.findById(nombreUsuario);
        if (!isUser.isPresent()) {
            return null;
        }
        Usuario u = isUser.get();

        List<Set<Serie>> listaSeriesUsuario = new ArrayList<>();

        listaSeriesUsuario.add(u.getEmpezadas().stream().collect(Collectors.toSet()));
        listaSeriesUsuario.add(u.getPendientes().stream().collect(Collectors.toSet()));
        listaSeriesUsuario.add(u.getTerminadas().stream().collect(Collectors.toSet()));

        return listaSeriesUsuario;
    }

    public Factura getFactura(String nombreUsuario, YearMonth fecha) {
        /**
         * Devuelve una factura por fecha
         */
        Optional<Usuario> isUser = ur.findById(nombreUsuario);
        if (!isUser.isPresent()) {
            return null;
        }
        Usuario u = isUser.get();

        return u.getFacturaByFecha(fecha);
    }

    public void agregarSeriePendientes(Serie s, String nombreUsuario) {
        Optional<Usuario> isUser = ur.findById(nombreUsuario);
        if (!isUser.isPresent()) {
            return;
        }
        Usuario u = isUser.get();

        u.agregarSerie(s);

        ur.save(u);
    }

    public void marcarCapituloVisto(InformacionSerie s, int nTemporada, Capitulo c, String nombreUsuario) {
        Optional<Usuario> isUser = ur.findById(nombreUsuario);
        if (!isUser.isPresent()) {
            return;
        }
        Usuario u = isUser.get();

        u.marcarCapituloVisto(s, nTemporada, c);
    }
}
