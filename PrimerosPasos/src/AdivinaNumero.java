import java.util.*;

public class AdivinaNumero {

	public static void main(String[] args) {

		// System.out.println((int) (Math.random() * 100));

		int aleatorio = (int) (Math.random() * 100);

		// System.out.println(aleatorio);*/

		Scanner entrada = new Scanner(System.in);

		int numero = 0;

		int intentos = 0;

		//while (numero != aleatorio) { comentada para poder hacer el bucle do-while
		do {
			intentos++;
			System.out.println("Introduce un n�mero, por favor...");

			numero = entrada.nextInt();

			if (aleatorio < numero) {

				System.out.println("M�s bajo");
			}

			else if (aleatorio > numero) {

				System.out.println("M�s alto");

			}

		}while (numero != aleatorio);
		System.out.println("Correcto. Lo has conseguido en " + intentos + " intentos.");
		
	}

}
