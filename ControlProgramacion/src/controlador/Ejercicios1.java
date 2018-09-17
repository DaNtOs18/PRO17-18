package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Libro;

public class Ejercicios1 {
	// Ejercicio 1 (1 PUNTO)
	// Leer el enunciado, interpretarlo y poner el código AQUI

	public void fibonacci(int n) {
		float a, b, c;
		a = 0;
		b = 1;

		int i = 0;
		while (i < n) {
			c = a + b;
			System.out.print(c + ", " + "\n");
			a = b;
			b = c;
			i++;
		}

	}

	// Ejercicio 2 ( 1,5 puntos)
	public void listarPrimos(int cuantos) {
		// int contador = 0;
		int candidato = 1;
		// while (contador < cuantos) {
		for (int contador = 0; contador < cuantos; contador++) {
			if (esPrimo(candidato))
				System.out.println(candidato);
			candidato++;

		}

	}

	public boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				// System.out.println(numero + " NO es primo !!" + i);

				return false;
			}

		}
		// System.out.println(numero + " es primo !!");
		return true;

	}

	// Ejercicio 3 ( 1,5 puntos)
	// Leer el enunciado, interpretarlo y poner el código AQUI
	public boolean busquedaBinaria(int buscado, int[] enterosOrdenados) {
		int inferior = 0;
		int superior = enterosOrdenados.length;
		int medio = (superior - inferior) / 2;
		while (inferior < superior) {
			medio = inferior + (superior - inferior) / 2;
			System.out.println("medio : " + medio );
			if (buscado < enterosOrdenados[medio])
				superior = medio ; 
			else if (buscado > enterosOrdenados[medio])
				inferior = medio+1;
			else {
				System.out.println("encontrado");
				return true;
			}
		}
		System.out.println("NO encontrado");
		return false;
	}

	public Connection conexion() {

		try {
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examenfinal", "root", "elrincon");
			return con;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	// Ejercicio 4 ( 3,5 puntos)
	// insertar registros en una tabla, procedentes de un fichero
	public void copiaFicheroFacturasTabla(String rutaFichero) {

	}
	// Ejercicio 5 ( 3,5 puntos)
	// Procesar el fichero de libros

	public HashMap<Integer, ArrayList<Libro>> getLibrosPorEditorial(String rutaFichero) {

		return null;
	}
}
