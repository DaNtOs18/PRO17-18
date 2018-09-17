package modelo;

import java.time.LocalDate;

public class Vivienda {
	private int id;
	private String direccion;
	private char tipo; //
	private LocalDate fechaConstruccion;
	private boolean habitada;

	public Vivienda() {

		this.id = (int) (Math.random() * 100);
		this.direccion = "Calle " + this.id;
		this.tipo = 'P';
		this.fechaConstruccion = LocalDate.now();
		this.habitada = true;
		// TODO Auto-generated constructor stub
	}

	public Vivienda(int id, String direccion, char tipo, LocalDate fechaConstruccion, boolean habitada) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.tipo = tipo;
		this.fechaConstruccion = fechaConstruccion;
		this.habitada = habitada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFechaConstruccion() {
		return fechaConstruccion;
	}

	public void setFechaConstruccion(LocalDate fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}

	public boolean isHabitada() {
		return habitada;
	}

	public void setHabitada(boolean habitada) {
		this.habitada = habitada;
	}
}
