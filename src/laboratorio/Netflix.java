package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import exceptions.ContenidoNoEncontradoException;
import exceptions.PrecioSuperiorException;

public class Netflix implements utils.Constantes {
	private Scanner leer = new Scanner(System.in);
	private List<Contenido> contenidos = new ArrayList<Contenido>();
	private List<Promocion> promociones = new ArrayList<Promocion>();

	public Netflix() {
	}

	public void addContenido(Contenido contenido) {
		contenidos.add(contenido);
	}

	public void mostrarContenido() {
		for (Contenido c : contenidos) {
			System.out.println();
			System.out.println(c.toString());
		}
		System.out.println();
	}

	public void crearPromocion() {
		Contenido c;
		Promocion p = null;
		String texto;
		System.out.println("Escribe si la promoci�n es a trav�s de redes sociales (s/n): ");
		texto= leer.nextLine();
		boolean redesSociales = filtraropciones(texto);
		System.out.println("Escribe si la promoci�n es a trav�s de un cartel (s/n): ");
		texto= leer.nextLine();
		boolean cartel = filtraropciones(texto);
		System.out.println("Escribe el t�tulo de la serie o pel�cula de la que quieres crear promoci�n: ");
		String nombre = leer.nextLine();

		// Excepcion
		try {
			c = tituloExisteEnContenido(nombre);
			p = new Promocion(promociones.size(), c, cartel, redesSociales);
			if (p.getContenido() instanceof Series) {
				comprobarPrecioPromocion(p);
			}
			System.out.println("Promoci�n realizada correctamente. ID asociado a esta promoci�n: " + promociones.size());
			promociones.add(p);
		} catch (ContenidoNoEncontradoException exc) {
			System.out.println(exc.getMessage());

		} catch (PrecioSuperiorException exc) {
			System.out.println(exc.getMessage());
		}

	}

	public boolean filtraropciones(String opcion) {
		boolean confirmacion = false;
		if (opcion.toLowerCase().equals("s")) {
			confirmacion = true;
		} else if (opcion.toLowerCase().equals("n")) {
			confirmacion = false;
		} else {
			System.out.println("Opci�n incorrecta. Escriba 's' o 'n':");
			opcion= leer.nextLine();
			filtraropciones(opcion);
		}
		return confirmacion;

	}

	public void mostrarTodasPromociones() {
		if (promociones.isEmpty()) {
			System.out.println("No hay creada ninguna promoci�n.\n");
		}
		for (Promocion pr : promociones) {
			System.out.println(pr.toString());
		}
	}

	public double precioPromocion(Promocion promociones) {
		double precio = 0;
		if (promociones.getContenido() instanceof Pelicula) {
			if (promociones.isCartel()) {
				precio += Precio_Cartel_Peliculas;
			}
			if (promociones.isRedesSociales()) {
				precio += Precio_RRSS_Peliculas;
			}
			if (promociones.getContenido().isTendencias()) {
				precio *= Aumento_Tendencias_Peliculas;
			}
		}

		if (promociones.getContenido() instanceof Series) {
			Series serie = (Series) promociones.getContenido();

			if (promociones.isRedesSociales()) {
				precio += (Precio_RRSS_Series * serie.getTemporadas());
			}
			if (promociones.isCartel()) {
				precio += (Precio_Cartel_Series * serie.getCapitulos());
			}
			if (promociones.getContenido().isTendencias()) {
				precio *= Aumento_Tendencias_Series;
			}
		}
		return precio;
	}

	public void calcularPrecioPromocionesRealizadas() {
		double promocionestotales = 0;
		// int i = promociones.size() - 1; i < 0; i--
		for (int i = 0; i < promociones.size(); i++) {
			promocionestotales += precioPromocion(promociones.get(i));
		}
		System.out.println("El coste de todas las promociones es " + promocionestotales + "�");
	}

	public void calcularPreciounaPromocion(long id) {
		boolean verificacion = true;
		for (Promocion pr : promociones) {
			if (pr.getIdPromocion() == id) {
				System.out.println("El coste de la promoci�n de " + pr.getContenido().getTitulo() + " es "
						+ precioPromocion(pr) + "�");
				verificacion = false;
			}

		}
		if (verificacion) {
			System.out.println("No hay ninguna promoci�n asociada a este ID\n");
		}
	}

	public void campa�aMarketingMasiva() {
		int contador = 0;
		double precio = 0;
		EmpresaMarketing empresa = new EmpresaMarketing("Marketing UCLM", 925489031, Precio_Campa�a_Marketing);
		for (Contenido c : contenidos) {
			if (c instanceof Pelicula) {
				contador++;
			}
		}
		precio += (contador * empresa.getPrecioCampa�aMarketing());
		System.out.println(empresa.toString() + " | Precio total de la campa�a masiva: " + precio + " �");
	}

	public void calcularSubvenciones(String tipo) {
		String tipo_serie = "serie";
		String tipo_pelicula = "pelicula";
		Ayuntamiento ayto = new Ayuntamiento("Manolo Lama", 910263499, Subvencion_Pelicula_NTendencia);
		double precio = 0;
		for (Promocion pr : promociones) {
			if (tipo_pelicula.equals(tipo) && pr.getContenido() instanceof Pelicula && pr.isCartel()) {
				if (pr.getContenido().isTendencias()) {
					precio += Subvencion_Pelicula_Tendencia;
				} else {
					precio += Subvencion_Pelicula_NTendencia;
				}
			}
			if (tipo_serie.equals(tipo) && pr.getContenido() instanceof Series && pr.isCartel()) {
				if (pr.getContenido().isTendencias()) {
					precio += Subvencion_Serie_Tendencia;
				} else {
					precio += Subvencion_Serie_NTendencia;
				}
			}
		}
		System.out.println(ayto.toString() + " | Subvenciones recibidas del ayuntamiento: " + precio + " �");
	}

	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontradoException {
		Contenido contenido = null;
		for (Contenido c : contenidos) {
			if (c.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				contenido = c;
			}
		}
		if (contenido == null) {
			throw new ContenidoNoEncontradoException("T�tulo de contenido no encontrado.\n");
		}
		return contenido;
	}

	private void comprobarPrecioPromocion(Promocion p) throws PrecioSuperiorException {
		double precio = 0;
		precio += precioPromocion(p);
		if (precio > 12000) {
			throw new PrecioSuperiorException("El precio de la promoci�n de esta serie supera los 12000 �, por lo que no se puede crear dicha promoci�n.");
		}
	}
}
