package accesoDatos;

public class Operaciones {

	public static int cadenasAnumeros(String cadena) {

		int numero;

		return numero = Integer.parseInt(cadena);
	}

	public static String numerosAcadenas(int numero) {

		String cadena;

		// return cadena = String.valueOf(numero); Usar cualquiera de los dos

		return cadena = Integer.toString(numero);
	}

	public static String invierteCadenas(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--)

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		return cadenaInvertida;

	}

	public static int cuentaPalabras(String cadena) {

		int cuantas;
		
		cuantas = cadena.length();
		
		return cuantas;
	}

	public static void sumaDiagonal(int[][] matriz) {

	}

	public static void maximo(int[] array) {

	}

	public static void maximo(int[][] matriz) {

	}
}
