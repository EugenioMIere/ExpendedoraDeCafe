package ar.edu.unlam.pb2.maquinasDeCafe;

public class VasoDeCafe {

	private String tipo;
	private Integer precio;
	private String estado = "Lleno";

	public VasoDeCafe(String tipo, Integer precio) {
		this.tipo = tipo;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}

}
