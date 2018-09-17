package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import modelo.Factura;

public class Practicas {

	public ArrayList<Factura> agrupacionObjetos(String rutaFichero) {
		ArrayList<Factura> resultado = new ArrayList<Factura>();

		try {

			FileReader fr = new FileReader("ficheros/facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split("%%");
				String nombre = campos[0];
				int importe = Integer.parseInt(campos[1]);
				char tipo = campos[2].charAt(0);
				String codigo = campos[3];
				Factura fc = new Factura(nombre, importe, tipo, codigo);
				resultado.add(fc);
				System.out.println("\n" + fc);
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

	public HashMap<Character, ArrayList<Factura>> mapaObjetos(String rutaFichero) {
		HashMap<Character, ArrayList<Factura>> resultado = new HashMap<Character, ArrayList<Factura>>();
		ArrayList<Factura> lista = new ArrayList<Factura>();
		try {

			FileReader fr = new FileReader("ficheros/facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {

				String[] campos = linea.split("%%");
				String nombre = campos[0];
				int importe = Integer.parseInt(campos[1]);
				char tipo = campos[2].charAt(0);
				String codigo = campos[3];
				Factura fc = new Factura(nombre, importe, tipo, codigo);
				if (resultado.get(fc.getTipo()) == null) {
					lista = new ArrayList<Factura>();
					resultado.put(fc.getTipo(), lista);
				}

				resultado.get(fc.getTipo()).add(fc);

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

	public void ordenaFacturas(HashMap<Character, ArrayList<Factura>> resultado) {

		Set<Character> claves = resultado.keySet();
		int total = 0;
		for (Character clave : claves) {
			System.out.println("========== Tipo de Factura: " + clave + " ==========");
			System.out.print("Importe");
			System.out.println();
			for (Factura fc : resultado.get(clave)) {
				System.out.print( fc.getValor());
				System.out.println();
				total += fc.getValor();

			}
			System.out.println("------------> Total importe: " + total);
			total = 0;

		}

	}
}
