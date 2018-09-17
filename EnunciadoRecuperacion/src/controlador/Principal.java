package controlador;

import modelo.Equipo;
import modelo.Jugador;

public class Principal {
	// llamar DESDE AQUI a los métodos implementados en la clase "Ejercicios"
	// Recuerda crear el método main, respetando su prototipo.
	public static void main(String[] args) {
		// Ejercicio 1
		Ejercicios e = new Ejercicios();
		float[] e1 = { 8.3f, 4.5f, 56.3f, 23.2f, 54f, 12f, 9f, 12f, 32f, 47f, 76f, 3f, 4f, -1f };
		int pos = e.obtenerPosicionMayor(e1);
		System.out.println(pos);
		// Ejercicio 2
		int[] e2 = { 6, 7, 4, 3, 9, 8, 2, 12, 30, 40, 5, 90 };
		boolean b = e.hayRepetidos(e2);
		System.out.println(b);

		// CREACION DE LOS ARRAYS equipos y jugadores

		// NO TOCAR ESTAS DOS LINEAS, PARA PODER HACER LOS EJERCICIOS 3 Y 4 (!!)
		// DEDICA UN POCO A ESTUDIAR CÓMO ESTÁN ORGANIZADOS LOS EQUIPOS Y JUGADORES...
		Ejercicios.creaListaEquipos();
		Ejercicios.creaListaJugadores();
		// NO TOCAR LAS DOS LLAMADAS ANTERIORES!!

		// Ejercicio 3
		Equipo equipo = new Equipo(2, "Las Palmas", "Gran Canaria", "1889");
		Jugador[] jugadores = e.listaJugadoresEquipo(equipo);
		System.out.println(equipo);

		// Ejercicio 4
		Equipo eq = e.getEquipoJugador(300);
		System.out.println(eq);
		System.out.println("FIN");

	}
}
