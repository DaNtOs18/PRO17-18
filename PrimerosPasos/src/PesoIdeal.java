import javax.swing.*;
public class PesoIdeal {

	public static void main(String[] args) {
		
		String genero = "";
		do {
			genero = JOptionPane.showInputDialog("Introduce tu género (H/M))");
			
		}while(genero.equalsIgnoreCase("H") ==false && genero.equalsIgnoreCase("M") ==false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
		
		int pesoideal = 0;
		
		if (genero.equalsIgnoreCase("H")) {
			
			pesoideal = altura - 100;
		}
	
		else if (genero.equalsIgnoreCase("M")) {
			
			pesoideal = altura - 110;
		}
	
		System.out.println("Tu peso ideal es de " + pesoideal + " kilos.");
	}
	
	
	

 
}
