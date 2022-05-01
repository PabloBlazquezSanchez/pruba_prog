package laboratorio;

public class Ayuntamiento {
	private String nombreContacto;
	private long telefono;
	private double subvencionMinCartel;
	
	//Constructor
	Ayuntamiento(String nombreContacto, long telefono, double subvencionMinCartel) {
		this.nombreContacto=nombreContacto;
		this.telefono=telefono;
		this.subvencionMinCartel=subvencionMinCartel;
	}
	
	//Inicio Setters y Getters
	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public double getSubvencionMinCartel() {
		return subvencionMinCartel;
	}

	public void setSubvencionMinCartel(double subvencionMinCartel) {
		this.subvencionMinCartel = subvencionMinCartel;
	}
	//Fin Setters y Getters
	
	//Este método toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	@Override
	public String toString() {
		return "Nombre del responsable del ayuntamiento: " + getNombreContacto() + " | Teléfono: " + getTelefono();
	}
	
	
}
