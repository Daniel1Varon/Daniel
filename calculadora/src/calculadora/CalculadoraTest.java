package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.Math;

import org.junit.jupiter.api.Test;

class CalculadoraTest {
	private double x1=-5.844542;
	private double y1=-4.7543265;
	private Complejo primero=new Complejo(x1,y1);
	private double x2=4.71454235;
	private double y2=2.63214324;
	private Complejo segundo=new Complejo(x2,y2);
	
	@Test
	void testSuma() {
		Complejo resultado=primero.suma(segundo);
		Complejo prueba=new Complejo(x1+x2,y1+y2);
		assertTrue(prueba.equals(resultado));
	}

	@Test
	void testResta() {
		Complejo resultado=primero.resta(segundo);
		Complejo prueba=new Complejo(x1-x2,y1-y2);
		assertTrue(prueba.equals(resultado));
	}
	
	@Test
	void testMultiplicacion() {
		Complejo resultado=primero.multiplicacion(segundo);
		Complejo prueba=new Complejo((x1*x2)-(y1*y2),(x1*y2)+(x2*y1));
		assertTrue(prueba.equals(resultado));
	}
	
	@Test
	void testDivision() {
		Complejo resultado=primero.division(segundo);
		Complejo prueba=new Complejo(((x1*x2)+(y1*y2))/(Math.pow(x2, 2)+Math.pow(y2, 2)),((x2*y1)-(x1*y2))/(Math.pow(x2, 2)+Math.pow(y2, 2)));
		assertTrue(prueba.equals(resultado));
	}
	
	@Test
	void testModulo() {
		double resultado1=primero.modulo();
		double resultado2=segundo.modulo();
		assertEquals(Math.sqrt(Math.pow(x1,  2)+Math.pow(y1,  2)), resultado1);
		assertEquals(Math.sqrt(Math.pow(x2,  2)+Math.pow(y2,  2)), resultado2);
	}
	
	@Test
	void testConjugada() {
		Complejo resultado1=primero.conjugada();
		Complejo prueba1=new Complejo(x1,y1*-1);
		assertTrue(prueba1.equals(resultado1));
		Complejo resultado2=segundo.conjugada();
		Complejo prueba2=new Complejo(x2,y2*-1);
		assertTrue(prueba2.equals(resultado2));
	}
	
	@Test
	void testPolares() {
		Complejo resultado1=primero.polares();
		Complejo prueba1=new Complejo(Math.sqrt(Math.pow(x1,  2)+Math.pow(y1,  2)),Math.atan(y1/x1));
		assertTrue(prueba1.equals(resultado1));
		Complejo resultado2=segundo.polares();
		Complejo prueba2=new Complejo(Math.sqrt(Math.pow(x2,  2)+Math.pow(y2,  2)),Math.atan(y2/x2));
		assertTrue(prueba2.equals(resultado2));
	}
	
}
