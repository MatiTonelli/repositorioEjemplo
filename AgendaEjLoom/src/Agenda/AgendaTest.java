package Agenda;

import org.junit.Assert;

import org.junit.Test;

public class AgendaTest {
	
	public Agenda agenda = new Agenda();

	@Test
	public void mostrarIndiceTest() {
		agenda.ingresarNuevoContacto("Ciro", "Pertusi");
		agenda.ingresarNuevoContacto("Mariano", "Martinez");
		agenda.ingresarNuevoContacto("Gisela", "Dulco");
		agenda.ingresarNuevoContacto("Cristian", "Daniel", "Marrone");
		agenda.ingresarNuevoContacto("Gabriel", "Roman");
		
		String esperado = " Indice:  1 Ciro  Pertusi  2 Mariano  Martinez  3 Gisela  Dulco  "
				+ "4 Cristian Daniel Marrone  5 Gabriel  Roman ";
		String obtenido = " "+agenda.mostrarIndice();
		
		Assert.assertEquals(esperado, obtenido);
		
	}
	
	@Test
	public void mostrarDatosDeContactoTest() {
		agenda.ingresarNuevoContacto("Ciro", "Pertusi");
		agenda.ingresarNuevoContacto("Mariano", "Martinez");
		agenda.ingresarNuevoContacto("Gisela", "Dulco");
		agenda.editarTelefonoDeContacto(2, "celular", 1169696969);
		agenda.editarTelefonoDeContacto(1, "celular", 1163636363);
		agenda.editarCorreoDeContacto(2, "personal", "ayp2@gmail.com");
		agenda.editarCorreoDeContacto(3, "laboral", "ayp1@gmail.com");
		agenda.editarTelefonoDeContacto(3, "celular", 1152515251);
		agenda.editarCorreoDeContacto(2, "personal", "ayp2@gmail.com");
		agenda.editarDomicilioDeContacto(1, "Carranza", 4545, "Caseros", "Bs As", "Argentina");
		agenda.editarDomicilioDeContacto(2, "Maldonado", 7878, "V. Luzuriaga", "Bs As", "Argentina");
		agenda.editarDomicilioDeContacto(3, "Anarcos", 1977, "Villa Bosch", "Bs As", "Argentina");
		
		String esperado = "3 Gisela  Dulco Celular: 1152515251 Casa Trabajo Otro Tipo "
				+ "Correo personal Correo Laboral: ayp1@gmail.com Calle: Anarcos Nro: 1977 "
				+ "Piso Depto Localidad: Villa Bosch Partido Provincia: Bs As Pais: Argentina";
		String obtenido = agenda.mostrarDatosDeContacto(3);
		
		Assert.assertEquals(esperado,obtenido);
	}
	
	@Test
	public void borrarUnContactoTest() {
		agenda.ingresarNuevoContacto("Ciro", "Pertusi");
		agenda.ingresarNuevoContacto("Mariano", "Martinez");
		agenda.ingresarNuevoContacto("Gisela", "Dulco");
		
		agenda.borrarContacto(2);
		
		String esperado = "Indice:  1 Ciro  Pertusi  2     3 Gisela  Dulco ";
		String obtenido = agenda.mostrarIndice();
		
		Assert.assertEquals(esperado,obtenido);
	}

}
