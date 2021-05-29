package Agenda;

public class Domicilio {
	
	//Atributos
	
	private String calle = "Calle";
	private String nro = "Nro";
	private String piso = "Piso";
	private String depto = "Depto";
	private String localidad = "Localidad";
	private String partido = "Partido";
	private String provincia = "Provincia";
	private String pais = "Pais";
	

	//Métodos
	
	/**
	 * pre : requiere ingresar los datos obligatorios de un 
	 *       Domicilio en cada parametro en el orden calle número 
	 *       localidad provincia y país.
	 * post: guarda los datos obligatorios del domicilio
	 * @param calle
	 * @param numero
	 * @param localidad
	 * @param provincia
	 * @param pais
	 */
	public void datosObligatoriosDeDomicilio(String calle, int numero, String localidad, 
			String provincia, String pais) {
		verificarParametros(calle,numero,localidad,provincia,pais);
		
		this.calle = "Calle: "+calle;
		this.nro = "Nro: "+numero;
		this.localidad = "Localidad: "+localidad;
		this.provincia = "Provincia: "+provincia;
		this.pais = "Pais: "+pais;
	}
	
	/**
	 * pre :requiere introducir un dato especifico de Domicilio entre
	 *      calle depto localidad partido provincia pais.
	 * post:edita o agrega el dato dado por el param dato
	 * @param tipo
	 * @param dato
	 */
	public void editarDatoDomicilio(String tipo, String dato) {
		
		verificarValorAEditar(tipo, dato);
	}
	
	/**
	 * pre : elegir entre 'calle' o 'piso' y agregar el número.
	 * post: edita o crea el número de calle o el número de piso
	 * @param tipo
	 * @param numero
	 */
	public void editarNumeroDeCalleOPiso(String tipo, int numero) {
		if (tipo == "calle") {
			this.nro = "Nro "+numero;
		}else if (tipo == "piso") {
			this.piso = "Piso: "+numero;
		}else {
			throw new Error("Debes ingresar o calle o piso y luego el número");
		}
	}
	
	/**
	 * post: mostrar datos del Domicilio.
	 * @return
	 */
	public String mostrarDatosDeDomicilio() {
		
		return calle+" "+nro+" "+piso+" "+depto+" "+localidad+" "+partido+" "+provincia+" "+pais;
	}


	/**
	 * post: elimina los datos de Domicilio.
	 */
	public void borrarDomicilio() {
		this.calle = "";
		this.nro = "";
		this.piso = "";
		this.depto = "";
		this.localidad = "";
		this.partido = "";
		this.provincia = "";
		this.pais = "";
	}
	
	private void verificarParametros(String calle, int numero, String localidad, 
			String provincia, String pais) {
		boolean parametroCorrecto = false;
		if (calle == null || numero < 1 || localidad == null || 
				provincia == null || pais == null) {
			parametroCorrecto = true;
		}
		if (parametroCorrecto) {
			throw new Error("Debes ingresar datos para: calle, número, piso(opcional), depto(opcional), "
					+ "localidad, partido (opcional), provincia, pais");
		}
		
	}
	
	private void verificarValorAEditar(String tipo, String dato) {
		if (tipo == "calle") {
			this.calle = "Calle: "+dato;
		}else if (tipo == "depto") {
			this.depto = "Depto: "+dato;
		}else if (tipo == "localidad") {
			this.localidad = "Localidad: "+dato;
		}else if (tipo == "partido") {
			this.partido = "Partido: "+dato;
		}else if (tipo == "provincia") {
			this.provincia = "Provincia: "+dato;
		}else if (tipo == "pais") {
			this.pais = "País: "+dato;
		}else {
			throw new Error("debes ingresar un tipo válido "
					+ "entre: calle depto localidad partido provincia pais");
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((depto == null) ? 0 : depto.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nro == null) ? 0 : nro.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
		result = prime * result + ((piso == null) ? 0 : piso.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		Domicilio other = (Domicilio) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (depto == null) {
			if (other.depto != null)
				return false;
		} else if (!depto.equals(other.depto))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nro == null) {
			if (other.nro != null)
				return false;
		} else if (!nro.equals(other.nro))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		if (piso == null) {
			if (other.piso != null)
				return false;
		} else if (!piso.equals(other.piso))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", nro=" + nro + ", piso=" + piso + ", depto=" + depto + ", localidad="
				+ localidad + ", partido=" + partido + ", provincia=" + provincia + ", pais=" + pais + "]";
	}
	
	

}
