package prueba_github;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		leerFichero2("Contenido.csv");
	}
	
	private static void leerFichero2(String fichero) throws IOException {
		String titulo, descripcion, tipoContenido, productora, pais;
		int año, duracion, nTemporadas, nCapitulos;
		boolean tendencia;
		Contenido contenido;
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			while ((line = br.readLine()) != null) {
				String[] split = line.split(";");
				tipoContenido = split[0];
				titulo = split[1];
				año = Integer.valueOf(split[2]);
				duracion = Integer.valueOf(split[3]);
				descripcion = split[4];
				tendencia = Boolean.valueOf(split[5]);

				// Informacion de una Pelicula
				if (tipoContenido.charAt(0)== 's') { 
					nTemporadas = Integer.valueOf(split[6]);
					nCapitulos = Integer.valueOf(split[7]);
					contenido = new Series(titulo, año, duracion, descripcion, tendencia, nTemporadas, nCapitulos);
				} 
				// Informacion de una Pelicula
				else { 
					productora = split[6];
					pais = split[7];
					contenido = new Pelicula(titulo, año, duracion, descripcion, tendencia, productora, pais);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
