import javax.swing.JOptionPane;

public class AccesoAplicacion {

	public static void main(String[] args) {
		
		String clave = "Jonathan";
		
		String pass = "";
		
		while (clave.equals(pass) == false) {
			
			pass = JOptionPane.showInputDialog("Introduce la contraseņa");
			
			if (clave.equals(pass) == false) {
				
				System.out.println("Contraseņa incorrecta");
			}
			
		}

		System.out.println("Contraseņa correcta");
	}

}
