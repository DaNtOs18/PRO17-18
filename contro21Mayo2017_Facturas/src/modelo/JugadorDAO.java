package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class JugadorDAO {
	
	
	public  HashMap<Integer, ArrayList<Jugador>> leerJugadoresDao() {
		 HashMap<Integer, ArrayList<Jugador>> equipos = new  HashMap<Integer, ArrayList<Jugador>>();
		try {
			FileInputStream fis = new FileInputStream("ficheros/jugadores.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Jugador> jugadorDelEquipo = null;

			while (fis.available() > 0) {
				Jugador unJugador = (Jugador) ois.readObject();
				if (equipos.get(unJugador.getEquipo()) == null) {
					jugadorDelEquipo = new ArrayList<Jugador>();
					equipos.put(unJugador.getEquipo(),jugadorDelEquipo);
				}
				//jugadorDelEquipo.add(unJugador);
				
				equipos.get(unJugador.getEquipo()).add(unJugador);
				//equipos.put(unJugador.getEquipo(),jugadorDelEquipo);
				//equipos.put(unJugador.getEquipo(),equipos.get(unJugador).add(unJugador));
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
	

}
