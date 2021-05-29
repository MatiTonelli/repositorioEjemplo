package Agenda;

import org.junit.Assert;

import org.junit.Test;

public class DomicilioTest {
	
	Domicilio domicilio = new Domicilio();

	@Test
	public void mostrarDatosDeDomicilioTest() {
		domicilio.datosObligatoriosDeDomicilio
		("camino",4444,"caseros","buenos aires","argentina");
		
		String esperado = "Calle: camino Nro: 4444 Piso Depto Localidad: "
				+ "caseros Partido Provincia: buenos aires Pais: argentina";
		String obtenido = domicilio.mostrarDatosDeDomicilio();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test(expected = Error.class)
	public void cargarMalUnParametroErrorTest() {
		domicilio.datosObligatoriosDeDomicilio
		("camino",4444,"caseros","buenos aires","argentina");
		domicilio.editarDatoDomicilio("Calle", "carranza");
	}
	
	@Test
	public void editarDatoTest() {
		domicilio.datosObligatoriosDeDomicilio
		("camino",4444,"caseros","buenos aires","argentina");
		domicilio.editarDatoDomicilio("calle", "Ruplentinski");
		
		String esperado = "Calle: Ruplentinski Nro: 4444 Piso "
				+ "Depto Localidad: caseros Partido Provincia: "
				+ "buenos aires Pais: argentina";
		String obtenido = domicilio.mostrarDatosDeDomicilio();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	

}
