package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AccesoDatos {

	private String usuario;
	private String clave;
	private String host;
	private String bd;

	public AccesoDatos() {
		super();
	}

	public Connection conexionMySQL(String dominio, String bd, String usr, String clave) {
		try {
			String url = "jdbc:mysql://" + dominio + "/" + bd;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, usr, clave);
			System.out.println("¡¡Has conectado con la bbdd!!");
			return con;
		} catch (InstantiationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("¡¡No has conectado con la bbdd!!");
		return null;

	}

	public ArrayList<HashMap<String, Object>> getAllRecords(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexionMySQL(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
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
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					registro.put(metaData.getColumnName(i), rs.getString(i));
					System.out.println(metaData.getColumnName(i) + " => " + rs.getString(i));
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ArrayList<HashMap<String, Object>> select(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexionMySQL(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
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
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					registro.put(metaData.getColumnName(i), rs.getString(i));
					System.out.println(metaData.getColumnName(i) + " => " + rs.getString(i));
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ArrayList<HashMap<String, Object>> insert(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexionMySQL(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
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
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					registro.put(metaData.getColumnName(i), rs.getString(i));
					System.out.println(metaData.getColumnName(i) + " => " + rs.getString(i));
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ArrayList<HashMap<String, Object>> update(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexionMySQL(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
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
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					registro.put(metaData.getColumnName(i), rs.getString(i));
					System.out.println(metaData.getColumnName(i) + " => " + rs.getString(i));
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ArrayList<HashMap<String, Object>> delete(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexionMySQL(dominio, bd, usr, clave);
			String sql = "SELECT * FROM " + tabla;
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
				HashMap<String, Object> registro = new HashMap<String, Object>();
				registros.add(registro);

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					registro.put(metaData.getColumnName(i), rs.getString(i));
					System.out.println(metaData.getColumnName(i) + " => " + rs.getString(i));
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void conexionSQLite() {
		Connection conn = null;
		try {

			String url = "jdbc:sqlite:C:\\Users\\jonat\\Documents\\DAW\\BAE\\tabla_sqlite_pro.db";
			// Crear la conexión
			conn = DriverManager.getConnection(url);

			System.out.println("Conexión a SQLite establecida.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public static void conexionPostgre() {
		try {

			Class.forName("org.postgresql.Driver");

			} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return;

			}

			System.out.println("PostgreSQL JDBC Driver Registered!");

			Connection connection = null;

			try {

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
			"1234");

			} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

			}

			//sql = connection.createStatement();

			if (connection != null) {

			//sqlStatement("INSERT INTO TESTTABLE (product_id,product_name,) VALUES(1,  ‘product1’)");
			System.out.println("Successfully Connected");

			} else {

			System.out.println("Failed to make connection!");
			}
			}
			

	}

	/*
	 * public ArrayList<ArrayList<Object>> getAllRecords2(String dominio, String bd,
	 * String usr, String clave, String tabla) {
	 * 
	 * try { ArrayList<ArrayList<Object>> registros = new
	 * ArrayList<ArrayList<Object>>(); Connection conexion = this.conexion(dominio,
	 * bd, usr, clave); String sql = "SELECT * FROM " + tabla; Statement stm =
	 * conexion.createStatement(); ResultSet rs = stm.executeQuery(sql);
	 * ResultSetMetaData metaData = rs.getMetaData(); ArrayList<Object> registro =
	 * new ArrayList<Object>(); registros.add(registro); for (int i = 0; i <=
	 * metaData.getColumnCount(); i++) { registro.add(rs.getString(i));
	 * 
	 * while (rs.next()) { ArrayList<Object> registro2 = new ArrayList<Object>();
	 * registros.add(registro2); for (int i = 0; i <= metaData.getColumnCount();
	 * i++) { registro.add(rs.getString(i));
	 * System.out.print(metaData.getColumnName(i) + " =>" + rs.getString(i) + "\t");
	 * } System.out.println(rs.getString("ISBN"));
	 * System.out.println(rs.getString("Nombre")); } stm.close(); rs.close(); return
	 * registros; } catch (SQLException e) { System.out.println(e.getMessage()); }
	 * return null; }
	 */


