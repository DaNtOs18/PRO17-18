package controlador;

import modelo.Equipo;
import modelo.Jugador;

public class Ejercicios {
	// NO TOCAR hasta la línea 64 , para que puedas hacer los ejercicios 3 y 4!!
	private static String[][] datosEquipos = { // Los valores son ficticios ;-)
			{ "1", "UDLP", "GRAN CANARIA", "19480912" }, { "2", "RMA", "S.BERNABEU", "19030518" },
			{ "3", "BCNA", "NOU CAMPO", "19121021" }, { "4", "ATM", "CALDERON", "19211111" },
			{ "5", "VAL", "MESTALLA", "19120317" } };
	private static Object[][][] datosJugadores = { // en cada fila
			{ // jugadores de la UDLP
					{ "VIERA", "19900712", 1, "20140903", 'A', 21 }, { "AYTHAMI", "19900712", 1, "20140903", 'D', 16 },
					{ "ROQUE", "19900712", 1, "20140903", 'C', 15 }, { "PRINCE", "19910119", 3, "20140903", 'D', 7 },
					{ "VARAS", "19910119", 3, "20140903", 'P', 13 },
					{ "EL ZHAR", "19930223", 4, "20151122", 'A', 8 }, },
			{ // jugadores de RMA
					{ "CRISTIANO", "19900712", 1, "20140903", 'A', 21 },
					{ "BENZEMA", "19900712", 1, "20140903", 'D', 16 }, { "ISCO", "19900712", 1, "20140903", 'C', 15 },
					{ "KROOS", "19910119", 3, "20140903", 'D', 7 }, { "MARCELO", "19910119", 3, "20140903", 'P', 13 },
					{ "BALE", "19930223", 4, "20151122", 'A', 8 }, { "CRISTIANO2", "19900712", 1, "20140903", 'A', 21 },
					{ "BENZEMA2", "19900712", 1, "20140903", 'D', 16 }, { "ISCO2", "19900712", 1, "20140903", 'C', 15 },
					{ "KROOS2", "19910119", 3, "20140903", 'D', 7 }, { "MARCELO2", "19910119", 3, "20140903", 'P', 13 },
					{ "BALE2", "19930223", 4, "20151122", 'A', 8 } },
			// FALTAN MAS EQUIPOS AQUI, PERO NO HACE FALTA QUE LOS PONGAS!!

	};

	public static Equipo[] equipos;
	public static Jugador[][] jugadores; // en cada fila , los jugadores de cada Equipo

	public static void creaListaEquipos() {
		equipos = new Equipo[datosEquipos.length];
		Equipo e = null;
		for (int i = 0; i < datosEquipos.length; i++) {
			e = new Equipo(Integer.parseInt(datosEquipos[i][0]), datosEquipos[i][1], datosEquipos[i][2],
					datosEquipos[i][3]);
			equipos[i] = e;
		}
		return;
	}

	public static void creaListaJugadores() {
		jugadores = new Jugador[datosJugadores.length][];
		for (int i = 0; i < datosJugadores.length; i++) {
			jugadores[i] = new Jugador[datosJugadores[i].length];
			for (int j = 0; j < datosJugadores[i].length; j++) {
				jugadores[i][j] = new Jugador(i * jugadores.length + j + 1, datosJugadores[i][j][0].toString(),
						datosJugadores[i][j][1].toString(), (int) datosJugadores[i][j][2], i + 1,
						datosJugadores[i][j][3].toString(), (char) datosJugadores[i][j][4],
						(int) datosJugadores[i][j][5]);
			}
		}
		return;
	}

	// HASTA AQUI, NO TOCAR!!

	// Ejercicio1: devuelve el mayor en un array de numeros decimales

	public int obtenerPosicionMayor(float[] numeros) {

		int pos = 0;
		for (int i = 0; i < numeros.length; i++) {
			if (pos < numeros[i])
				pos = (int) numeros[i];

		}
		return pos;
	}

	// Ejercicio2: devuelve true/false si hay (o no) repetidos en una lista de
	// enteros

	public boolean hayRepetidos(int[] enteros) {

		boolean b = false;

		for (int i = 0; i < enteros.length - 1; i++)
			for (int j = i + 1; j < enteros.length; j++)
				if (enteros[i] == enteros[j]) {
					b = true;
				}

		return b;
	}
	// Ejercicio 3: devuelve la lista de jugadores de un equipo, cuyo id se pasa
	// como argumento (parámetro)

	public Jugador[] listaJugadoresEquipo(Equipo equipo) {

		return jugadores[equipo.getId() - 1];
	}

	// Ejercicio 4:
	public Equipo getEquipoJugador(int idJugador){
		Equipo e=null;
		// buscamos en jugadores , comparando el id de cada jugador con el que nos llega como parámetro
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores[i].length; j++) {
				if (jugadores[i][j].getId() == idJugador){
					Jugador jugador = jugadores[i][j];
					
					return equipos[jugadores[i][j].getIdEquipo()-1];				
				}
			}
		}
		return null;
	}
	}
