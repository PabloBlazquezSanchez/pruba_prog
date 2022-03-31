package laboratorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Netflix {
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
			if(c.getTitulo()=="titulo por teclado") {
				
			}
		}
	}
	public void crearPromocion() {
		System.out.println("Escribe si la promoci�n es a trav�s de redes sociales (s/n): ");
		boolean redesSociales = leer.next().equals("s")?true:false;
		System.out.println("Escribe si la promoci�n es a trav�s de un cartel (s/n): ");
		boolean cartel = leer.next().equals("s")?true:false;
		System.out.println("Escribe el t�tulo de la serie o pel�cula de la que quieres crear promoci�n: ");
		String nombre = leer.next();
		for (Contenido c : contenidos) {
			System.out.println(c.toString());
			if(c.getTitulo()==nombre) {
				Promocion p = new Promocion(promociones.size(), null, cartel, redesSociales);
				promociones.add(p);
			}
		}
		
	}
}
