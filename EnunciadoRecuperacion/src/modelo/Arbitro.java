package modelo;

public class Arbitro extends Persona {
	
	private String colegio;
	public Arbitro(int id, String nombre, String fechaNacimiento, int pais, String colegio) {
		super(id, nombre, fechaNacimiento, pais);
	
		this.colegio = colegio;
	}
	
	public String getColegio() {
		return colegio;
	}
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	
}
