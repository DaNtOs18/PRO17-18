package principal;

import java.util.ArrayList;
import java.util.HashMap;

import auxiliar.Practicas;
import modelo.Factura;

public class Main {

	public static void main(String[] args) {
		Practicas pr = new Practicas();
		// pr.agrupacionObjetos("ficheros/facturas.txt");
		// HashMap<Character,
		// ArrayList<Factura>>mapa=pr.mapaObjetos("ficheros/facturas.txt");
		pr.ordenaFacturas(pr.mapaObjetos("ficheros/facturas.txt"));
		System.out.println("Fin");

	}

}
