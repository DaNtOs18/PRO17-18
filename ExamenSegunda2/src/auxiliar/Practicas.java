package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Practicas {
//*****************************************leerFicheroTextoAsignaturasArrayList*****************************************
	public  String[] leerFicheroTextoAsignaturasToArray(String rutaFichero) {
		String[] asignaturas = null;
		int index = 0;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			// Leer el fichero linea a linea
			linea = br.readLine();
				 asignaturas = linea.split(",");
			//asignaturas = br.readLine().split(",");**************es lo mismo.					
			
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return asignaturas;
	}
//*************************************leerFicheroNotas****************************	
	
	public HashMap<String,ArrayList<Integer>> leerFicheroNotas(String rutaFichero){
		HashMap<String,ArrayList<Integer>> notasFinalesAlumnos = new HashMap<String,ArrayList<Integer>>();
		int index = 0;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String estudiante = linea.split("#")[0];
				String notas = linea.split("#")[1];
				String[] calificaciones = notas.split(",");
				ArrayList<Integer> calificacionesFinales = new ArrayList<Integer>();
				for (int indCalif = 0; indCalif < calificaciones.length; indCalif++) {
					int valorCalif = Integer.parseInt(calificaciones[indCalif]);
					calificacionesFinales.add(valorCalif);
					}
				notasFinalesAlumnos.put(estudiante, calificacionesFinales);//***aqui se optimiza el rendimiento.
			}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	
	return notasFinalesAlumnos;
	}

	
	public void imprimirValores(String[] asignaturas,HashMap<String,ArrayList<Integer>> notasFinalesAlumnos) {
		System.out.print("\t\t");
		for (int i = 0; i < asignaturas.length; i++) {
			System.out.print("\t    " + asignaturas[i]);
		}
		System.out.println();
		Set<String> nombreAlumnos = notasFinalesAlumnos.keySet();
		
		for (String nombre : nombreAlumnos) {
			ArrayList<Integer> notasAlumnos = notasFinalesAlumnos.get(nombre);
			System.out.print(nombre );
			
			
			
			for (int i = 0; i < notasAlumnos.size(); i++) {
				Integer notaAsignaturaAlumno = notasAlumnos.get(i);
				System.out.print("\t\t" +notaAsignaturaAlumno);
			}
			System.out.println();
		}
		
	
	}	
	
}














