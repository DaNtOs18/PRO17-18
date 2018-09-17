package modelo;

public class Equipo {
	private int id;
	private String nombre;
	private String estadio;
	private String fechaFundacion;
	public Equipo(int id, String nombre, String estadio, String fechaFundacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estadio = estadio;
		this.fechaFundacion = fechaFundacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getFechaFundacion() {
		return fechaFundacion;
	}
	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
}
