package prueba_github;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Netflix {
	private List<Contenido> contenidos = new ArrayList<Contenido>();

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
}
