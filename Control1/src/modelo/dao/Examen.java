package modelo.dao;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import modelo.Libro;

public class Examen {
	// COMENTARIOS DE EXAMEN

	// EJERCICIO 1 : Matriz de enteros aleatorios
	public ArrayList<ArrayList<Integer>> ejercicio1(int nFilas, int nColumnas, int inferior, int superior) {
		ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
		Random rnd = new Random();
		for (int i = 0; i < nFilas; i++) {
			ArrayList<Integer> filaLista = new ArrayList<Integer>();
			for (int j = 0; j < nColumnas; j++) {

				int numero = inferior + rnd.nextInt(superior - inferior + 1);
				filaLista.add(numero);

			}
			resultado.add(filaLista);
		}
		return resultado;
	}

	// EJERCICIO 2 : Ficheros y colecciones
	public HashMap<Integer, Float> cuentas(String rutaFichero) {
		HashMap<Integer, Float> valorCuentas = new HashMap<Integer, Float>();
		try {

			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				int cuenta = Integer.parseInt(linea.split("&")[0]);
				float saldo = Float.parseFloat(linea.split("&")[1]);

				valorCuentas.put(cuenta, saldo);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return valorCuentas;
	}

	public HashMap<Integer, ArrayList<Float>> movimientos(String rutaFichero) {
		HashMap<Integer, ArrayList<Float>> movCuentas = new HashMap<Integer, ArrayList<Float>>();
		int index = 0;
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {

				int cuenta = Integer.parseInt(linea.split("&")[1]);
				float importe = Float.parseFloat(linea.split("&")[2]);
				ArrayList<Float> importes = new ArrayList<Float>();
				importes.add(importe);

				movCuentas.put(cuenta, importes);
			}
			fr.close();// cierra el fichero
			br.close();// cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return movCuentas;
	}

	// EJERCICIO 3 : BASES DE DATOS
	private Connection conexion() {

		String USUARIO = "root";
		String PASS = "";
		String URL_BD = "jdbc:mysql://localhost:3306/jonnyexam";
		try {
			return DriverManager.getConnection(URL_BD, USUARIO, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				System.err.println("VERIFIQUE Si EL DRIVER DE LA BD ESTA EN  CLASSPATH");
			} else {
				System.err.println("ESTA ARRANCANDO MYSQL ?, lAS CREDENCIALES ESTÁN BIEN ?");
			}
			System.exit(0);
			// el programa termina y devuelve el control al S.O.
			return null;
		}
	}
	// EJERCICIO 3 : BASES DE DATOS y colecciones

	public HashMap<Integer, ArrayList<Libro>> getLibrosPorTemas() {

		try {
			HashMap<Integer, ArrayList<Libro>> registros = new HashMap<Integer, ArrayList<Libro>>();
			Connection conexion = this.conexion();
			String sql = "SELECT * FROM  libros";
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			rs.first();
			if (rs.getRow() == 0) {
				System.out.println("NO HAY REGISTROS");

				stm.close();
				rs.close();
				return null;
			} else
				rs.beforeFirst();
			while (rs.next()) {
				HashMap<Integer, Object> registro = new HashMap<Integer, Object>();

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
