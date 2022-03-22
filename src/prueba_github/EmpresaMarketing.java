package prueba_github;

public class EmpresaMarketing {
	private String nombre;
	private long telefono;
	private double precioCampaņaPelicula;

	EmpresaMarketing(String nombre, long telefono, double precioCampaņaPelicula){
		this.nombre=nombre;
		this.telefono=telefono;
		this.precioCampaņaPelicula=precioCampaņaPelicula;
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

	public double getPrecioCampaņaPelicula() {
		return precioCampaņaPelicula;
	}

	public void setPrecioCampaņaPelicula(double precioCampaņaPelicula) {
		this.precioCampaņaPelicula = precioCampaņaPelicula;
	}
}
