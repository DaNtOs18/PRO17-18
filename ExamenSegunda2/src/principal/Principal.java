package principal;


import java.util.ArrayList;
import java.util.HashMap;

import auxiliar.Practicas;

public class Principal {

	public static void main(String[] args) {
		
		//String asignatura = new String();//
		Practicas miPractica = new Practicas();
		
		
	
		String[] asignaturas = miPractica.leerFicheroTextoAsignaturasToArray("ficheros/asignaturas.txt");
		HashMap<String, ArrayList<Integer>> notasFinalesAlumnos = miPractica.leerFicheroNotas("ficheros/notasAlumnos.txt");
		miPractica.imprimirValores(asignaturas, notasFinalesAlumnos);
		
		
	System.out.println("fin");	
	}

}

