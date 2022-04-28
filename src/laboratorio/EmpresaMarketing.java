package laboratorio;

public class EmpresaMarketing implements utils.Constantes {
	private String nombre;
	private long telefono;
	private double precioCampa�aMarketing;

	EmpresaMarketing(String nombre, long telefono, double precioCampa�aMarketing){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampa�aMarketing=precioCampa�aMarketing;
	}

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

	@Override
	public String toString() {
		return "EmpresaMarketing [nombre=" + nombre + ", telefono=" + telefono + ", precioCampa�aMarketing="
				+ precioCampa�aMarketing + ", getNombre()=" +getNombre() + ", getTelefono()=" + getTelefono()
				+ ", getPrecioCampa�aMarketing()=" + getPrecioCampa�aMarketing() + "]";
	}
	
	
}
