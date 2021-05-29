package Agenda;

import org.junit.Assert;

import org.junit.Test;

public class ContactoTest {
	
	private Contacto contacto;

	@Test
	public void mostrarDatosDeContactoTest() {
		contacto = new Contacto(1,"Cristian","Marrone");
		contacto.agregarTelefono("celular", 116566666);
		contacto.agregarCorreoElectronico("personal", "ayp2@gmail.com");
		contacto.agregarDatosDeDomicilio("camino", 123, "caseros", "Bs As", "Argentina");
		
		String esperado ="1 Cristian  Marrone Celular: 116566666 Casa Trabajo Otro Tipo "
				+ "Correo Personal: ayp2@gmail.com Correo laboral Calle: camino "
				+ "Nro: 123 Piso Depto Localidad: caseros Partido Provincia: Bs As Pais: Argentina";
		String obtenido = contacto.mostrarDatosCompletosDeContacto();
		Assert.assertEquals(esperado, obtenido);		
		
	}

	@Test
	public void borrarDatosDelContactoTest() {
		contacto = new Contacto(1,"Cristian","Marrone");
		contacto.agregarTelefono("celular", 116566666);
		contacto.vaciarDatosDeContacto();
		
		String esperado ="1                 ";
		String obtenido = contacto.mostrarDatosCompletosDeContacto();
		
		Assert.assertEquals(esperado, obtenido);
	}
}
