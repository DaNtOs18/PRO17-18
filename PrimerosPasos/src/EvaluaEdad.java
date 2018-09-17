import java.util.Scanner;

public class EvaluaEdad {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu edad, por favor");

		int edad = entrada.nextInt();

		/*
		 * if (edad >= 18) { System.out.println("Mayor de edad");
		 * 
		 * } else { System.out.println("Menor de edad"); }
		 */

		if (edad < 18) {

			System.out.println("Adolescente");
		}

		else if (edad < 40) {

			System.out.println("Joven");
		}

		else if (edad < 65) {

			System.out.println("Maduro");
		}

		else {
			System.out.println("Te queda na' y menos");

		}

	}

}
