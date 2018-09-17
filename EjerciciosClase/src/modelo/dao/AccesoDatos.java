package modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoDatos {
	private String usuario;
	private String clave;
	private String host;
	private String bd;

	public AccesoDatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void connect() {
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:C:\\Users\\Jonny\\Documents\\DAW\\BAE\\tabla_sqlite_pro.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

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

	public Connection conexion(String dominio, String bd, String usr, String clave) {
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
		System.out.println("¡¡NO has conectado con la bbdd!!");
		return null;

	}

	public void creaTablaEnterosXXX(int cuantos) {
		try {

			int inferior = 10;
			int superior = 100;
			int numero;
			Random rnd = new Random();
			for (int i = 0; i < cuantos; i++) {

				numero = (inferior + rnd.nextInt(superior - inferior + 1));

				String sentencia = "INSERT INTO facturas (numerosaleatorios) values (" + numero + ");";
				Connection conexion = this.conexion("localhost", "piezasproveedores", "root", " ");
				Statement stm = conexion.prepareStatement(sentencia);
				int rs = stm.executeUpdate(sentencia);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<HashMap<String, Object>> getAllRecords(String dominio, String bd, String usr, String clave,
			String tabla) {

		try {
			ArrayList<HashMap<String, Object>> registros = new ArrayList<HashMap<String, Object>>();
			Connection conexion = this.conexion(dominio, bd, usr, clave);
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

	public void consultaPadronCAProvincias() {

		try {

			Connection conexion = this.conexion("localhost", "paro", "root", "");
			String sql = "select CA as Comunidad, provincia, sum(padron) as padron from padron pa inner join provincias p1, comunidadesautonomas c1, municipios m1 "
					+ " where pa.CodMunicipio = m1.CodMunicipio and m1.CodProvincia = p1.CodProvincia and p1.CodCA = c1.CodCA group by p1.CodProvincia order by c1.CA, p1.Provincia";
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			int subtotal = 0;
			int total = 0;
			String ca_ant = "";
			while (rs.next()) {
				// System.out.println(rs.getString(1) + ", " + rs.getString(2) + " = " +
				// rs.getString(3));

				if (!rs.getString(1).equals(ca_ant) && !ca_ant.equals("")) {

					total += subtotal;
					subtotal = 0;
					ca_ant = rs.getString(1);

					System.out.println("Total padrón CCAA : " + rs.getString(1) + "=" + subtotal);
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * public void consultaPadronComunidadAutonomaProvincia() { try { Connection
		 * conexion = this.conexion("localHost", "paro", "root", ""); String sql =
		 * "SELECT provincias.CodCA, comunidadesautonomas.CA, municipios.codProvincia, provincia, sum(padron)"
		 * +
		 * "  from municipios LEFT JOIN padron on municipios.CodMunicipio = padron.CodMunicipio"
		 * +
		 * "  LEFT JOIN provincias on municipios.CodProvincia = provincias.CodProvincia"
		 * +
		 * "  LEFT JOIN comunidadesautonomas on provincias.CodCA = comunidadesautonomas.CodCA "
		 * + "  GROUP BY CodProvincia, provincia, CA order by CA, provincia" ; Statement
		 * stm = conexion.createStatement(); ResultSet rs = stm.executeQuery(sql); int
		 * caTotal = 0; int total=0; String ca_ant=""; rs.first(); while(rs.next()) {
		 * if(!rs.getString(1).equals(ca_ant)) System.out.println("comunidadATotal:"+
		 * ca_ant+caTotal); total+=caTotal; ca_ant=rs.getString(1);
		 * 
		 * 
		 * 
		 * System.out.println("CA:"+rs.getString(1)+"\t"+"Comunidad:"+rs.getString(2)+
		 * "\t"+"=>"+ rs.getInt(3));
		 * 
		 * caTotal+= rs.getInt(3); }
		 * 
		 * 
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * /* public ArrayList<ArrayList<Object>> getAllRecords2(String dominio, String
		 * bd, String usr, String clave, String tabla) {
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

	}
}
