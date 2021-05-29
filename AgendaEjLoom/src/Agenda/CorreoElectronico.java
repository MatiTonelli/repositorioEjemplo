package Agenda;

public class CorreoElectronico {
	//Atributos
	
	private String correoPersonal = "Correo personal";
	private String correoLaboral = "Correo laboral";
	
	//Constructor
	
	CorreoElectronico() {
		
	}
	
	CorreoElectronico(String tipo, String correo) {
		verificarParametros(tipo);
		
		if (tipo == "personal") {
			this.correoPersonal = "Correo Personal: "+correo;
		}else if(tipo == "laboral") {
			this.correoLaboral = "Correo Laboral: "+correo;
		}
	}
	
	//Métodos
	
	/**
	 * post:agrega el correo personal.
	 * @param correo
	 */
	public void agregarCorreoPersonal(String correo) {
		this.correoPersonal = "Correo Personal: "+correo;
	}
	
	/**
	 * post:agrega el correo laboral.
	 * @param correo
	 */
	public void agregarCorreoLaboral(String correo) {
		this.correoLaboral = "Correo Laboral: "+correo;
	}
	
	/**
	 * pre :se debe ingresar el tipo de correo 'personal' o 'laboral' y luego el nuevo correo.
	 * post:agrega o midifica el correo especificado por param.
	 * @param tipo
	 * @param nuevoCorreo
	 */
	public void modificarCorreo(String tipo, String nuevoCorreo) {
		verificarParametros(tipo);
		
		if (tipo == "personal") {
			this.correoPersonal = "Correo Personal: "+nuevoCorreo;
		}else if(tipo == "laboral") {
			this.correoLaboral = "Correo Laboral: "+nuevoCorreo;
		}

	}
	
	/**
	 * muestra en pantalla los datos de CorreoElectronico.
	 * @return
	 */
	public String mostrarCorreos() {
		return correoPersonal+" "+correoLaboral;
	}
	
	/**
	 * post:elimina los datos de CorreoElectronico.
	 */
	public void borrarCorreo() {
		this.correoLaboral ="";
		this.correoPersonal ="";
	}

	/**
	 * post: valida si son correctos los param ingresados.
	 * @param tipo
	 */
	private void verificarParametros(String tipo) {
		boolean parametroCorrecto = true;
		if (tipo == "personal" || tipo == "laboral") {
			parametroCorrecto = false;
		}
		if (parametroCorrecto) {
			throw new Error("Debes introducir el tipo de correo: personal o laboral"
					+ ",luego el correo");
		}	
	}
	
	@Override
	public String toString() {
		return "CorreoElectronico [correoPersonal=" + correoPersonal + ", correoLaboral=" + correoLaboral + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correoLaboral == null) ? 0 : correoLaboral.hashCode());
		result = prime * result + ((correoPersonal == null) ? 0 : correoPersonal.hashCode());
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
		CorreoElectronico other = (CorreoElectronico) obj;
		if (correoLaboral == null) {
			if (other.correoLaboral != null)
				return false;
		} else if (!correoLaboral.equals(other.correoLaboral))
			return false;
		if (correoPersonal == null) {
			if (other.correoPersonal != null)
				return false;
		} else if (!correoPersonal.equals(other.correoPersonal))
			return false;
		return true;
	}

}
