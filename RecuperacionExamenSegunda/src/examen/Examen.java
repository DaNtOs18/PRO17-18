package examen;

import java.util.ArrayList;
import java.util.HashMap;

import auxiliar.Practicas;

public class Examen {

	public static void main(String[] args) {
		Practicas practicas = new Practicas();
		HashMap<String, ArrayList<Integer>> listado = practicas.puntosLigaEquipos("ficheros/puntosEquipos.txt");
		practicas.imprimirValores(listado);
		System.out.println("Fin");
	}

}
