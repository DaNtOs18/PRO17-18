package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Examen;
import modelo.Libro;

public class Principal {

	public static void main(String[] args)  {
		Examen ex = new Examen();

		int[] numeros = ex.numerosFibonacci(6);

		int[] primos = ex.generarPrimos(6);

		int buscado = 3;
		int[] enterosOrdenados = { 1, 2, 3, 4, 5 };
		//int pos = ex.busquedaBinaria(buscado, enterosOrdenados);

		//ex.copiaFicheroFacturasTabla("ficheros/facturas.txt");
			
		HashMap<Integer, ArrayList<Libro>> resultado=ex.getLibrosPorEditorial("ficheros/libros.csv");
		
		System.out.println("Fin");

	}

}
