package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Practicas {

	public HashMap<String, ArrayList<Integer>> puntosLigaEquipos(String ficheroPuntosEquipos) {
		HashMap<String, ArrayList<Integer>> resultado = new HashMap<String, ArrayList<Integer>>();

		try {

			FileReader fr = new FileReader(ficheroPuntosEquipos);
			BufferedReader br = new BufferedReader(fr);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("#");
				String equipo = campos[0];
				int clasif = Integer.parseInt((campos[1]));
				ArrayList<Integer> puntos = new ArrayList<Integer>();
				puntos.add(clasif);

				resultado.put(equipo, puntos);
			}

			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public void imprimirValores(HashMap<String, ArrayList<Integer>> puntosTotalesEquipo) {
		HashMap<String, ArrayList<Integer>> listado = puntosLigaEquipos("ficheros/puntosEquipos.txt");
		System.out.print("\t\t");

		System.out.println();
		Set<String> equipo = listado.keySet();
		for (String string : equipo) {
			listado.get(equipo);
			System.out.print(equipo);

			for (int i = 0; i < listado.size(); i++) {
				listado.get(listado.values());

				System.out.print("\t\t" + listado.values());

				System.out.println();
			}
		}
	}
}
