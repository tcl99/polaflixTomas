package es.unican.alumnos.tcl218.polaflix_tom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    protected UsuarioRepository ur;
}