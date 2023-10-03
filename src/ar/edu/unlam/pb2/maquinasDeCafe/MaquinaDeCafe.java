package ar.edu.unlam.pb2.maquinasDeCafe;

import java.util.ArrayList;

public class MaquinaDeCafe {

	ArrayList<VasoDeCafe> cafePedido = new ArrayList<VasoDeCafe>();
	private Integer cargaDeMaquina;

	public MaquinaDeCafe(Integer cargaDeMaquina) {
		this.cargaDeMaquina = cargaDeMaquina;
	}

	public Boolean pedirCafe(VasoDeCafe cafe1) {
		cafePedido.add(cafe1);

		if (cafe1.getTipo() == "Premium") {
			this.cargaDeMaquina -= 10;
		}
		if (cafe1.getTipo() == "Economico") {
			if (this.getCantidadDeEconomicosSolicitados() % 3 == 0) {
				this.cargaDeMaquina -= 10;
			}
		}
		if (cafePedido.size() > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public Boolean pedirCafeMquinaDefectuosa(VasoDeCafe cafe1) {
		if (cafePedido.size()%2==0) {
			cafe1.setEstado("Vacio");
			cafePedido.add(cafe1);
		}else {
			cafePedido.add(cafe1);
		}

		if (cafe1.getTipo() == "Premium"&&cafe1.getEstado()=="Lleno") {
			this.cargaDeMaquina -= 10;
		}
		if (cafe1.getTipo() == "Economico"&&cafe1.getEstado()=="Lleno") {
			if (this.getCantidadDeEconomicosSolicitados() % 3 == 0) {
				this.cargaDeMaquina -= 10;
			}
		}
		if (cafePedido.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Integer getEstadoDeCarga() {

		return this.cargaDeMaquina;
	}

	public Integer getCantidadDeEconomicosSolicitados() {
		Integer cafeEconomico = 0;

		for (VasoDeCafe vasoDeCafe : cafePedido) {
			if (vasoDeCafe.getTipo() == "Economico"&&vasoDeCafe.getEstado()=="Lleno") {
				cafeEconomico++;
			}
		}
		return cafeEconomico;
	}

	public Integer getRecaudado() {

		Integer gananciaDelDia = 0;
		for (VasoDeCafe vasoDeCafe : cafePedido) {
			gananciaDelDia += vasoDeCafe.getPrecio();
		}
		return gananciaDelDia;
	}

	public Integer getCantidadCafe() {

		return this.cafePedido.size();
	}

}
