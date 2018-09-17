package accesoDatos;

public class Operaciones {

	public static void calculos(int numero, int numero2) {

		System.out.println("La suma de " + numero + " y " + numero2 + " es " + (numero + numero2));
		System.out.println("La resta de " + numero + " y " + numero2 + " es " + (numero - numero2));
		System.out.println("La multiplicación de " + numero + " y " + numero2 + " es " + (numero * numero2));
		System.out.println("La división de " + numero + " y " + numero2 + " es " + (numero / numero2));

	}

	public static void comparaNumeros(int numero, int numero2) {

		if (numero >= numero2) {
			if (numero == numero2) {
				System.out.println(numero + " es igual que " + numero2);
			} else {
				System.out.println(numero + " es mayor que " + numero2);
			}
		} else {
			System.out.println(numero2 + " es mayor que " + numero);
		}
	}

	public static void mensaje(String nombre) {
		System.out.println("Bienvenido " + nombre);
	}

	public static void restoCero(int numero) {

		if (numero % 2 != 0) {
			System.out.println(numero + " no es divisible entre dos.");
		} else {
			System.out.println(numero + " es divisible entre dos.");
		}
	}

	public static void muestraNumeros() {

		int i = 0;
		while (i<100){//(i >= 0 && i < 100) {
			i++;
			System.out.println(i);

		}
	}
	
	public static void muestraNumeros2() {
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	}
}
