package laboratorio;

public class Pelicula extends Contenido {
	private String origen;
	private String productora;

	public Pelicula(String titulo, int fechaestreno, int duracion, String sinopsis, boolean tendencias, String origen,
			String productora) {
		super(titulo, fechaestreno, duracion, sinopsis, tendencias);
		this.origen = origen;
		this.productora = productora;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public double calcularPrecioPromocion() {
		return 0;
	}

}