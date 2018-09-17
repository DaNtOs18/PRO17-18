package application;

import java.util.ArrayList;
import java.util.HashMap;

import control.Ejercicios2;

public class Principal {

	public static void main(String[] args) {
		Ejercicios2 ej = new Ejercicios2();
		String[] claves = { "1", "2", "3", "4", "5" };
		String[] valores = { "10", "20", "30", "40", "50" };
		ArrayList<HashMap<String, String>> lista = ej.creaDatos(claves, valores);
		ArrayList<HashMap<String, String>> lista2 = ej.creaDatos2(claves, valores);

		String[] islas = { "Isla1", "Isla2", "Isla3" };
		int[][] visitantes = { { 1, 2, 8, 7, 5, 32 }, { 6, 5, 4, 3, 2, 1 }, { 9, 8, 7, 6, 5, 5 } };
		ArrayList<HashMap<Integer, Integer>> lista3 = ej.creaDatos3(islas, visitantes);

		System.out.println("Fin");
	}

}
