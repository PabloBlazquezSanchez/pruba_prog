package laboratorio;

public class EmpresaMarketing implements utils.Constantes {
	private String nombre;
	private long telefono;
	private double precioCampaņaMarketing;

	EmpresaMarketing(String nombre, long telefono, double precioCampaņaMarketing){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampaņaMarketing=precioCampaņaMarketing;
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

	public double getPrecioCampaņaMarketing() {
		return precioCampaņaMarketing;
	}

	public void setPrecioCampaņaMarketing(double precioCampaņaMarketing) {
		this.precioCampaņaMarketing = precioCampaņaMarketing;
	}

	@Override
	public String toString() {
		return "EmpresaMarketing [nombre=" + nombre + ", telefono=" + telefono + ", precioCampaņaMarketing="
				+ precioCampaņaMarketing + ", getNombre()=" +getNombre() + ", getTelefono()=" + getTelefono()
				+ ", getPrecioCampaņaMarketing()=" + getPrecioCampaņaMarketing() + "]";
	}
	
	
}
