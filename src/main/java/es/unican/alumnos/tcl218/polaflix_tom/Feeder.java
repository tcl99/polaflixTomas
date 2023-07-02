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
		System.out.println("\nApplication feeded\n");
	}

	private void feedSerie() {
		// SERIE A MANO

		Set<String> actores = new HashSet<>();
		actores.add("Jenna Fischer");
		actores.add("Steve Carrell");
		actores.add("John Krasinski");
		Set<String> cantantes = new HashSet<>();
		cantantes.add("Liam");
		cantantes.add("Noel");
		cantantes.add("Bonehead");
		cantantes.add("Guigsy");
		cantantes.add("Alan White");
		ArrayList<Temporada> t1 = new ArrayList<>();
		ArrayList<Temporada> t2 = new ArrayList<>();
		ArrayList<Temporada> t3 = new ArrayList<>();

		for (int i = 1; i <= 7; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(22, "Casino Night", "zzz", null));
			t1.add(new Temporada(i, c));
		}
		for (int i = 1; i <= 4; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(1, "Tren", "zzz", null));
			c.add(new Capitulo(2, "Betsy", "zzz", null));
			t2.add(new Temporada(i, c));
		}
		for (int i = 1; i <= 3; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(1, "Maybeee", "Descrpcion", null));
			c.add(new Capitulo(2, "Slide Away", "Descrpcion", null));
			c.add(new Capitulo(3, "Cloudburst", "Descrpcion", null));
			c.add(new Capitulo(4, "Songbird", "Descrpcion", null));
			t3.add(new Temporada(i, c));
		}
		Serie a = new Serie(t1, new InformacionSerie("The Office", CategoriaSerie.GOLD, "Comedia",
				"Serie de comedia sobre el día a día en la oficina", null, actores));
		Serie b = new Serie(t2, new InformacionSerie("Tomas el tren", CategoriaSerie.ESTANDAR, "Comedia",
				"Serie sobre trenes", null, actores));
		Serie c = new Serie(t3, new InformacionSerie("Oasis", CategoriaSerie.SILVER, "Musica",
				"Documental sobre la banda británica", actores, cantantes));
		sr.save(a);
		sr.save(b);
		sr.save(c);
	}

	private void feedUsuario() {

		Factura f1 = new Factura(YearMonth.now());
		Factura f2 = new Factura(YearMonth.of(2023, 3));

		Factura f3 = new Factura(YearMonth.now().minusMonths(1));
		Factura f4 = new Factura(YearMonth.now());

		List<Importe> importes = new ArrayList<Importe>();
		List<Importe> importes2 = new ArrayList<Importe>();

		List<Importe> importes3 = new ArrayList<Importe>(); //VACIo
		List<Importe> importes4 = new ArrayList<Importe>(); //VACIO


		Importe i1, i2, i3;

		Serie s1 = sr.findByInfoTitulo("The Office");

		LocalDate sample = LocalDate.of(1789, 7, 14);

		//USUARIO 1
		i1 = new Importe(LocalDate.now(), s1.getInfo().getTitulo(), s1.getInfo().getCategoria(),
				s1.getTemporadas().get(0).getNumero(),
				s1.getTemporadas().get(0).getCapitulos().get(0).getNumero());
		i2 = new Importe(sample, s1.getInfo().getTitulo(), s1.getInfo().getCategoria(),
				s1.getTemporadas().get(1).getNumero(),
				s1.getTemporadas().get(1).getCapitulos().get(0).getNumero());
		i3 = new Importe(sample, s1.getInfo().getTitulo(), s1.getInfo().getCategoria(),
				s1.getTemporadas().get(1).getNumero(),
				s1.getTemporadas().get(1).getCapitulos().get(0).getNumero());

		
		importes.add(i1);
		importes.add(i2);
		importes2.add(i3);


		f1.setImportes(importes);
		f2.setImportes(importes2);
		f3.setImportes(importes3);
		f4.setImportes(importes4);

		f1.calculaImporteMensual(false);
		f2.calculaImporteMensual(true);
		

		List<Factura> lf1 = new ArrayList<>();
		List<Factura> lf2 = new ArrayList<>();

		lf1.add(f1);
		lf1.add(f2);

		lf2.add(f4);

		Usuario u1 = new Usuario("socio", "kk", false, null);
		Usuario u2 = new Usuario("JIMBO", "pringao", true, null);

		u1.agregarSerie(sr.findByInfoTitulo("Oasis"));
		u2.agregarSerie(sr.findByInfoTitulo("Oasis"));

		u1.setFacturas(lf1);
		u2.setFacturas(lf2);

		ur.save(u1);
		ur.save(u2);
	}

	private void test() throws InterruptedException {

		Optional<Usuario> o1 = ur.findById("socio");
		Optional<Usuario> o2 = ur.findById("JIMBO");

		Usuario u1 = o1.get();
		Usuario u2 = o2.get();

		Serie s1 = sr.findByInfoTitulo("The Office");
		Serie s2 = sr.findByInfoTitulo("Oasis");

		u1.agregarSerie(s1);

		//Usuario 2 no tiene importes de por si, esto sirve para comprobar que 
		//cuando se marca un capitulo como visto, se agrega el importe correspondiente

		u1.marcarCapituloVisto(s2.getInfo(), 
									 s2.getTemporadas().get(0).getNumero(), 
									 s2.getTemporadas().get(0).getCapitulos().get(0));
		u2.marcarCapituloVisto(s2.getInfo(), 
									 s2.getTemporadas().get(0).getNumero(), 
									 s2.getTemporadas().get(0).getCapitulos().get(0));
		u2.marcarCapituloVisto(s2.getInfo(), 
									 s2.getTemporadas().get(2).getNumero(), 
									 s2.getTemporadas().get(2).getCapitulos().get(0));

		ur.save(u1);
		ur.save(u2);
	}
}
