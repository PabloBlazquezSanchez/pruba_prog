package laboratorio;

public class EmpresaMarketing {
	private String nombre;
	private long telefono;
	private double precioCampañaMarketing;

	EmpresaMarketing(String nombre, long telefono, double precioCampañaMarketing){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampañaMarketing=precioCampañaMarketing;
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

	public double getPrecioCampañaMarketing() {
		return precioCampañaMarketing;
	}

	public void setPrecioCampañaMarketing(double precioCampañaMarketing) {
		this.precioCampañaMarketing = precioCampañaMarketing;
	}

	@Override
	public String toString() {
		return "Nombre de empresa: " + getNombre() + "| Teléfono:" + getTelefono();
	}
	
	
}
