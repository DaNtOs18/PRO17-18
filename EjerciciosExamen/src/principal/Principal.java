package principal;

import accesoDatos.Operaciones;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println(Operaciones.cadenasAnumeros("123"));
		System.out.println(Operaciones.numerosAcadenas(153));
		System.out.println(Operaciones.invierteCadenas("capitan"));
		System.out.println(Operaciones.cuentaPalabras("primitivo"));
	}
}
