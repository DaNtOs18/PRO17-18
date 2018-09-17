import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma() {
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.suma();
		assertEquals(30, resultado);
	}

	@Test
	void testResta() {
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.resta();
		assertEquals(10, resultado);
	}

	@Test
	void testMulti() {
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.multi();
		assertEquals(200, resultado);
	}

	@Test
	void testDivi() {
		Calculadora calcu = new Calculadora(20, 10);
		int resultado = calcu.divi();
		assertEquals(2, resultado);
	}

	@Test
	void testDivi1() {
		try {
			Calculadora calcu = new Calculadora(20, 0);
			int resultado = calcu.divi();
			fail("FALLO NO SE PRODUCE EXCEPCION");
		} catch (ArithmeticException e) {

		}
	}

}
