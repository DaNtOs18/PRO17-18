import javax.swing.JOptionPane;

public class AccesoAplicacion {

	public static void main(String[] args) {
		
		String clave = "Jonathan";
		
		String pass = "";
		
		while (clave.equals(pass) == false) {
			
			pass = JOptionPane.showInputDialog("Introduce la contrase�a");
			
			if (clave.equals(pass) == false) {
				
				System.out.println("Contrase�a incorrecta");
			}
			
		}

		System.out.println("Contrase�a correcta");
	}

}
