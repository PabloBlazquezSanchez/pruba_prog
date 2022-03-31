package laboratorio;

public class Promocion {
	private long idPromocion;
	private boolean cartel;
	private boolean redesSociales;
	private Contenido contenido;

	public Promocion(long idPromocion, Contenido contenido, boolean cartel, boolean redesSociales) {
		this.idPromocion = idPromocion;
		this.cartel = cartel;
		this.redesSociales = redesSociales;
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
	
}
