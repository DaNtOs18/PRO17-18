package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Examen {
	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

	public boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				// System.out.println(numero + " NO es primo !!" + i);

				return false;
			}

		}

		return true;

	}

	public int[] generarPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int candidato = 1;

		for (int contador = 0; contador < cuantos; contador++) {
			if (esPrimo(candidato))
				primos[contador] = candidato;
			candidato++;

		}
		return primos;
	}

	public int busquedaBinaria(int buscado, int[] enterosOrdenados) {
		int posicion = 0;
		int inferior = 0;
		int superior = enterosOrdenados.length;
		int medio = (superior - inferior) / 2;
		while (inferior < superior) {
			medio = inferior + (superior - inferior) / 2;

			if (buscado < enterosOrdenados[medio])
				superior = medio;
			else if (buscado > enterosOrdenados[medio])
				inferior = medio + 1;
			else {

				posicion = 0 + medio;

			}
		}

		return posicion - 1;
	}

	public Connection conexion() {

		try {
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/controlpro14mayo", "root", "");
			return con;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public Connection conexion2() {

		try {
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facturas", "root", "");
			return con;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public void copiaFicheroFacturasTabla(String rutaFichero) {

		try {

			FileReader fr = new FileReader("ficheros/facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split("#");
				int v1 = Integer.parseInt(campos[0]);
				String[] fechaCadena = campos[1].split("-");
				int year = Integer.parseInt(fechaCadena[0]);
				int month = Integer.parseInt(fechaCadena[1]);
				int day = Integer.parseInt(fechaCadena[2]);
				LocalDate v2 = LocalDate.of(year, month, day);
				int v3 = Integer.parseInt(campos[2]);
				float v4 = Float.parseFloat(campos[3]);

				String sentencia = "INSERT INTO facturas VALUES (" + v1 + "," + v2 + "," + v3 + "," + v4 + ")";

				Connection conexion = this.conexion();
				Statement stm = conexion.prepareStatement(sentencia);
				int rs = stm.executeUpdate(sentencia);

			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public HashMap<Integer, ArrayList<Libro>> getLibrosPorEditorial(String rutaFichero) {
		HashMap<Integer, ArrayList<Libro>> resul = new HashMap<Integer, ArrayList<Libro>>();

		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split("&&");
				if (resul.get(Integer.parseInt(campos[2])) == null)
					resul.put(Integer.parseInt(campos[2]), new ArrayList<Libro>());
				ArrayList<Libro> libros = new ArrayList<Libro>();
				Libro libro = new Libro();
				String titulo = campos[3];
				libro.setTitulo(titulo);
				libros.add(libro);

				resul.put(Integer.parseInt(campos[2]), libros);
				resul.get(Integer.parseInt(campos[2])).add(libro);

			}
			fr.close();// cierra el fichero
			br.close();// cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return resul;
	}

	public void generarDatosFactura() {

		try {
			Connection conexion2 = this.conexion2(); // Creamos conexion
			Statement stm = conexion2.createStatement(); // Creamos statement
			String sen = "SELECT * FROM order_details order by id"; // Creamos la sentencia
			ResultSet rs = stm.executeQuery(sen); // Lanzamos la consulta

			float subTotal = 0;
			float total = 0;
			double order_id_anterior; // Campo de control por el que nos guiaremos para agrupar

			while (rs.next()) { // Iteramos el rs
				double order_id = rs.getDouble(7); // Podemos poner el numero de la columna...
				String titulo = rs.getString("title"); // ...o bien, el nombre de ella
				float precio = rs.getFloat("price");
				int cantidad = rs.getInt(5);
				float totalLinea = precio * cantidad;

				double order_id_ant = 99999;

				if (order_id != order_id_ant) {
					System.out.println();
					
				}
				System.out.println(order_id + " : " + titulo + "\t" + precio + "\t" + cantidad + "\t" + totalLinea);
				subTotal += totalLinea;
			}
			stm.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
