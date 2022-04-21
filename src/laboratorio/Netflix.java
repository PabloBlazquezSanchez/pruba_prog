package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import exceptions.ContenidoNoEncontradoException;

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
		System.out.println("Escribe si la promoción es a través de redes sociales (s/n): ");
		boolean redesSociales = leer.nextLine().equals("s") ? true : false;
		System.out.println("Escribe si la promoción es a través de un cartel (s/n): ");
		boolean cartel = leer.nextLine().toLowerCase().equals("s") ? true : false;
		System.out.println("Escribe el título de la serie o película de la que quieres crear promoción: ");
		String nombre = leer.nextLine();

		// Excepcion
		try {
			c = tituloExisteEnContenido(nombre);
			Promocion p = new Promocion(promociones.size(), c, cartel, redesSociales);
			promociones.add(p);
		} catch (ContenidoNoEncontradoException exc) {
			System.out.println(exc.getMessage());
		}

	}

	public void mostrarTodasPromociones() {
		if (promociones.isEmpty()) {System.out.println("No hay creada ninguna promoción.\n");}
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
		for (int i = promociones.size() - 1; i < 0; i--) {
			promocionestotales += precioPromocion(promociones.get(i));
		}
		System.out.println("El coste de todas las promociones es" + promocionestotales + "€");
	}

	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontradoException {
		Contenido contenido = null;
		for (Contenido c : contenidos) {
			if (c.getTitulo().equals(titulo)) {
				contenido = c;
			}
		}
		if (contenido == null) {
			throw new ContenidoNoEncontradoException("Título de contenido no encontrado");
		}
		return contenido;
	}

//	public void mostrarcosteTotalDePromociones() {
//	}

}
