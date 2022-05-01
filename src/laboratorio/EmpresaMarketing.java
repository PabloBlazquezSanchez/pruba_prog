package laboratorio;

public class EmpresaMarketing {
	private String nombre;
	private long telefono;
	private double precioCampañaMarketing;
	
	//Constructor
	EmpresaMarketing(String nombre, long telefono, double precioCampañaMarketing){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampañaMarketing=precioCampañaMarketing;
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

	public double getPrecioCampañaMarketing() {
		return precioCampañaMarketing;
	}

	public void setPrecioCampañaMarketing(double precioCampañaMarketing) {
		this.precioCampañaMarketing = precioCampañaMarketing;
	}
	//Fin Setters y Getters
	
	//Este método toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	@Override
	public String toString() {
		return "La campaña masiva de marketing con la empresa "+ getNombre()+ " cuyo teléfono es el " + getTelefono()+ " es de " ;
	}
	
	
}
