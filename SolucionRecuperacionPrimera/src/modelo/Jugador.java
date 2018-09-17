package modelo;

public class Jugador extends Persona {
	
	private int idEquipo;
	private String fechaContrato; // AAAAMMDD
	private char zonaJuego; // P, D, C, A
	private int numeroCamiseta;
	public Jugador(int id, String nombre, String fechaNacimiento, int pais,  int idEquipo, String fechaContrato,
			char zonaJuego, int numeroCamiseta) {
		super(id, nombre, fechaNacimiento, pais);
		this.idEquipo = idEquipo;
		this.fechaContrato = fechaContrato;
		this.zonaJuego = zonaJuego;
		this.numeroCamiseta = numeroCamiseta;
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public char getZonaJuego() {
		return zonaJuego;
	}
	public void setZonaJuego(char zonaJuego) {
		this.zonaJuego = zonaJuego;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	
}
