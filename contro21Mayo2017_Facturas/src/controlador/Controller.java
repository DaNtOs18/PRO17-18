package controlador;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Jugador;
import modelo.JugadorDAO;
import vista.View;

public class Controller {

	View miVista = new View();
	JugadorDAO miJugador = new JugadorDAO();
	
	public HashMap<Integer, ArrayList<Jugador>> leerJugadores() {
		HashMap<Integer, ArrayList<Jugador>> equipos = miJugador.leerJugadoresDao();
		return equipos;
	}
	
	
	public void mostrarJugadoresDAO() {
		miVista.mostrarJugadoresView(leerJugadores());
	}
	
	public static int calculaEdad(LocalDate fechaNacimiento) {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, ahora);	
		//return  periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días.";
		return periodo.getYears();
	}
}
