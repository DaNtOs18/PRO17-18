package modelo;

import java.time.LocalDate;

public class Jugador extends Persona {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8359763644063057988L;
	//private static final long serialVersionUID = 1L;
	private int equipo;
	private int golesMarcados;
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nif, String nombre, LocalDate fecha, int altura, int equipo, int goles) {
		super(nif, nombre,  fecha, altura);
		this.equipo=equipo;
		this.golesMarcados=goles;
		
	}
	
	public int getEquipo() {
		return equipo;
	}
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	public int getGolesMarcados() {
		return golesMarcados;
	}
	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}
	public int compareTo(Jugador jugador) {
		// TODO Auto-generated method stub
		return 0;
	}

}
