
public class Contacto {
	private String primerNombre;
	private String segundoNombre = "";
	private String apellido;
	private String[] telefono;
	private String[] mail;	
	private String[] domicilio;
	private String cumpleanios = "No especifica";
	private String empresa = "No especifica";
	
	public Contacto(String nombreUno, String nombreDos, String apellido) {
		setPrimerNombre(nombreUno);
		setSegundoNombre(nombreDos);
		setApellido(apellido);
		setTelefono("", "No especifica");
		setMail("", "No especifica");
		domicilio = new String[8];
		setDomicilio("No especifica", "", "", "", "");
		setPartido("");
		setDepto("");
		setPiso("");
	}
	public Contacto(String nombreUno, String apellido) {
		setPrimerNombre(nombreUno);
		setApellido(apellido);
		setTelefono("", "No especifica");
		setMail("", "No especifica");
		domicilio = new String[8];
		setDomicilio("No especifica", "", "", "", "");
		setPartido("");
		setDepto("");
		setPiso("");
	}
	
	public void setTelefono(String telefono, String tipo) {
		this.telefono = new String[2];
		this.telefono[0] = telefono;
		this.telefono[1] = tipo;
	}
	public void setMail(String mail, String tipo) {
		this.mail = new String[2];
		this.mail[0] = mail;
		this.mail[1] = tipo;
	}
	public void setDomicilio(String calle, String numero, String localidad, String provincia, String pais) {
		domicilio[0] = calle;
		domicilio[1] = numero;
		domicilio[4] = localidad;
		domicilio[6] = provincia;
		domicilio[7] = pais;
	}
	public void setPartido(String partido) {
		domicilio[5] = partido;
	}
	public void setPiso(String piso) {
		domicilio[2] = piso;
	}
	public void setDepto(String depto) {
		domicilio[3] = depto;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getPrimerNombre() {
		return this.primerNombre;
	}
	public String getSegundoNombre() {
		return this.segundoNombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public String[] getTelefono() {
		return this.telefono;
	}
	public String[] getMail() {
		return this.mail;
	}
	public String[] getDomicilio() {
		return this.domicilio;
	}
	public String getCumpleanios() {
		return this.cumpleanios;
	}
	public String getEmpresa() {
		return this.empresa;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.primerNombre + " " + this.segundoNombre + 
				" \nApellido: " + this.apellido + 
				"\nTelefono: " + this.telefono[1] + " " + this.telefono[0] + 
				"\nMail: " + this.mail[1] + " " + this.mail[0] +
				"\nDomicilio: " + this.domicilio[0] + " " + this.domicilio[1] + " " + this.domicilio[2] + " " + this.domicilio[3] + " " + this.domicilio[4] + " " + this.domicilio[5] + " " + this.domicilio[6] + " " + this.domicilio[7] +
				"\nFecha de cumpleaños: " + this.cumpleanios + 
				"\nEmpresa donde trabaja: " + this.empresa;	
	}
}

	
	