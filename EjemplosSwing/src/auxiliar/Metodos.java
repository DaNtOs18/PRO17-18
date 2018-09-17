package auxiliar;

import java.util.Scanner;

import ColorChooserDemoProject.ColorChooserDemo;
import ComboBoxDemoProject.ComboBoxDemo;
import CustomIconDemoProject.CustomIconDemo;
import IconDemoProject.IconDemoApp;
import ListDemoProject.ListDemo;



public class Metodos {
	public void ejemplosSwing() {

		String tecleado = "XYZ";
		while (tecleado.compareToIgnoreCase("q") != 0) {

			System.out.println("\t\t SELECCIONE DEMO A EJECUTAR");
			System.out.println("\t\t 1.SELECTOR DE COLOR");
			System.out.println("\t\t 2.COMBO BOX");
			System.out.println("\t\t 3.ICONO CUSTOMIZADO");
			System.out.println("\t\t 4.ICONO");
			System.out.println("\t\t 5.LISTA");
			System.out.println("\t\t q,Q SALIR");
			Scanner teclado = new Scanner(System.in);
			tecleado = teclado.nextLine();
			System.out.println("Usted ha tecleado: " + tecleado);
			ColorChooserDemo cc = new ColorChooserDemo();
			ComboBoxDemo cb = new ComboBoxDemo();
			CustomIconDemo ci = new CustomIconDemo();
			IconDemoApp id = new IconDemoApp();
			ListDemo ld = new ListDemo();
			switch (tecleado) {

			case "1":
				String eleccion1 = "Redirigiendo a la Opción ";
				System.out.println(eleccion1 + tecleado);
				cc.mainColorChooser(null);
				break;
			case "2":
				String eleccion2 = "Redirigiendo a la Opción ";
				System.out.println(eleccion2 + tecleado);
				cb.main(null);
				break;
			case "3":
				String eleccion3 = "Redirigiendo a la Opción ";
				System.out.println(eleccion3 + tecleado);
				ci.main(null);
				break;
			case "4":
				String eleccion4 = "Redirigiendo a la Opción ";
				System.out.println(eleccion4 + tecleado);
				id.main(null);
				break;
				
			case "5":
				String eleccion5 = "Redirigiendo a la Opción ";
				System.out.println(eleccion5 + tecleado);
				ld.main(null);
				break;
			}

		}
		System.out.println("Hasta la próxima");

	}

}
