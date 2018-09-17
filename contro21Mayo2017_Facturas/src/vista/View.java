package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import controlador.Controller;
import modelo.Jugador;

public class View {
	
	
	
	public void mostrarJugadoresView(HashMap<Integer, ArrayList<Jugador>> equipos) {
		String[] nombreEquipos = {"Real Madrid", "Barcelona", "Sevilla"};
		int totalGoles = 0;
		int sumaEdad = 0;
		int edad = 0;
		int contador = 0;
		for (Integer equipo : equipos.keySet()) {
			System.out.println("========== EQUIPO: " + nombreEquipos[equipo] + " ==========");
			System.out.printf("%-10s","NOMBRE");
			System.out.printf("%-25s","FECHA NACIMIENTO");
			System.out.printf("%-20s","GOLES");
			System.out.printf("%-10s","EDAD");
			System.out.println();
			for ( Jugador unJugador : equipos.get(equipo)) {
				System.out.printf("%-10s",unJugador.getNombre());
				System.out.printf("%-25s",unJugador.getFecha());
				System.out.printf("%-20s",unJugador.getGolesMarcados());
				edad = Controller.calculaEdad(unJugador.getFecha());
				System.out.printf("%-10s",Controller.calculaEdad(unJugador.getFecha()));
				System.out.println();
				totalGoles = totalGoles + unJugador.getGolesMarcados();
				sumaEdad = edad + sumaEdad;
				contador++;
			}
			System.out.println("------------> TOTAL GOLES EQUIPO: " + totalGoles);
			System.out.println("------------> EDAD MEDIA EQUIPO: " + sumaEdad/contador + "\n\n");
		}
	}

}
