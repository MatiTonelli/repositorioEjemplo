public class Agenda {
	
	private int proximoLugarLibre = 0;
	private Contacto[] lugares;

	public Agenda(int largo) {
		 lugares = new Contacto[largo];
		
	}
	
	
	public void ingresarNuevoContacto(String nombreUno, String apellido) {
		if(proximoLugarLibre == lugares.length) 
			throw new Error("LA AGENDA ESTA LLENA!!");

		lugares[proximoLugarLibre] = new Contacto(nombreUno, apellido);
		proximoLugarLibre++;
		}
	
	public void ingresarNuevoContactoConSegundoNombre(String nombreUno, String nombreDos, String apellido) {
		if(proximoLugarLibre == lugares.length) 
			throw new Error("LA AGENDA ESTA LLENA!!");

		lugares[proximoLugarLibre] = new Contacto(nombreUno, nombreDos, apellido);
		proximoLugarLibre++;
	}
	public void borrarUnContactoPorIndice(int indice) {
		lugares[indice - 1] = null;
	}
	public void editarContacto(int indice, String nombre, String apellido) {
		if(lugares[indice - 1] != null) {
			lugares[indice - 1].setPrimerNombre(nombre);
			lugares[indice - 1].setApellido(apellido);
		}else {
			throw new Error("No existe tal contacto con ese numero de indice");
		}
	}
	public void editarSegundoNombre(int indice, String segundoNombre) {
		if(lugares[indice - 1] != null) {
			lugares[indice - 1].setSegundoNombre(segundoNombre);
		}else {
			throw new Error("No existe tal contacto con ese numero de indice");
		}
	}
	public String mostrarDatosDelContacto(int indice) {
		if(lugares[indice - 1] == null) 
			throw new Error("No existe tal contacto con ese numero de indice");
		
		return lugares[indice - 1].toString();
	}
	public Contacto getContacto(int indice) {
		return lugares[indice - 1];
	}
	
	
	
}
