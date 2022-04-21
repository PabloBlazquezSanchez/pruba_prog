package laboratorio;

public class Series extends Contenido {
	private int temporadas, capitulos;

	public Series(String titulo, int fechaestreno, int duracion, String sinopsis, boolean tendencias, int temporadas,
			int capitulos) {
		super(titulo, fechaestreno, duracion, sinopsis, tendencias);
		this.temporadas = temporadas;
		this.capitulos = capitulos;
	}

	public double calcularPrecioPromocion() {
		return 0;
	}

	@Override
	public String toString() {
		String Tendencias = (isTendencias()) ? "S�" : "No";
		return "Tipo de contenido: Serie | Temporadas:" + temporadas + " | Cap�tulos:" + capitulos + " | T�tulo:"
				+ getTitulo() + " | Fecha de estreno:" + getFechaestreno() + " | Duraci�n:" + getDuracion()
				+ " minutos | Sinopsis: " + getSinopsis() + " | Tendencias: " + Tendencias;
	}

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

}
