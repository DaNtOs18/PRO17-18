package examen;

import java.util.Random;

import auxiliar.Practicas;
import modelo.Vehiculo;

public class Metodos {

	// ejercicio 1

	public boolean[] metodo1(String[] nifs) {

		boolean[] result = new boolean[nifs.length];
		Practicas practicas = new Practicas();
		for (int i = 0; i < result.length; i++) {
			result[i] = practicas.validarNif(nifs[i]);
		}
		return result;

	}

	// ejercicio 2

	public Vehiculo[] metodo2(String[] vehiculos) {
		Vehiculo[] result = new Vehiculo[vehiculos.length];

		for (int i = 0; i < vehiculos.length; i++) {
			Vehiculo vehiculo;

			try {
				String campos[] = vehiculos[i].split("@");
				vehiculo = new Vehiculo();
				vehiculo.setId(Integer.parseInt(campos[0]));
				vehiculo.setMarca(campos[1]);
				vehiculo.setModelo(campos[2]);
				vehiculo.setPrecio(Float.parseFloat(campos[3]));
				result[i] = vehiculo;
			} catch (NumberFormatException e) {
				vehiculos[i] = null;
			}
		}
		return result;
	}

	// ejercicio 3

	public int[][] metodo3(int partidas, int jugadores) {
		int[][]result = new int[partidas][jugadores];
		Random rnd = new Random();
		for (int i = 0; i < partidas; i++) {
			for (int j = 0; j < jugadores; j++) {
				result[i][j]=1+rnd.nextInt(6);
			}
		}
		return result;
	}

}
