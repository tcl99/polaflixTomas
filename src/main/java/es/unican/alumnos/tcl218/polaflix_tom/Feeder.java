package es.unican.alumnos.tcl218.polaflix_tom;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.	util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Importe;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Capitulo;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Temporada;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.VisualizacionCapitulo;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.FacturaRepository;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.SerieRepository;
import es.unican.alumnos.tcl218.polaflix_tom.repositories.UsuarioRepository;

@Component
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
		
		System.out.println("Application feeded");
	}

	private void feedFactura() {
		Factura f1 = new Factura(new Date(0));
		Set<Importe> importes = new HashSet<Importe>();
		Importe i1,i2;

		List<Serie> s = sr.findByInfoTituloOrderByInfoTitulo("The Office");
		Serie serie = s.get(0);

		i1 = new Importe(new Date(System.currentTimeMillis()),serie, serie.getTemporadas().get(0).getNumero(), serie.getTemporadas().get(0).getCapitulos().get(0).getNumero());

		i2 = new Importe(new Date(System.currentTimeMillis()),serie, serie.getTemporadas().get(1).getNumero(), serie.getTemporadas().get(1).getCapitulos().get(0).getNumero());

		importes.add(i1);
		importes.add(i2);
		f1.setImportes(importes);
		f1.calculaImporteMensual(true);
		
		fr.save(f1);
		
	}
	
	private void feedSerie() {
		Set<String> act = new HashSet<>();
		act.add("Jenna Fischer");
		act.add("Steve Carrell");
		act.add("John Krasinski");
		ArrayList<Temporada> t = new ArrayList<>();
		for(int i = 1; i<=9; i++) {
			ArrayList<Capitulo> c = new ArrayList<>();
			c.add(new Capitulo(22, "Casino Night", null, null, null, new VisualizacionCapitulo(1,1)));
			t.add(new Temporada(i,c));
		}
		Serie c = new Serie(t, 
			new InformacionSerie("The Office", "Gold", "Comedia", "Una serie sobre el día a día en la oficina", null, act));
		sr.save(c);
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
 
		if(u1.isPresent()) System.out.println("Usuario: "+u1.get().getIdUsuario());
		else System.out.println("No hay tal");
		if(u2.isPresent()) System.out.println("Usuario: "+u2.get().getIdUsuario());
		else System.out.println("No hay tal");
		 
		SimpleDateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy");
		Date sample = null;
		try {
			sample = dateParser.parse("01-01-2020");
		} catch (ParseException e) {
			System.out.println("Crujo parseando fecha");
			e.printStackTrace();
		}
        
	
		List<Factura> facturas = fr.findByFechaBeforeOrderByFecha(sample); 

		for (Factura f : facturas) {
			System.out.println(f.getImporteMensual() + " " + f.getFecha());
			for (Importe i : f.getImportes()) {
				System.out.println("\t "+i.getCargo()+i.getNombreSerie());
			}
		}
 

		//Encontrar una serie de un usuario y metersela a otro, comprobar que no la tenga

		List<Serie> series = sr.findAll();

		for (Serie s : series ) {
			u1.get().agregarSerie(s);
			u2.get().agregarSerie(s);
		}
		ur.save(u1.get());
		ur.save(u2.get());
	}
}
