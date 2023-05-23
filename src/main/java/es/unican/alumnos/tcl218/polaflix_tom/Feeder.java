package es.unican.alumnos.tcl218.polaflix_tom;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Importe;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.CategoriaSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Temporada;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@Component
@Transactional
public class Feeder implements CommandLineRunner {

	@Autowired
	protected SerieRepository sr;
	@Autowired
	protected UsuarioRepository ur;

	@Override
	public void run(String... args) throws Exception {
		feedSerie();
		feedUsuario();

		test();

		Optional<Usuario> u = ur.findById("socio");

		ur.save(u.get());

		System.out.println("Application feeded");
	}

	private void feedSerie() {
		// SERIE A MANO

		Set<String> actores = new HashSet<>();
		actores.add("Jenna Fischer");
		actores.add("Steve Carrell");
		actores.add("John Krasinski");
		ArrayList<Temporada> t1 = new ArrayList<>();
		ArrayList<Temporada> t2 = new ArrayList<>();

		for (int i = 1; i <= 9; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(22, "Casino Night", "zzz", null));
			t1.add(new Temporada(i, c));
		}
		for (int i = 1; i <= 9; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(22, "Tren", "zzz", null));
			t2.add(new Temporada(i, c));
		}
		Serie a = new Serie(t1, new InformacionSerie("The Office", CategoriaSerie.GOLD, "Comedia",
				"Serie de comedia sobre el día a día en la oficina", null, actores));
		Serie b = new Serie(t2, new InformacionSerie("Tomas el tren", CategoriaSerie.ESTANDAR, "Comedia",
				"Serie sobre trenes", null, actores));
		sr.save(a);
		sr.save(b);
	}

	private void feedUsuario() {

		Factura f1 = new Factura(YearMonth.now());
		Factura f2 = new Factura(YearMonth.of(2023, 3));
		List<Importe> importes = new ArrayList<Importe>();
		List<Importe> importes2 = new ArrayList<Importe>();

		Importe i1, i2, i3;

		Serie serie = sr.findByInfoTitulo("The Office");

		LocalDate sample = LocalDate.of(1789, 7, 14);

		i1 = new Importe(LocalDate.now(), serie.getInfo().getTitulo(), serie.getInfo().getCategoria(),
				serie.getTemporadas().get(0).getNumero(),
				serie.getTemporadas().get(0).getCapitulos().get(0).getNumero());
		i2 = new Importe(sample, serie.getInfo().getTitulo(), serie.getInfo().getCategoria(),
				serie.getTemporadas().get(1).getNumero(),
				serie.getTemporadas().get(1).getCapitulos().get(0).getNumero());
		i3 = new Importe(sample, serie.getInfo().getTitulo(), serie.getInfo().getCategoria(),
				serie.getTemporadas().get(1).getNumero(),
				serie.getTemporadas().get(1).getCapitulos().get(0).getNumero());

		importes.add(i1);
		importes.add(i2);
		importes2.add(i3);

		f1.setImportes(importes);
		f1.calculaImporteMensual(false);
		f2.setImportes(importes2);
		f2.calculaImporteMensual(true);

		List<Factura> lf1 = new ArrayList<>();
		List<Factura> lf2 = new ArrayList<>();

		lf1.add(f1);
		lf1.add(f2);

		Usuario u1 = new Usuario("socio", "kk", false, null);
		Usuario u2 = new Usuario("JIMBO", "pringao", true, null);

		u1.setFacturas(lf1);
		u2.setFacturas(lf2);

		ur.save(u1);
		ur.save(u2);
	}

	private void test() throws InterruptedException {

		Optional<Usuario> u1 = ur.findById("socio");
		Optional<Usuario> u2 = ur.findById("JIMBO");

		if (u1.isPresent())
			System.out.println("Usuario: " + u1.get().getIdUsuario());
		else
			System.out.println("No hay tal");
		if (u2.isPresent())
			System.out.println("Usuario: " + u2.get().getIdUsuario());
		else
			System.out.println("No hay tal");

		// Encontrar una serie de un usuario y metersela a otro, comprobar que no la
		// tenga

		Serie s = sr.findByInfoTitulo("The Office");

		Usuario usuario1 = u1.get();

		usuario1.agregarSerie(s);

		ur.save(u1.get());
	}
}
