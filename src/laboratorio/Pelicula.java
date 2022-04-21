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

	@Override
	public String toString() {
		String Tendencias= " ";
		if(isTendencias()) {Tendencias= "Sí";}else{Tendencias= "No";};
		return "Tipo de contenido: Película | Origen:" + origen + " | Productora:" + productora + " | Título:" + getTitulo()
				+ " | Fecha de estreno:" + getFechaestreno() + " | Duración:" + getDuracion() + " minutos | Sinopsis: "
				+ getSinopsis() + " | Tendencias: " + Tendencias;
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