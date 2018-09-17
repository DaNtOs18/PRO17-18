package control;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Libro;
import modelo.dao.Examen;
public class Main {
	public static void main(String[] args) {
		// COMENTARIO DE EXAMEN:
		// SE HAN DEJADO LAS LLAMADAS A LOS TRES EJERCICIOS, PUEDES  USARLAS, SI QUIERES.
		
		Examen examen = new Examen();
	     // HashMap<Integer, ArrayList<Libro>> l = examen.getLibrosTemas();
	   int[][] mat = examen.ejercicio1(9, 6, 10, 100);
		//examen.ejercicio2("ficheros/movimientos.txt");
		//HashMap<Integer, ArrayList<Libro>> librosTemas = examen.getLibrosPorTemas();
		System.out.println("FIN");
	}
}