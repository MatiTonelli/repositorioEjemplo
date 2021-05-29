package Agenda;

public class Telefono {

	private String celular = "Celular";
	private String trabajo = "Trabajo";
	private String casa = "Casa";
	private String otroTipo = "Otro Tipo";
	
	public Telefono() {
		
	}
	
	/*
	 * pre :se debe introducir un parametro válido para tipo de teléfono:
	 *      "celular", "trabajo", "casa", "otroTipo".
	 * post:crea un telefono con el numero dado en el param. int número.     
	 */
	public Telefono(String tipo, int numero) {
		verificarParametros(tipo, numero);
		if (tipo == "celular") {
			this.celular = "Celular: " + numero;
		} else if (tipo == "trabajo") {
			this.trabajo = "Trabajo: " + numero;
		} else if (tipo == "casa") {
			this.casa = "Casa: " + numero;
		} else if (tipo == "otroTipo") {
			this.otroTipo = "OtroTipo: " + numero;
		}
	}

	/*
	 * post:agrega o edita un telefono del tipo celular dado por el param. int
	 */
	public Telefono agregarCelular(int celular) {
		this.celular = "Celular: " + celular;
		return new Telefono();
	}

	/*
	 * post:agrega o edita un telefono del tipo trabajo dado por el param. int
	 */
	public Telefono agregarTelTrabajo(int trabajo) {
		this.trabajo = "Trabajo: " + trabajo;
		return new Telefono();
	}

	/*
	 * post:agrega o edita un telefono del tipo casa dado por el param. int
	 */
	public Telefono agregarTelCasa(int casa) {
		this.casa = "Casa: " + casa;
		return new Telefono();
	}

	/*
	 * post:agrega o edita un telefono del tipo otroTipo dado por el param. int
	 */
	public Telefono agregarTelOtroTipo(int otroTipo) {
		this.otroTipo = "Otro tipo: " + otroTipo;
		return new Telefono();
	}

	/*
	 * post:muestra los datos ingresados a todos los tipos de telefono.
	 */
	public String mostrarTelefonos() {

		return celular + " " + casa + " " + trabajo + " " + otroTipo;
	}


	/*
	 * pre :se debe introducir un parametro válido para tipo de teléfono:
	 *      "celular", "trabajo", "casa", "otroTipo".
	 * post:modifica los datos telefono con el numero dado en el param. int número.     
	 */
	public void modificarTelefono(String tipo, int nuevoNumero) {
		verificarParametros(tipo, nuevoNumero);
		if (tipo == "celular") {
			this.celular = "Celular " + nuevoNumero;
		} else if (tipo == "trabajo") {
			this.trabajo = "Trabajo " + nuevoNumero;
		} else if (tipo == "casa") {
			this.casa = "Casa " + nuevoNumero;
		} else if (tipo == "otroTipo") {
			this.otroTipo = "OtroTipo " + nuevoNumero;
		}

	}
	
	/**
	 * post:elimina los datos guardados en Telefono
	 */
	public void borrarTelefono() {
		this.casa = "";
		this.celular = "";
		this.otroTipo = "";
		this.trabajo = "";
	}

	/**
	 * post: verifica si los parametros ingresados son correctos para un tipo
	 *       de teléfono.
	 * @param tipo
	 * @param nuevoNumero
	 */
	private void verificarParametros(String tipo, int nuevoNumero) {
		boolean tipoCorrecto = true;
		if (tipo == "celular" || tipo == "trabajo" || tipo == "casa" || tipo == "otroTipo") {
			tipoCorrecto = false;
		}
		if (tipoCorrecto) {
			throw new Error(
					"Debes agregar un tipo entre: casa celular trabajo otrotipo. " + " Agrega un numero telefonico");
		}

	}
	
	
	@Override
	public String toString() {
		return "Telefono [celular=" + celular + ", trabajo=" + trabajo + ", casa=" + casa + ", otroTipo=" + otroTipo
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casa == null) ? 0 : casa.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((otroTipo == null) ? 0 : otroTipo.hashCode());
		result = prime * result + ((trabajo == null) ? 0 : trabajo.hashCode());
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
		Telefono other = (Telefono) obj;
		if (casa == null) {
			if (other.casa != null)
				return false;
		} else if (!casa.equals(other.casa))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (otroTipo == null) {
			if (other.otroTipo != null)
				return false;
		} else if (!otroTipo.equals(other.otroTipo))
			return false;
		if (trabajo == null) {
			if (other.trabajo != null)
				return false;
		} else if (!trabajo.equals(other.trabajo))
			return false;
		return true;
	}
}
