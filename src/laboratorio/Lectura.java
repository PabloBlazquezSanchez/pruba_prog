package laboratorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lectura {
	static Netflix n = new Netflix();

	public static void main(String[] args) throws IOException, FileNotFoundException {
		leerFichero2("Contenido.csv");
		mostrarMenu();
	}

	public static void mostrarMenu() {
		int opcion = 0;
		do {
			System.out.println("Men�: \n" + "1. Mostrar toda la informaci�n del contenido de la plataforma.\n"
					+ "2. Realizar una promoci�n de una pel�cula o una serie.\n"
					+ "3. Mostrar todas las promociones realizadas.\n"
					+ "4. Mostrar coste de todas las promociones realizadas.\n"
					+ "5. Calcular coste de promoci�n de una pel�cula o serie en concreto.\n"
					+ "6. Calcular el coste de una campa�a masiva de marketing.\n"
					+ "7. Calcular la subvenci�n que se obtiene a partir de las pel�culas o series.\n"
					+ "8. Finalizar el programa.\n"
					+ "Escriba el n�mero de la opci�n que desea realizar: ");
			opcion = (int) filtrarEscritura();
			switch (opcion) {
			case 1:
				n.mostrarContenido();
				break;
			case 2:
				n.crearPromocion();
				break;
			case 3:
				n.mostrarTodasPromociones();
				break;
			case 4:
				n.calcularPrecioPromocionesRealizadas();
				break;
			case 5:
				costePromocionconreta();
				break;
			case 6:
				n.campa�aMarketingMasiva();
				break;
			case 7:
				calculoSubvenciones();
				break;
			case 8:
				System.out.println("Programa finalizado.");
				break;
			default:
				System.out.println("Error. Vuelva a escribir la opci�n otra vez.\n");
				break;
			}
		} while (opcion != 8);

	}

	private static void costePromocionconreta() {
		long id;
		Scanner lectura = new Scanner(System.in);
		System.out.println("Escriba el ID de la promoci�n realizada a una pel�cula o serie para saber el coste de esta:");
		id = filtrarEscritura();
		n.calcularPreciounaPromocion(id);
	}

	private static void calculoSubvenciones() {
		String tipo;
		Scanner lectura = new Scanner(System.in);
		boolean comprobacion = true;
		do {
			System.out.println("Si desea calcular las subvenciones obtenidas a partir de las series escriba \"serie\" y si lo desea para las pel�culas escriba \"pelicula\".");
			tipo = lectura.nextLine();
			if (tipo.toLowerCase().equals("serie") || tipo.toLowerCase().equals("pelicula")) {
				comprobacion = false;
			}
			if (comprobacion) {
				System.out.println("Error. Vuelva a escribir su respuesta.");
			}
		} while (comprobacion);

		n.calcularSubvenciones(tipo);
	}

	public static long filtrarEscritura() {
		long numero = 0;
		Scanner lectura = new Scanner(System.in);
		try {
			numero = lectura.nextLong();
		} catch (InputMismatchException ime) {
			System.out.println("S�lo puede escribir n�meros. Int�ntelo de nuevo: ");
			numero = filtrarEscritura();
		}
		return numero;
	}

	private static void leerFichero2(String fichero) throws IOException, FileNotFoundException {
		String titulo, descripcion, tipoContenido, productora, pais;
		int a�o, duracion, nTemporadas, nCapitulos;
		boolean tendencia;
		Contenido contenido;
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while ((line = br.readLine()) != null) {
				String[] split = line.split(";");
				tipoContenido = split[0];
				titulo = split[1];
				a�o = Integer.valueOf(split[2]);
				duracion = Integer.valueOf(split[3]);
				descripcion = split[4];
				tendencia = Boolean.valueOf(split[5]);

				// Informacion de una Pelicula
				if (tipoContenido.charAt(0) == 's') {
					nTemporadas = Integer.valueOf(split[6]);
					nCapitulos = Integer.valueOf(split[7]);
					contenido = new Series(titulo, a�o, duracion, descripcion, tendencia, nTemporadas, nCapitulos);
					n.addContenido(contenido);
				}
				// Informacion de una Pelicula
				else {
					productora = split[6];
					pais = split[7];
					contenido = new Pelicula(titulo, a�o, duracion, descripcion, tendencia, productora, pais);
					n.addContenido(contenido);
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("El fichero no existe en el directorio de b�squeda.\n"
					+ "El programa no puede continuar ejecut�ndose. Fin del Programa.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
