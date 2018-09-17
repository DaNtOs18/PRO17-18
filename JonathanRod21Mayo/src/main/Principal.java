package main;

import java.util.ArrayList;
import java.util.HashMap;

import auxiliar.Examen;
import modelo.Jugador;

public class Principal {

	public static void main(String[] args) {
		Examen ex = new Examen();
		// ArrayList<Jugador> resul =
		// ex.leeObjetosDesdeFichero("ficheros/jugadores.obj");
		HashMap<Integer, ArrayList<Jugador>> equipos = ex.leerJugadoresDao();
		ex.ordenaJugadores(equipos);

		System.out.println("Fin");

	}

}
