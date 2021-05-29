package Agenda;

import org.junit.Assert;

import org.junit.Test;

public class TelefonoTest {
	Telefono telefono = new Telefono();
	
	@Test
	public void modificarTelefonosTest() {
		telefono.agregarCelular(1188888888);
		telefono.modificarTelefono("celular", 1178787878);
		telefono.agregarTelCasa(9999999);
		telefono.modificarTelefono("casa", 5555555);
		telefono.agregarTelTrabajo(7777777);
		telefono.modificarTelefono("trabajo", 7878787);
		telefono.agregarTelOtroTipo(6666666);
		telefono.modificarTelefono("otroTipo", 3233232);
		
		String esperado = "Celular 1178787878 Casa 5555555 "
				+ "Trabajo 7878787 OtroTipo 3233232";
		String obtenido = telefono.mostrarTelefonos();
		
		Assert.assertEquals(esperado,obtenido);
	}
	
	@Test 
	public void mostrarDatosDeTelefonosTest() {
		telefono.agregarCelular(1178787878);
		telefono.agregarTelCasa(8888888);
		telefono.agregarTelTrabajo(7777777);
		
		String esperado = "Celular: 1178787878 Casa: 8888888 "
				+ "Trabajo: 7777777 Otro Tipo";
		String obtenido = telefono.mostrarTelefonos();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	@Test
	public void borrarTelefonosTest() {
		telefono.agregarCelular(1178787878);
		telefono.agregarTelCasa(8888888);
		telefono.agregarTelTrabajo(7777777);
		
		telefono.borrarTelefono();
		
		String esperado = "   ";
		String obtenido = telefono.mostrarTelefonos();
		
		Assert.assertEquals(esperado, obtenido);
	}
	
	

}
