package principal;

import accesoDatos.Operaciones;
import modelo.Libro;

public class Principal {

	public static void main(String[] args) {
		Libro [] libreria = new Libro[15];
		Libro libro1 = new Libro(9962, 'T', "Los muertos", true);
		Libro libro2 = new Libro(7853, 'A', "EL soldado", true);
		Libro libro3 = new Libro(2416, 'F', "Los jinetes", true);
		Libro libro4 = new Libro(5573, 'I', "El detective", false);
		
		libreria[0] = libro1;
		libreria[2] = libro2;
		libreria[7] = libro3;
		libreria[13] = libro4;
		
		Operaciones operaciones = new Operaciones();
		Libro[] estante = operaciones.compactarArray(libreria);
		for (int i = 0; i < estante.length; i++) {
			System.out.println(operaciones.compactarArray(estante)[i].toString());
		}
	}
}
