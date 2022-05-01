package laboratorio;

public class Series extends Contenido {
	private int temporadas, capitulos;
	//Constructor
	public Series(String titulo, int fechaestreno, int duracion, String sinopsis, boolean tendencias, int temporadas,
			int capitulos) {
		super(titulo, fechaestreno, duracion, sinopsis, tendencias);
		this.temporadas = temporadas;
		this.capitulos = capitulos;
	}
	
	//Este método toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	public String toString() {
		String Tendencias = (isTendencias()) ? "Sí" : "No";
		return "Tipo de contenido: Serie | Título: " + getTitulo() + " | Capítulos: " + capitulos + " | Temporadas: "
				+ temporadas + " | Fecha de estreno: " + getFechaestreno() + " | Duración: " + getDuracion()
				+ " minutos | Sinopsis: " + getSinopsis() + " | Tendencias: " + Tendencias;
	}
	
	//Inicio Setters y Getters
	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	//Fin Setters y Getters

}
