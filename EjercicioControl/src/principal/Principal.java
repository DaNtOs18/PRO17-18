package principal;

import accesodatos.Operaciones;
import modelo.Vivienda;

public class Principal {
	public static void main(String[] args) {
		Operaciones oper = new Operaciones();

		oper.cargarViviendas();

		oper.listarArrayViviendas();
		
		Vivienda[] salida = oper.compactarArray();
		System.out.println("FIN");

	}
}
