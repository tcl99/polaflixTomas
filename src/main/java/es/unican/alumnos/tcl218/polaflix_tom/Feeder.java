package es.unican.alumnos.tcl218.polaflix_tom;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Cobros.Factura;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Usuario.Usuario;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.InformacionSerie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Serie;
import es.unican.alumnos.tcl218.polaflix_tom.DomainModel.Visualizacion.Temporada;
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
		feedFactura();
		feedSerie();
		feedUsuario();
		
		test();
		
		System.out.println("Application feeded");
	}

	private void feedFactura() {
        Date d = new Date(0);
		Factura f1 = new Factura(d,10);
		fr.save(f1);
	}
	
	private void feedSerie() {
		Serie c = new Serie(null, new InformacionSerie("kk", null, null, null, null, null) ,"Gold");
		sr.save(c);
	}

	private void feedUsuario() {
        Usuario u = new Usuario("socio", "kk", null, null);
        ur.save(u);
	}
	
	private void test() {
		/* 
		SimpleDateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy");
		Date sample = null;
		try {
			sample = dateParser.parse("01-01-2020");
		} catch (ParseException e) {
			System.out.println("Crujo parseando fecha");
			e.printStackTrace();
		}
		
		// Set<Viaje> viajes = vr.findByOrigenCiudadAndDestinoCiudad("Santander","Cadiz");
		Set<Viaje> viajes = vr.findByOrigenAndDestino("Santander","Cadiz");
		
		System.out.println("Viajes recuperados = " + viajes.size());
	
		for(Viaje v : viajes) {
			System.out.println("Viaje in " + v.getFecha());
		}
		
		viajes = vr.findByOrigen_CiudadAndFechaBeforeOrderByPrecio("Santander", sample);

		System.out.println("================================");
		
		System.out.println("Viajes recuperados = " + viajes.size());
        */
		
		
//		Usuario paco = ur.findByEmail("paco@carSharing.es"); 
//		
//		System.out.println("Paco = " + paco.getNombre() + ":" + paco.getEmail());
//		
//		Set<Usuario> usuarios = ur.findByFechaAltaAfter(sample);
//		for(Usuario u : usuarios) {
//			System.out.println("Usuario " + u.getNombre() + ":" + u.getEmail());
//		}
		
	}
}
