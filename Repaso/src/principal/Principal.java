package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import auxiliar.Practicas;
import modelo.Persona;

public class Principal {

	public static void main(String[] args) {

		Practicas prac = new Practicas();
		System.out.println("Fecha nacimiento : 20-5-1980. Tienes " + prac.calculaEdad("20051980") + " años.");

		float[] movimientos = { 50, -10, 30 };
		float saldoInicial = 100;
		System.out.println(prac.calculaSaldo(saldoInicial, movimientos));

		float sI = 100.5f;
		ArrayList<Float> mov = new ArrayList<Float>();
		mov.add(50f);
		mov.add(-20f);
		System.out.println(prac.calculaSaldo(sI, mov));

		int[] l1 = new int[] { 2, 7 };
		int[] l2 = new int[] { 3, 8, 15, 24 };
		int[] l3 = prac.mezclaArrays(l1, l2);

		Practicas.grabarObjetosEnFichero("ficheros/estudiantes.obj");

		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		p1.setNombre("Pepeillo");
		p1.setNif("123");
		p2.setNombre("Micifu");
		p2.setNif("321");
		p3.setNombre("Sibili");
		p3.setNif("666");
		HashMap<String, Persona> map = new HashMap();
		map.put(p1.getNif(), p1);
		map.put(p2.getNif(), p2);
		map.put(p3.getNif(), p3);
		Practicas.sortByValue(map);
		System.out.println("FIN");
	}

}
