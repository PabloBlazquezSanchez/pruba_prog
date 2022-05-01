package laboratorio;

public class Promocion {
	private long idPromocion;
	private boolean cartel;
	private boolean redesSociales;
	private Contenido contenido;
	
	//Este método toString sirve para devolver una cadena de texto en la que se encuentra los Getters de las variables que queremos imprimir
	@Override
	public String toString() {
		String cartel1 = (cartel) ? "Sí" : "No";
		String redesSociales1 = (redesSociales) ? "Sí" : "No";
		return "Título del contenido: " + contenido.getTitulo() + " | ID de Promocion: " + idPromocion
				+ " | Uso de cartel: " + cartel1 + " | Uso de RRSS: " + redesSociales1;
	}
	
	//Constructor
	public Promocion(long idPromocion, Contenido contenido, boolean cartel, boolean redesSociales) {
		this.idPromocion = idPromocion;
		this.cartel = cartel;
		this.redesSociales = redesSociales;
		this.contenido = contenido;
	}
	
	//Inicio Setters y Getters
	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public long getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(long idPromocion) {
		this.idPromocion = idPromocion;
	}

	public boolean isCartel() {
		return cartel;
	}

	public void setCartel(boolean cartel) {
		this.cartel = cartel;
	}

	public boolean isRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(boolean redesSociales) {
		this.redesSociales = redesSociales;
	}
	//Fin Setters y Getters

}
