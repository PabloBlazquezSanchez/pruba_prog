package laboratorio;

public class Pelicula extends Contenido {
	private String origen;
	private String productora;
	
	//Constructor
	public Pelicula(String titulo, int fechaestreno, int duracion, String sinopsis, boolean tendencias, String origen,
			String productora) {
		super(titulo, fechaestreno, duracion, sinopsis, tendencias);
		this.origen = origen;
		this.productora = productora;
	}
	
	//Este método toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	@Override
	public String toString() {
		String Tendencias = (isTendencias()) ? "Sí" : "No";
		return "Tipo de contenido: Película | Origen: " + origen + " | Productora: " + productora + " | Título: "
				+ getTitulo() + " | Fecha de estreno: " + getFechaestreno() + " | Duración: " + getDuracion()
				+ " minutos | Sinopsis: " + getSinopsis() + " | Tendencias: " + Tendencias;
	}
	
	//Inicio Setters y Getters
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
	//Fin Setters y Getters


}