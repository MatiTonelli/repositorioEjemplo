package Agenda;

import java.util.Arrays;

public class Agenda {

	// Atributos
	private int indice = 0;
	private int tope = 200;
	private Contacto[] indiceDeContactos;

	// Construtor
	/**
	 * post:crea una agenda para 200 contactos.
	 */
	public Agenda() {
		this.indiceDeContactos = new Contacto[200];
	}

	// M�todos
	
	/*
	 * pre :La agenda debe tener lugar disponible.
	 * post:crea un nuevo contacto con los par�metros tipo String nombre y
	 * apellido.Indica un n�mero de �ndice por orden de creaci�n.
	 */
	public void ingresarNuevoContacto(String nombre, String apellido) {
		if (nombre == null || apellido == null) {
			throw new Error("Debes ingresar un nombre y un apellido");
		}
		if (this.indice == this.tope) {
			throw new Error("La agenda esta llena");
		}

		indiceDeContactos[this.indice] = new Contacto(this.indice+1, nombre, apellido);

		this.indice++;
	}

	/*
	 * pre :La agenda debe tener lugar disponible.
	 * post:crea un nuevo contacto con los par�metros tipo String nombre, segundo
	 *      nombre y apellido.Indica un n�mero de �ndice por orden de creaci�n.
	 */
	public void ingresarNuevoContacto(String nombre, String segundoNombre, String apellido) {
		if (nombre == null || apellido == null) {
			throw new Error("Debes ingresar un nombre y un apellido");
		}
		if (this.indice == this.tope) {
			throw new Error("La agenda esta llena");
		}

		indiceDeContactos[this.indice] = new Contacto(this.indice+1, nombre, segundoNombre, apellido);

		this.indice++;
	}

	/**
	 * pre :debe haber un contacto creado.
	 * post:agrega o edita un telefono al contacto especificado por el parametro n�meroIndice
	 *      El param. tipo indica si es personal, trabajo, casa u otroTipo
	 *       y el param. n�mero el tel�fono.
	 * @param numeroDeIndice
	 * @param tipo
	 * @param numero
	 */
	public void editarTelefonoDeContacto(int numeroDeIndice, String tipo, int numero) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		this.indiceDeContactos[numeroDeIndice - 1].agregarTelefono(tipo, numero);
	}

	/**
	 * pre :debe haber un contacto creado.
	 * post:agrega o edita un correo electr�nico al contacto especificado por el 
	 *      parametro n�meroIndice.
	 *      El param. tipo indica personal o laboral y el param. correo el mail.
	 * @param numeroDeIndice
	 * @param tipo
	 * @param correo
	 */
	public void editarCorreoDeContacto(int numeroDeIndice, String tipo, String correo) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		this.indiceDeContactos[numeroDeIndice - 1].agregarCorreoElectronico(tipo, correo);
	}

	/**
	 * pre :debe haber un contacto creado.
	 * post:agrega o edita un dato del Domicilio al contacto especificado por el 
	 *      parametro n�meroIndice.
	 * @param numeroDeIndice
	 * @param calle
	 * @param numero
	 * @param localidad
	 * @param provincia
	 * @param pais
	 */
	public void editarDomicilioDeContacto(int numeroDeIndice, String calle, 
			int numero, String localidad,String provincia, String pais) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		this.indiceDeContactos[numeroDeIndice - 1].
		agregarDatosDeDomicilio(calle, numero, localidad, provincia, pais);
	}
	
	/**
	 * pre :debe haber un contacto creado.
	 * post:agrega o edita un dato espec�fico del Domicilio al 
	 *      contacto especificado por el parametro n�meroIndice.
	 * @param numeroDeIndice
	 * @param tipo
	 * @param dato
	 */
	public void editarDatoEspecificoDeDomicilio(int numeroDeIndice, 
			String tipo, String dato) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		this.indiceDeContactos[numeroDeIndice - 1].
		editarDatoDeDomicilio(tipo, dato);
	}
	
	/**
	 * pre :debe haber un contacto creado.
	 * post:agrega o edita un dato num�rico del Domicilio al 
	 *      contacto especificado por el parametro n�meroIndice.
	 * @param numeroDeIndice
	 * @param tipo
	 * @param numero
	 */
	public void editarDatoNumericoDeDomicilio(int numeroDeIndice, 
			String tipo, int numero) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		this.indiceDeContactos[numeroDeIndice - 1].
		editarDatoNumericoDeDomicilio(tipo, numero);
	}
	
	/**
	 * pre :debe haber un contacto creado.El n�mero de indice debe ser 
	 *      igual o menor al n�mero de contactos creados.
	 * post:cambia el nombre y apellido de un contacto especificado 
	 *      por el par�m. numeroDeIndice.
	 * @param numeroDeIndice
	 * @param nuevoNombre
	 * @param nuevoApellido
	 */
	public void editarNombreYApellidoDelContacto(int numeroDeIndice,
			String nuevoNombre, String nuevoApellido) {
		verificarNumeroDeIndice(numeroDeIndice);
		
		indiceDeContactos[numeroDeIndice-1].
		editarNombreYApellido(nuevoNombre, nuevoApellido);
	}

	/**
	 * * post:muestra un indice de los contactos por orden de creaci�n.
	 * @return
	 */
	public String mostrarIndice() {

		int i = 0;
		String mostrar = "Indice: ";
        while(i < this.indice){
        mostrar = mostrar+" "+indiceDeContactos[i].mostrarDatosDeContacto()+" ";
        i++;
        }
        return mostrar;
  
	}

	/**
	 * pre :debe haber un contacto creado.El n�mero de indice debe ser 
	 *      igual o menor al n�mero de contactos creados.
	 * post:retorna los datos del contacto especificado por el n�meroDeIndice.
	 * @param numeroDeIndice
	 * @return
	 */
	public String mostrarDatosDeContacto(int numeroDeIndice) {
		verificarNumeroDeIndice(numeroDeIndice);

		return indiceDeContactos[numeroDeIndice - 1].mostrarDatosCompletosDeContacto();
	}
	
	/**
	 * pre :debe haber un contacto creado.El n�mero de indice debe ser 
	 *      igual o menor al n�mero de contactos creados.
	 * post:elimina el contacto especificado por param.     
	 * @param numeroDeIndice
	 */
	public void borrarContacto(int numeroDeIndice) {
		verificarNumeroDeIndice(numeroDeIndice);
		this.indiceDeContactos[numeroDeIndice-1].vaciarDatosDeContacto();
	}
	
	/**
	 * post: valida los parametros ingresados
	 * @param numeroDeIndice
	 */
	private void verificarNumeroDeIndice(int numeroDeIndice) {
		if (numeroDeIndice<1 || numeroDeIndice>this.indice) {
			throw new Error("Debes introducir un �ndice v�lido");
		}
		if (this.indice == 1) {
			throw new Error("A�n no se ha creado ning�n contacto");
		}
		this.tope++;
	}
	
	

	@Override
	public String toString() {
		return "Agenda [indice=" + indice + ", tope=" + tope + ", indiceDeContactos="
				+ Arrays.toString(indiceDeContactos) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + indice;
		result = prime * result + Arrays.hashCode(indiceDeContactos);
		result = prime * result + tope;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (indice != other.indice)
			return false;
		if (!Arrays.equals(indiceDeContactos, other.indiceDeContactos))
			return false;
		if (tope != other.tope)
			return false;
		return true;
	}

}
