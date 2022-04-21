package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import exceptions.ContenidoNoEncontradoException;

public class Netflix implements utils.Constantes{
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
			System.out.println(c.toString());
		}
	}

	public void crearPromocion() {
		System.out.println("Escribe si la promoción es a través de redes sociales (s/n): ");
		boolean redesSociales = leer.next().equals("s") ? true : false;
		System.out.println("Escribe si la promoción es a través de un cartel (s/n): ");
		boolean cartel = leer.next().toLowerCase().equals("s") ? true : false;
		System.out.println("Escribe el título de la serie o película de la que quieres crear promoción: ");
		String nombre = leer.next();
		// Excepcion
		try {
			tituloExisteEnContenido(nombre);
		} catch (ContenidoNoEncontradoException exc) {
			System.out.println(exc.getMessage());
		}
		for (Contenido c : contenidos) {
			if (c.getTitulo() == nombre) {
				Promocion p = new Promocion(promociones.size(), c, cartel, redesSociales);
				promociones.add(p);
			}
		}
	}

	public void mostrarTodasPromociones() {
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
