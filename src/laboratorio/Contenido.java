package laboratorio;

public abstract class Contenido {
	private String titulo;
	private int fechaestreno, duracion;
	private String sinopsis;
	private boolean tendencias;
	
	public Contenido (String titulo, int fechaestreno, int duracion, String sinopsis, boolean tendencias) {
		this.titulo=titulo;
		this.fechaestreno=fechaestreno;
		this.duracion=duracion;
		this.sinopsis=sinopsis;
		this.tendencias=tendencias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getFechaestreno() {
		return fechaestreno;
	}

	public void setFechaestreno(int fechaestreno) {
		this.fechaestreno = fechaestreno;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public boolean isTendencias() {
		return tendencias;
	}

	public void setTendencias(boolean tendencias) {
		this.tendencias = tendencias;
	}
}
