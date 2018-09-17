package accesoDatos;

import modelo.Libro;


public class Operaciones {
private Libro[] reduccion;
public Libro[] compactarArray(Libro[] libreria) {
	int count = 0;
	for (int i = 0; i < libreria.length; i++) {

		if (libreria[i] != null) {
			;
			count++;
		}
	}
	reduccion = new Libro[count];
	count = 0;
	for (int k = 0; k < libreria.length; k++) {
		if (libreria[k] != null) {
			reduccion[count++] = libreria[k];
		}
	}
	return reduccion;

}
}

