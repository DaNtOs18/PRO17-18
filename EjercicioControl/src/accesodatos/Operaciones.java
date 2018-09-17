package accesodatos;

import modelo.Vivienda;

public class Operaciones {
	private Vivienda[] viviendas;

	public void cargarViviendas() {
		//
		Vivienda vivienda1 = new Vivienda();
		Vivienda vivienda2 = new Vivienda();
		Vivienda vivienda3 = new Vivienda();

		viviendas = new Vivienda[100];
		// asignar viviendas al array
		viviendas[4] = vivienda1;
		viviendas[40] = vivienda2;
		viviendas[99] = vivienda3;

	}

	public void listarArrayViviendas() throws NullPointerException {
		for (int i = 0; i < viviendas.length; i++) {
			if (viviendas[i] != null)
				// try {
				System.out.println(viviendas[i].getId());
			// System.out.println("AQUI");
			// } catch (ArithmeticException e) {

			// }
			// catch (NullPointerException e) {
			// System.out.println((i+1) + " null");
			// }
			// catch (Exception e) {

			// }
			/*
			 * finally { System.out.println((i+1) + " finally"); }
			 */

		}

	}

	public Vivienda[] compactarArray() {
		// contar los no null
		int contador = 0;
		for (Vivienda vivienda : viviendas) {
			if (vivienda != null)
				contador++;
		}
		// crear array de salida con contador elementos
		Vivienda[] resultado = new Vivienda[contador];

		// copiar los no null en el array resultado
		int j = 0;
		for (int i = 0; i < viviendas.length; i++) {
			if (viviendas[i] != null)
				resultado[j++] = viviendas[i];
		}
		return resultado;
	}
}
