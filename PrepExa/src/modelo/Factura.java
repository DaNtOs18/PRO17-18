package modelo;

public class Factura {
	private String nombre;
	private int valor;
	private char tipo;
	private String codigo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Factura(String nombre, int valor, char tipo, String codigo) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.tipo = tipo;
		this.codigo = codigo;
	}
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Factura [nombre=" + nombre + ", valor=" + valor + ", tipo=" + tipo + ", codigo=" + codigo + "]";
	}

}
