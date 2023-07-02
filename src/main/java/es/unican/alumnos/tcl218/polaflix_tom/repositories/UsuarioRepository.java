package es.unican.alumnos.tcl218.polaflix_tom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
