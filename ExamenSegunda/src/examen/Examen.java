package examen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Examen {
	public HashMap<String, ArrayList<Integer>> getNotas(String ficheroNotas) {
		HashMap<String, ArrayList<Integer>> notas = new HashMap<String, ArrayList<Integer>>();

		try {
			// Abrir el fichero
			FileReader fr = new FileReader(ficheroNotas);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split("#");
				String clave = campos[0];
				String[] notasString = campos[1].split(",");
				ArrayList<Integer> valor = new ArrayList<Integer>();
				for (String nt : notasString)
					valor.add(Integer.parseInt(nt));
				notas.put(clave, valor);

			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return notas;
	}

	public ArrayList<String> getAsignaturas(String ficheroAsignaturas) {
		ArrayList<String> asignaturas = new ArrayList<String>();
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(ficheroAsignaturas);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {

				String[] asigs = linea.split(",");
				for (String asig : asigs) {
					asignaturas.add(asig);
				}

			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return asignaturas;
	}

	public void listado() {

		ArrayList<String> asignaturas = getAsignaturas("ficheros/asignaturas.txt");
		HashMap<String, ArrayList<Integer>> notas = getNotas("ficheros/notasAlumnos.txt");
		Set<String> claves = notas.keySet();
		System.out.print("\t\t\t");
		for (String asignatura : asignaturas)
			System.out.print(asignatura + "\t");
		System.out.println("");
		int[] notaMediaAsignaturas = new int[asignaturas.size()];

		for (String clave : claves) {
			System.out.print(clave + " :  \t");
			ArrayList<Integer> listaNotasAlumno = notas.get(clave);
			int acum = 0;
			for (int i = 0; i < listaNotasAlumno.size(); i++) {
				System.out.print(listaNotasAlumno.get(i) + ",\t");
				acum += listaNotasAlumno.get(i);
				notaMediaAsignaturas[i] += listaNotasAlumno.get(i);
			}
			System.out.println("\t\t"+(float) acum / listaNotasAlumno.size());
			System.out.println("");
		}
		System.out.print(" \t\t\t\t");
		for (int notaMediaAsignatura : notaMediaAsignaturas)
			System.out.print((float) notaMediaAsignatura / notas.size()+ ",\t");
		System.out.println();
	}

	public static void main(String[] args) {
		Examen examen = new Examen();
		examen.listado();
		System.out.println("FIN");
	}
	/*
	EXAMEN*

	PRINCIPAL

	package principal;


	import java.util.ArrayList;

	import examenSegunda.Examen;



	public class PrincipalExamen {
		// metodo por el que debe empezar la ejecución ..
		public static void main(String[] args) {
			Examen examen = new Examen();
		//	examen.leerFicheroAsignatura();
			
			//examen.leerFicheroAlumno();
			
			String[] asignaturas = examen.leerFicheroAsignatura();
			ArrayList<String>alumnos = examen.leerFicheroAlumno();
			ArrayList<String>nota = examen.leerFicheroAlumno();
			
			
			examen.mostrarAlumnosEnConsola(asignaturas, alumnos);
			
			
		}

	}



	PRACTICAS:


	package examenSegunda;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Iterator;

	public class Examen {
		public String[] leerFicheroAsignatura() {
			int index = 0;
			String[] asignaturas = new String [5];
			try {
				// Abrir el fichero
				FileReader fr = new FileReader("ficheros/asignaturas.txt");
				BufferedReader br = new BufferedReader(fr);
				String linea;
				// System.out.println(LocalDate.now());
				// Leer el fichero linea a linea
				while ((linea = br.readLine()) != null) {

					String[] campos = linea.split(",");
					for (int i = 0; i < campos.length; i++) {
						asignaturas[i]=campos[i];
					}
						
					
					

				}
				fr.close();
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return asignaturas;		
		}
		
		public ArrayList<String> leerFicheroAlumno(){
			ArrayList<String> alumnoFinal = new ArrayList<String>();
			
			try {
				// Abrir el fichero
				FileReader fr = new FileReader("ficheros/notasAlumnos.txt");
				BufferedReader br = new BufferedReader(fr);
				String linea;
				
				// Leer el fichero linea a linea
				while ((linea = br.readLine()) != null) {

					String[] campos = linea.split("#");
					String nombreAlumno=campos[0];
					String[] romperNota = campos[1].split(",");
					
					char notaLenguaje = campos[1].charAt(0);
					char notaMatematica = campos[1].charAt(2);
					char notaFisica = campos[1].charAt(4);
					char notaHistoria = campos[1].charAt(6);
					char notaQuimica = campos[1].charAt(8);
					String notaAlumno = (notaLenguaje+" "+notaMatematica+" "+notaFisica+" "+notaHistoria+" "+notaQuimica+" ");
					alumnoFinal.add(nombreAlumno);
					alumnoFinal.add(notaAlumno);						
				}
				fr.close();
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return alumnoFinal;		
		}
		public void mostrarAlumnosEnConsola(String[] asignaturas,ArrayList<String> alumnos) {
			
			System.out.println("\t\t\t\t"+"NOTAS ALUMNOS IES EL RINCÓN"+"\n");
			String[] resultadoAsignaturas = asignaturas;
			ArrayList<String> resultadoAlumnos = alumnos;
			for (int i = 0; i < resultadoAsignaturas.length; i++) {

				System.out.print("\t\t"+resultadoAsignaturas[i]);
			}
		
			for (int i = 0; i < resultadoAlumnos.size(); i++) {
				for (int j = 0; j < resultadoAlumnos.size(); j++) {
					
				}

				System.out.println("\n"+resultadoAlumnos.get(i));
			
				}	
			}
		}

*/

}
