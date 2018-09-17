package paquete1.sub;

import java.time.LocalDate;

import paquete2.Abstracta;
import paquete3.Interfaz1;
import paquete3.Interfaz2;

public class Clase1 extends Abstracta implements Interfaz1, Interfaz2 {

	private int numeroEntero;
	private String cadena;
	private boolean opcion;
	private LocalDate fecha;
	private float numeroDecimal;
	private static int numeroEntero2;
	public int getNumeroEntero() {
		return numeroEntero;
	}
	public void setNumeroEntero(int numeroEntero) {
		this.numeroEntero = numeroEntero;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public boolean isOpcion() {
		return opcion;
	}
	public void setOpcion(boolean opcion) {
		this.opcion = opcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public float getNumeroDecimal() {
		return numeroDecimal;
	}
	public void setNumeroDecimal(float numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
	}
	public static int getNumeroEntero2() {
		return numeroEntero2;
	}
	public static void setNumeroEntero2(int numeroEntero2) {
		Clase1.numeroEntero2 = numeroEntero2;
	}
	public Clase1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clase1(int numeroEntero, String cadena, boolean opcion, LocalDate fecha, float numeroDecimal) {
		super();
		this.numeroEntero = numeroEntero;
		this.cadena = cadena;
		this.opcion = opcion;
		this.fecha = fecha;
		this.numeroDecimal = numeroDecimal;
	}
	@Override
	public void metodo1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void metodo2() {
		// TODO Auto-generated method stub
		
	}

}
