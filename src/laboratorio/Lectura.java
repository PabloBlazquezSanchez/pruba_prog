package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lectura {

	static Netflix n = new Netflix (); 

	public static void main(String[] args) throws IOException {
		leerFichero2("Contenido.csv");
		mostrarMenu();
		
	}
	
	public static void mostrarMenu() {
		int opcion=0;
		// TODO Auto-generated method stub
		do {
			System.out.println("Men�: \n"+"1. Mostrar toda la informaci�n del contenido de la plataforma.\n"
					+"2. Realizar una promoci�n de una pel�cula o una serie.\n"
					+"3. Mostrar todas las promociones realizadas.\n"
					+"4. Mostrar coste de todas las promociones realizadas.\n"
					+"5. Calcular coste de promoci�n de una pel�cula o serie en concreto.\n"
					+"6. Calcular el coste de una campa�a masiva de marketing.\n"
					+"7. Calcular la subvenci�n que se obtiene a partir de las pel�culas o series.\n"
					+"Escriba el n�mero de la opci�n que desea realizar: ");
			opcion = filtrarEscritura();
			switch(opcion) {
			case 1:
				mostrarContenido();
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
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.out.println("Programa finalizado.");
				break;
			default:
				System.out.println("Error. Vuelva a escribir la opci�n otra vez.\n");
				break;
			}
		}while(opcion !=8);
		
	}

	public static int filtrarEscritura() {
		// TODO Implementar despues un error de escritura
		int numero = 0;
		Scanner lectura = new Scanner(System.in);
		try {
			numero = lectura.nextInt();
		}catch(InputMismatchException ime) {
			System.out.println("S�lo puede escribir n�meros. Int�ntelo de nuevo: ");
			numero = filtrarEscritura();
		}
		return numero;
	}

	private static void mostrarContenido() {
		n.mostrarContenido();
		
	}

	private static void leerFichero2(String fichero) throws IOException {
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
				if (tipoContenido.charAt(0)== 's') { 
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
