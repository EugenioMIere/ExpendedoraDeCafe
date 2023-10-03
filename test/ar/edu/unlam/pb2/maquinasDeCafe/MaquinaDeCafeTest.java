package ar.edu.unlam.pb2.maquinasDeCafe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaquinaDeCafeTest {

	@Test
	public void queSePuedaPedirUnCafe() {
		String tipo = "Premium";
		Integer precio = 120;
		Integer cargaDeMaquina = 1000;
		MaquinaDeCafe cafetera = new MaquinaDeCafe(cargaDeMaquina);
		VasoDeCafe cafe1 = new VasoDeCafe(tipo, precio);

		Boolean valorObtenido = cafetera.pedirCafe(cafe1);
		Boolean valorEsperado = true;

		assertEquals(valorObtenido, valorEsperado);

	}

	@Test
	public void queAlPedirCafePremiumDescunteDiezGramos() {
		String tipo = "Premium";
		Integer precio = 120;
		Integer cargaDeMaquina = 1000;
		MaquinaDeCafe cafetera = new MaquinaDeCafe(cargaDeMaquina);
		VasoDeCafe cafe1 = new VasoDeCafe(tipo, precio);

		cafetera.pedirCafe(cafe1);
		Integer valorObtenido = cafetera.getEstadoDeCarga();
		Integer valorEsperado = 990;

		assertEquals(valorObtenido, valorEsperado);

	}

	@Test
	public void queAlPedirTresVasosDeCafeEconomicoDescunteDiezGramos() {
		String tipo = "Economico";
		Integer precio = 120;
		Integer cargaDeMaquina = 1000;
		MaquinaDeCafe cafetera = new MaquinaDeCafe(cargaDeMaquina);
		VasoDeCafe cafe1 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe2 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe3 = new VasoDeCafe(tipo, precio);

		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);

		Integer valorObtenido = cafetera.getEstadoDeCarga();
		Integer valorEsperado = 980;

		assertEquals(valorObtenido, valorEsperado);

	}

	@Test
	public void queAlFinalDeLaJornadaSePuedaSaberCuatoSeRecaudo() {
		String tipo = "Economico";
		Integer precio = 120;
		Integer cargaDeMaquina = 1000;
		MaquinaDeCafe cafetera = new MaquinaDeCafe(cargaDeMaquina);
		VasoDeCafe cafe1 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe2 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe3 = new VasoDeCafe("Premium", precio);

		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe2);
		cafetera.pedirCafe(cafe3);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);
		cafetera.pedirCafe(cafe1);

		Integer valorObtenido = cafetera.getRecaudado();
		Integer valorEsperado = 720;

		assertEquals(valorObtenido, valorEsperado);

	}

	@Test
	public void queLaMaquinaSeaDefectuosa() {
		String tipo = "Economico";
		Integer precio = 120;

		Integer cargaDeMaquina = 1000;
		MaquinaDeCafe cafetera = new MaquinaDeCafe(cargaDeMaquina);
		VasoDeCafe cafe1 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe2 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe3 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe4 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe5 = new VasoDeCafe(tipo, precio);
		VasoDeCafe cafe6 = new VasoDeCafe(tipo, precio);
		

		cafetera.pedirCafeMquinaDefectuosa(cafe1);
		cafetera.pedirCafeMquinaDefectuosa(cafe2);
		cafetera.pedirCafeMquinaDefectuosa(cafe3);
		cafetera.pedirCafeMquinaDefectuosa(cafe4);
		cafetera.pedirCafeMquinaDefectuosa(cafe5);
		cafetera.pedirCafeMquinaDefectuosa(cafe6);
		

		Integer obtenido = cafetera.getCantidadCafe();
		Integer esperado = 6;
		Integer valorObtenido = cafetera.getEstadoDeCarga();
		Integer valorEsperado = 990;

		assertEquals(obtenido, esperado);
		assertEquals(valorObtenido, valorEsperado);

	}

}
