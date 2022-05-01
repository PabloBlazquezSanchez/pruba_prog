package laboratorio;

public class EmpresaMarketing {
	private String nombre;
	private long telefono;
	private double precioCampa�aMarketing;
	
	//Constructor
	EmpresaMarketing(String nombre, long telefono, double precioCampa�aMarketing){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampa�aMarketing=precioCampa�aMarketing;
	}
	
	//Inicio Setters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public double getPrecioCampa�aMarketing() {
		return precioCampa�aMarketing;
	}

	public void setPrecioCampa�aMarketing(double precioCampa�aMarketing) {
		this.precioCampa�aMarketing = precioCampa�aMarketing;
	}
	//Fin Setters y Getters
	
	//Este m�todo toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	@Override
	public String toString() {
		return "La campa�a masiva de marketing con la empresa "+ getNombre()+ " cuyo tel�fono es el " + getTelefono()+ " es de " ;
	}
	
	
}
