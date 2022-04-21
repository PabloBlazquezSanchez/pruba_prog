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
		return "Series [temporadas=" + temporadas + ", capitulos=" + capitulos + ", getTitulo()=" + getTitulo()
				+ ", getFechaestreno()=" + getFechaestreno() + ", getDuracion()=" + getDuracion() + ", getSinopsis()="
				+ getSinopsis() + ", isTendencias()=" + isTendencias() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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
