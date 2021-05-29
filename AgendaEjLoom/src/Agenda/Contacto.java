package Agenda;

public class Contacto {
	
	private int indice;
	private String nombre;
	private String segundoNombre;
	private String apellidos;
	private Telefono telefono;
	private CorreoElectronico correo;
	private Domicilio domicilio;
	
	/**
	 * post:crea un Contacto con un nombre y apellido dados por parámetros.
	 * @param numero establece el número de ubicación en el índice de una agenda.
	 * @param nombre
	 * @param apellido
	 */
	public Contacto(int numero, String nombre, String apellido) {
		this.nombre = nombre;
		this.segundoNombre ="";
		this.apellidos = apellido;
		this.indice = numero;
		this.telefono = new Telefono();
		this.correo = new CorreoElectronico();
		this.domicilio = new Domicilio();
		
	}
	
	/**
	 * post:crea un Contacto con primer, segundo nombre y apellido, dado por parametro.
	 * @param numero establece el numero de ubicación en el índice de una agenda.
	 * @param nombre
	 * @param segundoNombre
	 * @param apellido
	 */
	public Contacto(int numero, String nombre, String segundoNombre,
			String apellido) {
		this.nombre = nombre;
		this.segundoNombre = segundoNombre;
		this.apellidos = apellido;
		this.indice = numero;
		this.telefono = new Telefono();
		this.correo = new CorreoElectronico();
		this.domicilio = new Domicilio();
	}
	
	/**
	 * post:agrega un Telefono al contacto del tipo especificado por parámetro:
	 *      "celular" "trabajo" "casa" "otroTipo".
	 * @param tipo
	 * @param numero
	 */
	public void agregarTelefono(String tipo, int numero) {
		
		verificarTipoDeTelefono(tipo, numero);	
	}
	
	/**
	 * pre : se debe ingresar el tipo de correo: "personal" o "laboral".
	 * post: crea un correo al Contacto del tipo dado en el param.
	 * @param tipo
	 * @param correo
	 */
	public void agregarCorreoElectronico(String tipo, String correo) {
		
		if (tipo == "personal") {
			this.correo.agregarCorreoPersonal(correo);
		}else if(tipo == "laboral") {
			this.correo.agregarCorreoLaboral(correo);
		}else {
			throw new Error("Debes ingresar el tipo de correo: "
					+ "personal o laboral y luego el correo");
		}
	}
	
	/**
	 * pre : se deben ingresar los datos obligatorios para un Domicilio:
	 *      'calle' 'numero' 'localidad' 'provincia' y 'pais'.
	 * post: crea un Domicilio con los datos especificados por param.
	 * @param calle
	 * @param numero
	 * @param localidad
	 * @param provincia
	 * @param pais
	 */
	public void agregarDatosDeDomicilio(String calle, int numero, String localidad, 
			String provincia, String pais) {
		verificarParametrosDomicilio(calle,numero,localidad,provincia,pais);
	
		this.domicilio.datosObligatoriosDeDomicilio(calle, numero, localidad, provincia, pais);
	}
	
	/**
	 * pre :requiere introducir un dato especifico de Domicilio entre
	 *      calle depto localidad partido provincia pais.
	 * post:edita o agrega el dato dado por el param dato
	 * @param tipo
	 * @param dato
	 */
	public void editarDatoDeDomicilio(String tipo, String dato) {
		this.domicilio.editarDatoDomicilio(tipo, dato);
	}
	
	/**
	 * pre : elegir entre 'calle' o 'piso' y agregar el número.
	 * post: edita o crea el número de calle o el número de piso
	 * @param tipo
	 * @param numero
	 */
	public void editarDatoNumericoDeDomicilio(String tipo, int numero) {
		this.domicilio.editarNumeroDeCalleOPiso(tipo, numero);
	}
	/**
	 * post: muestra los datos básicos que posee el Contacto 
	 *       dados por el constructor.
	 * @return
	 */
	public String mostrarDatosDeContacto() {
		return indice+" "+nombre+" "+segundoNombre+" "+apellidos;
	}
	
	/**
	 * post: muestra todos los datos que posee el Contacto.
	 * @return
	 */
	public String mostrarDatosCompletosDeContacto() {
		return indice+" "+nombre+" "+segundoNombre+" "+apellidos+" "
	+telefono.mostrarTelefonos()+" "+correo.mostrarCorreos()+" "
				+domicilio.mostrarDatosDeDomicilio();
	}
	
	/**
	 * post: edita solo el nombre y el apellido del Contacto.
	 * @param nuevoNombre
	 * @param nuevoApellido
	 */
	public void editarNombreYApellido(String nuevoNombre, 
			String nuevoApellido) {
		this.nombre = nuevoNombre;
		this.apellidos = nuevoApellido;
	}
	
	/**
	 * post: edita solo el nombre y el apellido del Contacto.
	 * @param nuevoNombre
	 * @param nuevoApellido
	 */
	public void editarNombreSegundoNombreYApellido(String nuevoNombre, 
			String nuevoSegundoNombre, String nuevoApellido) {
		this.nombre = nuevoNombre;
		this.segundoNombre = nuevoSegundoNombre;
		this.apellidos = nuevoApellido;
	}
	
	public void vaciarDatosDeContacto() {
		this.nombre = "";
		this.segundoNombre = "";
		this.apellidos = "";
	    this.telefono.borrarTelefono();
	    this.correo.borrarCorreo();
	    this.domicilio.borrarDomicilio();
		
	}

	/**
	 * post: verifica que los datos del tipo de domicilio son los permitidos.
	 * @param calle
	 * @param numero
	 * @param localidad
	 * @param provincia
	 * @param pais
	 */
	private void verificarParametrosDomicilio(String calle, int numero, String localidad, 
			String provincia, String pais) {
		boolean parametroCorrecto = false;
		if (calle == null || numero < 1 || localidad == null || 
				provincia == null  || pais == null) {
			parametroCorrecto = true;
		}
		if (parametroCorrecto) {
			throw new Error("Debes ingresar datos para: calle, número, piso(opcional), depto(opcional), "
					+ "localidad, partido (opcional), provincia, pais");
		}
	}
	
	/**
	 * post: verifica que el telefono sea del tipo 
	 *       permitido y guarda los datos del número.
	 * @param tipo
	 * @param numero
	 */
	private void verificarTipoDeTelefono(String tipo, int numero) {
		if (tipo == "celular") {
			this.telefono.agregarCelular(numero);
		}else if(tipo == "trabajo") {
			this.telefono.agregarTelTrabajo(numero);
		}else if(tipo == "casa") {
			this.telefono.agregarTelCasa(numero);
		}else if(tipo == "otroTipo") {
			this.telefono.agregarTelOtroTipo(numero);
		}else {
			throw new Error("Debes ingresar el tipo de telefono: "
					+ "celular, trabajo, casa, otroTipo y luego el número");
		}
	}

	@Override
	public String toString() {
		return "Contacto [indice=" + indice + ", nombre=" + nombre + ", segundoNombre=" + segundoNombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", correo=" + correo + ", domicilio=" + domicilio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + indice;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((segundoNombre == null) ? 0 : segundoNombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Contacto other = (Contacto) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (indice != other.indice)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (segundoNombre == null) {
			if (other.segundoNombre != null)
				return false;
		} else if (!segundoNombre.equals(other.segundoNombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	

}
