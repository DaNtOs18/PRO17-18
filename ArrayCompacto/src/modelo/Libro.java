package modelo;

public class Libro {
private int ISBN;
private char tipo;
private String nombre;
private boolean nuevo;
public int getISBN() {
	return ISBN;
}
public void setISBN(int iSBN) {
	ISBN = iSBN;
}
public char getTipo() {
	return tipo;
}
public void setTipo(char tipo) {
	this.tipo = tipo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public boolean isNuevo() {
	return nuevo;
}
public void setNuevo(boolean nuevo) {
	this.nuevo = nuevo;
}
public Libro(int iSBN, char tipo, String nombre, boolean nuevo) {
	super();
	ISBN = iSBN;
	this.tipo = tipo;
	this.nombre = nombre;
	this.nuevo = nuevo;
}
public Libro() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Libro [ISBN=" + ISBN + ", tipo=" + tipo + ", nombre=" + nombre + ", nuevo=" + nuevo + "]";
}

}


