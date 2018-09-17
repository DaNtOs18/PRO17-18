package principal;

import auxiliar.Metodos;
import modelo.dao.AccesoDatos;

public class Principal {

	public static void main(String[] args) {
		Metodos md = new Metodos();
		AccesoDatos ad = new AccesoDatos();
		ad.conexionSQLite();
		//Dominio+BD+Usuario+Clave+Tabla
		md.mantenimientoMySQL();
		// String sql = "SELECT * FROM " + tabla;
		ad.select("localhost", "DirectoresDespachos", "root", "", "directores");
	}

}
