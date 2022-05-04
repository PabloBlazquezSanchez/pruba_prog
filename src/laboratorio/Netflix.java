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

public class Netflix implements utils.Constantes { //Con este implements incluimos las interfaces
	private Scanner leer = new Scanner(System.in);
	static boolean confirmacion = false;
	private List<Contenido> contenidos = new ArrayList<Contenido>(); //Variable contenido de tipo Contenido
	private List<Promocion> promociones = new ArrayList<Promocion>(); //Variable promociones de tipo Promocion
	
	//Constructor
	public Netflix() {
	}
	
	//Añadimos el contenido a la variable global contenido
	public void addContenido(Contenido contenido) {
		contenidos.add(contenido);
	}
	
	//Mostramos todo el contenido almacenado en la variable contenido
	public void mostrarContenido() {
		for (Contenido c : contenidos) { //Recorre la variable contenido desde una variable c
			System.out.println();
			System.out.println(c.toString());
		}
		System.out.println();
	}
	
	//Creamos una promoción de un contenido
	public void crearPromocion() {
		Contenido c;
		Promocion p = null;
		String texto;
		//Solicitud de datos por teclado
		System.out.println("Escribe si la promoción es a través de redes sociales (s/n): ");
		texto= leer.nextLine();
		boolean redesSociales = filtraropciones(texto);
		System.out.println("Escribe si la promoción es a través de un cartel (s/n): ");
		texto= leer.nextLine();
		boolean cartel = filtraropciones(texto);
		System.out.println("Escribe el título de la serie o película de la que quieres crear promoción: ");
		String nombre = leer.nextLine();

		// Realización de la comprobación y creación de la promoción con los datos introducidos
		try {
			c = tituloExisteEnContenido(nombre);
			p = new Promocion(promociones.size(), c, cartel, redesSociales);
			if (p.getContenido() instanceof Series) {
				comprobarPrecioPromocion(p);
			}
			System.out.println("Promoción realizada correctamente. ID asociado a esta promoción: " + promociones.size());
			promociones.add(p);
		} catch (ContenidoNoEncontradoException exc) { //Captura e imprime cuando el contenido no se ha encontrado
			System.out.println(exc.getMessage());

		} catch (PrecioSuperiorException exc) { //captura e imprime cuando el precio de la promoción de una serie supera los 12000 €
			System.out.println(exc.getMessage());
		}

	}
	
	//Este método comprueba que la opción que se escribe es 's' o 'n'
	public boolean filtraropciones(String opcion) {
		if (opcion.toLowerCase().equals("s")) {
			confirmacion = true;
		} else if (opcion.toLowerCase().equals("n")) {
			confirmacion = false;
		} else { //Si la opción introducida no es ni 's' ni 'n'
			System.out.println("Opción incorrecta. Escriba 's' o 'n':");
			opcion= leer.nextLine();
			filtraropciones(opcion);
		}
		return confirmacion;

	}
	
	//Muestra todas las promociones que se han realizado, si no hay promociones salta un mensaje
	public void mostrarTodasPromociones() {
		if (promociones.isEmpty()) {
			System.out.println("No hay creada ninguna promoción.\n");
		}
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			System.out.println(pr.toString());
		}
	}
	
	//Halla el precio de una promoción
	public double precioPromocion(Promocion promociones) {
		double precio = 0;
		//Si la promoción es de una película
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
		//Si la promoción es de una serie
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
	
	//Muestra el precio de todas las promociones que se han realizado
	public void calcularPrecioPromocionesRealizadas() {
		double promocionestotales = 0;
		for (int i = 0; i < promociones.size(); i++) {
			promocionestotales += precioPromocion(promociones.get(i));
		}
		System.out.println("El coste de todas las promociones es " + promocionestotales + " euros.");
	}
	
	//Calcula el precio de una promoción y lo muestra por pantalla
	public void calcularPreciounaPromocion(long id) {
		boolean verificacion = true;
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			if (pr.getIdPromocion() == id) {
				System.out.println("El coste de la promoción de " + pr.getContenido().getTitulo() + " es "
						+ precioPromocion(pr) + " euros.");
				verificacion = false;
			}

		}
		if (verificacion) { //Si el ID introducido no corresponde a ninguna promoción
			System.out.println("No hay ninguna promoción asociada a este ID\n");
		}
	}
	
	//Realiza una campaña de marketing de todas las películas y muestra el coste de realizar dicha campaña
	public void campañaMarketingMasiva() {
		int numPeliculas = 0;
		double precio = 0;
		EmpresaMarketing empresa = new EmpresaMarketing("Marketing UCLM", 925489031, Precio_Campaña_Marketing);
		for (Contenido c : contenidos) { //Recorre la variable contenido desde una variable c
			//Si el contenido pertenece a una película
			if (c instanceof Pelicula) { 
				numPeliculas++;
			}
		}
		precio += (numPeliculas * empresa.getPrecioCampañaMarketing());
		System.out.println(empresa.toString() + precio + " euros.");
	}
	
	//Calcula la subvención obtenida del ayuntamiento por promocionar series o películas y lo muestra por pantalla
	public void calcularSubvenciones(String tipo) {
		String tipo_serie = "serie";
		String tipo_pelicula = "pelicula";
		Ayuntamiento ayto = new Ayuntamiento("José Durán", 910263499, Subvencion_Pelicula_NTendencia);
		double precio = 0;
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			//Si la promoción es de una película
			if (tipo_pelicula.equals(tipo.toLowerCase()) && pr.getContenido() instanceof Pelicula && pr.isCartel()) {
				if (pr.getContenido().isTendencias()) {
					precio += Subvencion_Pelicula_Tendencia;
				} else {
					precio += Subvencion_Pelicula_NTendencia;
				}
			}
			//Si la promoción es de una serie
			if (tipo_serie.equals(tipo.toLowerCase()) && pr.getContenido() instanceof Series && pr.isCartel()) {
				if (pr.getContenido().isTendencias()) {
					precio += Subvencion_Serie_Tendencia;
				} else {
					precio += Subvencion_Serie_NTendencia;
				}
			}
		}
		System.out.println(ayto.toString() + " | Subvenciones recibidas del ayuntamiento: " + precio + " euros.");
	}
	
	//Este método busca si el título introducido se encuentra en la variable contenido
	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontradoException {
		Contenido contenido = null;
		for (Contenido c : contenidos) { //Recorre la variable contenido desde una variable c
			if (c.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				contenido = c;
			}
		}
		if (contenido == null) {
			//Si no se encuentra lanza la excepción de que el título no se ha encontrado
			throw new ContenidoNoEncontradoException("Título de contenido no encontrado.\n");
		}
		return contenido;
	}
	
	//Este método comprueba si el precio de la promoción de x serie supera los 12000 € 
	private void comprobarPrecioPromocion(Promocion p) throws PrecioSuperiorException {
		double precio = 0;
		precio += precioPromocion(p);
		if (precio > 12000) {
			//Si supera los 12000 € lanza la excepción y no se crea la promoción de esa serie
			throw new PrecioSuperiorException("El precio de la promoción de esta serie supera los 12000 euros, por lo que no se puede crear dicha promoción.");
		}
	}
}
