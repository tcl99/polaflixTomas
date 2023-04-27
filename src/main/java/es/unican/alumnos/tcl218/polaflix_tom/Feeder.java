package es.unican.alumnos.tcl218.polaflix_tom;

import java.time.LocalDate;
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
import es.unican.alumnos.tcl218.polaflix_tom.repositories.FacturaRepository;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@Component
@Transactional
public class Feeder implements CommandLineRunner {

    @Autowired
	protected FacturaRepository fr;
	@Autowired
	protected SerieRepository sr;
	@Autowired
	protected UsuarioRepository ur;

	@Override
	public void run(String... args) throws Exception {
		feedSerie();
		feedFactura();
		feedUsuario();
		
		test();

		Optional <Usuario> u = ur.findById("socio");
		Optional <Serie> serie = sr.findById(1l);

		u.get().marcarCapituloVisto(serie.get(), 0, serie.get().getTemporadas().get(1).getCapitulos().get(0));

		ur.save(u.get());
		
		System.out.println("Application feeded");
	}

	private void feedFactura() {
		Factura f1 = new Factura(LocalDate.now());
		Factura f2 = new Factura(LocalDate.now());
		List<Importe> importes = new ArrayList<Importe>();
		List<Importe> importes2 = new ArrayList<Importe>();

		Importe i1,i2,i3;

		Serie serie = sr.findByInfoTitulo("The Office");

		LocalDate sample = LocalDate.of(1789, 7, 14);


		i1 = new Importe(LocalDate.now(),serie, serie.getTemporadas().get(0).getNumero(), serie.getTemporadas().get(0).getCapitulos().get(0).getNumero());
		i2 = new Importe(sample,serie, serie.getTemporadas().get(1).getNumero(), serie.getTemporadas().get(1).getCapitulos().get(0).getNumero());
		i3 = new Importe(sample,serie, serie.getTemporadas().get(1).getNumero(), serie.getTemporadas().get(1).getCapitulos().get(0).getNumero());

		importes.add(i1);
		importes.add(i2);
		importes2.add(i3);
		f1.setImportes(importes);
		f1.calculaImporteMensual(false);
		f2.setImportes(importes2);
		f2.calculaImporteMensual(true);
		
		fr.save(f1);
		fr.save(f2);
		
	}
	
	private void feedSerie() {
		//SERIE A MANO

		Set<String> actores = new HashSet<>();
		actores.add("Jenna Fischer");
		actores.add("Steve Carrell");
		actores.add("John Krasinski");
		ArrayList<Temporada> t = new ArrayList<>();
		for(int i = 1; i<=9; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(22, "Casino Night", "zzz", null));
			t.add(new Temporada(i,c));
		}
		Serie a = new Serie(t, new InformacionSerie("The Office", CategoriaSerie.GOLD, "Comedia", "Serie de comedia sobre el día a día en la oficina", null, actores));
		
		sr.save(a);
	}

	private void feedUsuario() {

        Usuario u1 = new Usuario("socio", "kk", false, null);
		Usuario u2 = new Usuario("JIMBO", "pringao", true, null);
        ur.save(u1);
		ur.save(u2);
	}
	
	private void test() throws InterruptedException {

		 
		Optional<Usuario> u1 = ur.findById("socio");
		Optional<Usuario> u2 = ur.findById("JIMBO");
		Optional<Factura> formula1 = fr.findById(1l);
		Optional<Factura> formula2 = fr.findById(2l);
		List<Factura> facturas = fr.findAll();

		List<Factura> l1 = new ArrayList<>();
		List<Factura> l2 = new ArrayList<>();
 
		if(u1.isPresent()) System.out.println("Usuario: "+u1.get().getIdUsuario());
		else System.out.println("No hay tal");
		if(u2.isPresent()) System.out.println("Usuario: "+u2.get().getIdUsuario());
		else System.out.println("No hay tal");
		 

		l1.add(formula1.get());
		l2.add(formula2.get());
		u1.get().setFacturas(l1);
		u2.get().setFacturas(l2);

		for (Factura f : facturas) {
			System.out.println(f.getImporteMensual() + " " + f.getFecha());
			for (Importe i : f.getImportes()) {
				System.out.println("\t "+i.getCargo()+i.getNombreSerie());
			}
		}
		//Encontrar una serie de un usuario y metersela a otro, comprobar que no la tenga

		List<Serie> series = sr.findAll();

		Usuario usuario1 = u1.get();
		Usuario usuario2 = u2.get();

		for (Serie s : series ) {
			usuario1.agregarSerie(s);
			usuario2.agregarSerie(s);
			
		}

		ur.save(u1.get());
		ur.save(u2.get());
	}
}
