
public class ManipulaCadenas2 {

	public static void main(String[] args) {
		
		String frase = "Hoy es un estupendo día para aprender a programar en Java";
		
		String fraseResumen = frase.substring(0, 29) + " irnos a la playa y olvidarnos de todo..." + 
		" y " + frase.substring(29, 57);
		
		System.out.println(fraseResumen);

	}

}
