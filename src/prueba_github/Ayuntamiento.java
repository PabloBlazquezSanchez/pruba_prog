package prueba_github;

public class Ayuntamiento {
	private String nombreContacto;
	private long telefono;
	private double subvencionMinCartel;

	Ayuntamiento(String nombreContacto, long telefono, double subvencionMinCartel) {
		this.nombreContacto=nombreContacto;
		this.telefono=telefono;
		this.subvencionMinCartel=subvencionMinCartel;
	}
	
		public String getNombreContacto() {
			return nombreContacto;
		}

		public void setNombreContacto(String nombreContacto) {
			this.nombreContacto = nombreContacto;
		}

		public long getTelefono() {
			return telefono;
		}

		public void setTelefono(long telefono) {
			this.telefono = telefono;
		}

		public double getSubvencionMinCartel() {
			return subvencionMinCartel;
		}

		public void setSubvencionMinCartel(double subvencionMinCartel) {
			this.subvencionMinCartel = subvencionMinCartel;
		

	}
}
