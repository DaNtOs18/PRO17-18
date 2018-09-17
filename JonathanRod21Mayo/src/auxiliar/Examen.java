package auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import modelo.Jugador;

public class Examen {
	public static int calculaEdad(LocalDate fechaNacimiento) {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, ahora);
		// return periodo.getYears() + " años, " + periodo.getMonths() + " meses, " +
		// periodo.getDays() + " días.";
		return periodo.getYears();
	}

	/*
	 * public ArrayList<Jugador> leeObjetosDesdeFichero(String fichero) {
	 * ArrayList<Jugador> lista = new ArrayList<Jugador>(); try { FileInputStream
	 * fIs = new FileInputStream(fichero); ObjectInputStream fObj = new
	 * ObjectInputStream(fIs);
	 * 
	 * Jugador jug = new Jugador();
	 * 
	 * while (fIs.available() > 0) { jug = (Jugador) fObj.readObject();
	 * lista.add(jug); }
	 * 
	 * fIs.close(); fObj.close();
	 * 
	 * } catch (FileNotFoundException e) {
	 * System.out.println("Fichero no encontrado"); } catch (IOException e) {
	 * System.out.println("Error IO"); } catch (ClassNotFoundException e) {
	 * System.out.println("ClassNotFound"); }
	 * 
	 * return lista; }
	 */

	public HashMap<Integer, ArrayList<Jugador>> leerJugadoresDao() {
		HashMap<Integer, ArrayList<Jugador>> equipos = new HashMap<Integer, ArrayList<Jugador>>();
		try {
			FileInputStream fis = new FileInputStream("ficheros/jugadores.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Jugador> jugadorDelEquipo = null;

			while (fis.available() > 0) {
				Jugador unJugador = (Jugador) ois.readObject();
				if (equipos.get(unJugador.getEquipo()) == null) {
					jugadorDelEquipo = new ArrayList<Jugador>();
					equipos.put(unJugador.getEquipo(), jugadorDelEquipo);
				}
				// jugadorDelEquipo.add(unJugador);

				equipos.get(unJugador.getEquipo()).add(unJugador);
				// equipos.put(unJugador.getEquipo(),jugadorDelEquipo);
				// equipos.put(unJugador.getEquipo(),equipos.get(unJugador).add(unJugador));
			}

			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}

	public void ordenaJugadores(HashMap<Integer, ArrayList<Jugador>> equipos) {

		String[] nombreEquipos = { "Real Madrid", "Barcelona", "Sevilla" };
		int totalGoles = 0;
		int sumaEdad = 0;
		int edad = 0;
		int contador = 0;
		for (Integer equipo : equipos.keySet()) {
			System.out.println("========== EQUIPO: " + nombreEquipos[equipo] + " ==========");
			System.out.printf("%-10s", "NOMBRE");
			System.out.printf("%-25s", "FECHA NACIMIENTO");
			System.out.printf("%-20s", "GOLES");
			System.out.printf("%-10s", "EDAD");
			System.out.println();
			for (Jugador unJugador : equipos.get(equipo)) {
				System.out.printf("%-10s", unJugador.getNombre());
				System.out.printf("%-25s", unJugador.getFecha());
				System.out.printf("%-20s", unJugador.getGolesMarcados());
				edad = calculaEdad(unJugador.getFecha());
				System.out.printf("%-10s", calculaEdad(unJugador.getFecha()));
				System.out.println();
				totalGoles = totalGoles + unJugador.getGolesMarcados();
				sumaEdad = edad + sumaEdad;
				contador++;
			}
			System.out.println("------------> TOTAL GOLES EQUIPO: " + totalGoles);
			System.out.println("------------> EDAD MEDIA EQUIPO: " + sumaEdad / contador + "\n\n");
		}

	}

}
