package examen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import auxiliar.Practicas;
import modelo.Vehiculo;

public class Metodos {

	// ejercicio 1
	public boolean[] metodo1(String[] nifs) {
		boolean[] validos = new boolean[nifs.length];
		Practicas practicas = new Practicas();
		for (int i = 0; i < validos.length; i++) {
			validos[i] = practicas.validarNif(nifs[i]);
		}
		return validos;

	}

	// ejercicio 2
	public Vehiculo[] metodo2(String[] lista) {
		Vehiculo[] vehiculos = new Vehiculo[lista.length];

		for (int i = 0; i < lista.length; i++) {

			try {
				Vehiculo coche = new Vehiculo();
				String[] campos = lista[i].split("@");
				int id = Integer.parseInt(campos[0]);
				String marca = campos[1];
				String modelo = campos[2];
				float precio = Float.parseFloat(campos[3]);
				coche.setId(id);
				coche.setMarca(marca);
				coche.setModelo(modelo);
				coche.setPrecio(precio);

				vehiculos[i] = coche;
			} catch (NumberFormatException e) {

				lista[i] = null;
			}

		}
		return vehiculos;

	}

	public int[][] metodo3(int partidas, int jugadores) {
		int[][] resultado = new int[partidas][jugadores];
		Random rnd = new Random();
		for (int i = 0; i < partidas; i++) {

			for (int j = 0; j < jugadores; j++) {

				resultado[i][j] = 1 + rnd.nextInt(6 - 1 + 1);

			}

		}
		return resultado;

	}
}
