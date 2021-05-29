package Agenda;

import org.junit.Assert;

import org.junit.Test;

public class CorreoElectronicoTest {
	
	CorreoElectronico correo;

	@Test
	public void modificarCorreoPersonal() {
		correo = new CorreoElectronico();
		correo.agregarCorreoPersonal("aypdos@outlook.com");
		correo.modificarCorreo("personal", "aypuno@outlook.com");
		
		String esperado = "Correo Personal: aypuno@outlook.com Correo laboral";
		String obtenido = correo.mostrarCorreos();
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void modificarCorreoLaboral() {
		correo = new CorreoElectronico();
		correo.agregarCorreoLaboral("aypdos@outlook.com");
		correo.modificarCorreo("laboral", "aypuno@outlook.com");
		
		String esperado = "Correo personal Correo Laboral: aypuno@outlook.com";
		String obtenido = correo.mostrarCorreos();
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void constructorConMailPersonalTest() {
		correo = new CorreoElectronico("personal","aypdos@outlook.com");
		
		String esperado = "Correo Personal: aypdos@outlook.com Correo laboral";
		String obtenido = correo.mostrarCorreos();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void borrarCorreosTest() {
		correo = new CorreoElectronico();
		correo.agregarCorreoLaboral("aypdos@outlook.com");
		correo.borrarCorreo();
		
		String esperado = " ";
		String obtenido = correo.mostrarCorreos();
		
		Assert.assertEquals(esperado, obtenido);
	}

}
