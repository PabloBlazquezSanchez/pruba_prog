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
	
	//A�adimos el contenido a la variable global contenido
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
	
	//Creamos una promoci�n de un contenido
	public void crearPromocion() {
		Contenido c;
		Promocion p = null;
		String texto;
		//Solicitud de datos por teclado
		System.out.println("Escribe si la promoci�n es a trav�s de redes sociales (s/n): ");
		texto= leer.nextLine();
		boolean redesSociales = filtraropciones(texto);
		System.out.println("Escribe si la promoci�n es a trav�s de un cartel (s/n): ");
		texto= leer.nextLine();
		boolean cartel = filtraropciones(texto);
		System.out.println("Escribe el t�tulo de la serie o pel�cula de la que quieres crear promoci�n: ");
		String nombre = leer.nextLine();

		// Realizaci�n de la comprobaci�n y creaci�n de la promoci�n con los datos introducidos
		try {
			c = tituloExisteEnContenido(nombre);
			p = new Promocion(promociones.size(), c, cartel, redesSociales);
			if (p.getContenido() instanceof Series) {
				comprobarPrecioPromocion(p);
			}
			System.out.println("Promoci�n realizada correctamente. ID asociado a esta promoci�n: " + promociones.size());
			promociones.add(p);
		} catch (ContenidoNoEncontradoException exc) { //Captura e imprime cuando el contenido no se ha encontrado
			System.out.println(exc.getMessage());

		} catch (PrecioSuperiorException exc) { //captura e imprime cuando el precio de la promoci�n de una serie supera los 12000 �
			System.out.println(exc.getMessage());
		}

	}
	
	//Este m�todo comprueba que la opci�n que se escribe es 's' o 'n'
	public boolean filtraropciones(String opcion) {
		if (opcion.toLowerCase().equals("s")) {
			confirmacion = true;
		} else if (opcion.toLowerCase().equals("n")) {
			confirmacion = false;
		} else { //Si la opci�n introducida no es ni 's' ni 'n'
			System.out.println("Opci�n incorrecta. Escriba 's' o 'n':");
			opcion= leer.nextLine();
			filtraropciones(opcion);
		}
		return confirmacion;

	}
	
	//Muestra todas las promociones que se han realizado, si no hay promociones salta un mensaje
	public void mostrarTodasPromociones() {
		if (promociones.isEmpty()) {
			System.out.println("No hay creada ninguna promoci�n.\n");
		}
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			System.out.println(pr.toString());
		}
	}
	
	//Halla el precio de una promoci�n
	public double precioPromocion(Promocion promociones) {
		double precio = 0;
		//Si la promoci�n es de una pel�cula
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
		//Si la promoci�n es de una serie
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
	
	//Calcula el precio de una promoci�n y lo muestra por pantalla
	public void calcularPreciounaPromocion(long id) {
		boolean verificacion = true;
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			if (pr.getIdPromocion() == id) {
				System.out.println("El coste de la promoci�n de " + pr.getContenido().getTitulo() + " es "
						+ precioPromocion(pr) + " euros.");
				verificacion = false;
			}

		}
		if (verificacion) { //Si el ID introducido no corresponde a ninguna promoci�n
			System.out.println("No hay ninguna promoci�n asociada a este ID\n");
		}
	}
	
	//Realiza una campa�a de marketing de todas las pel�culas y muestra el coste de realizar dicha campa�a
	public void campa�aMarketingMasiva() {
		int numPeliculas = 0;
		double precio = 0;
		EmpresaMarketing empresa = new EmpresaMarketing("Marketing UCLM", 925489031, Precio_Campa�a_Marketing);
		for (Contenido c : contenidos) { //Recorre la variable contenido desde una variable c
			//Si el contenido pertenece a una pel�cula
			if (c instanceof Pelicula) { 
				numPeliculas++;
			}
		}
		precio += (numPeliculas * empresa.getPrecioCampa�aMarketing());
		System.out.println(empresa.toString() + precio + " euros.");
	}
	
	//Calcula la subvenci�n obtenida del ayuntamiento por promocionar series o pel�culas y lo muestra por pantalla
	public void calcularSubvenciones(String tipo) {
		String tipo_serie = "serie";
		String tipo_pelicula = "pelicula";
		Ayuntamiento ayto = new Ayuntamiento("Jos� Dur�n", 910263499, Subvencion_Pelicula_NTendencia);
		double precio = 0;
		for (Promocion pr : promociones) { //Recorre la variable promociones desde una variable pr
			//Si la promoci�n es de una pel�cula
			if (tipo_pelicula.equals(tipo.toLowerCase()) && pr.getContenido() instanceof Pelicula && pr.isCartel()) {
				if (pr.getContenido().isTendencias()) {
					precio += Subvencion_Pelicula_Tendencia;
				} else {
					precio += Subvencion_Pelicula_NTendencia;
				}
			}
			//Si la promoci�n es de una serie
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
	
	//Este m�todo busca si el t�tulo introducido se encuentra en la variable contenido
	private Contenido tituloExisteEnContenido(String titulo) throws ContenidoNoEncontradoException {
		Contenido contenido = null;
		for (Contenido c : contenidos) { //Recorre la variable contenido desde una variable c
			if (c.getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				contenido = c;
			}
		}
		if (contenido == null) {
			//Si no se encuentra lanza la excepci�n de que el t�tulo no se ha encontrado
			throw new ContenidoNoEncontradoException("T�tulo de contenido no encontrado.\n");
		}
		return contenido;
	}
	
	//Este m�todo comprueba si el precio de la promoci�n de x serie supera los 12000 � 
	private void comprobarPrecioPromocion(Promocion p) throws PrecioSuperiorException {
		double precio = 0;
		precio += precioPromocion(p);
		if (precio > 12000) {
			//Si supera los 12000 � lanza la excepci�n y no se crea la promoci�n de esa serie
			throw new PrecioSuperiorException("El precio de la promoci�n de esta serie supera los 12000 euros, por lo que no se puede crear dicha promoci�n.");
		}
	}
}
