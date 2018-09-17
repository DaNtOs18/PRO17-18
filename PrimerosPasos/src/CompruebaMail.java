import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {

		String email = JOptionPane.showInputDialog("Introduce tu e-mail");

		// boolean arroba = false;

		int arroba = 0;

		boolean punto = false;

		for (int i = 0; i < email.length(); i++) {

			if (email.charAt(i) == '@') {
				// arroba = true;
				arroba++;
			}

			if (email.charAt(i) == '.') {
				punto = true;
			}
		}

		// if (arroba == true) {
		if (arroba == 1 && punto == true) {
			System.out.println("E-mail válido.");
		}

		else {
			System.out.println("E-mail no váido.");
		}

	}
}
