package CalculadoraMatriz;

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
		boolean equals=prueba.equals(resultado);
		assertTrue(equals);
	}

	@Test
	void testResta() {
		Complejo resultado=primero.resta(segundo);
		Complejo prueba=new Complejo(x1-x2,y1-y2);
		boolean equals=prueba.equals(resultado);
		assertTrue(equals);
	}
	
	@Test
	void testMultiplicacion() {
		Complejo resultado=primero.multiplicacion(segundo);
		Complejo prueba=new Complejo((x1*x2)-(y1*y2),(x1*y2)+(x2*y1));
		boolean equals=prueba.equals(resultado);
		assertTrue(equals);
	}
	
	@Test
	void testDivision() {
		Complejo resultado=primero.division(segundo);
		Complejo prueba=new Complejo(((x1*x2)+(y1*y2))/(Math.pow(x2, 2)+Math.pow(y2, 2)),((x2*y1)-(x1*y2))/(Math.pow(x2, 2)+Math.pow(y2, 2)));
		boolean equals=prueba.equals(resultado);
		assertTrue(equals);
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
		Complejo resultado2=segundo.conjugada();
		Complejo prueba1=new Complejo(x1,y1*-1);
		boolean equals1=prueba1.equals(resultado1);
		assertTrue(equals1);
		Complejo prueba2=new Complejo(x2,y2*-1);
		boolean equals2=prueba2.equals(resultado2);
		assertTrue(equals2);
	}
	
	@Test
	void testPolares() {
		Complejo resultado1=primero.polares();
		Complejo resultado2=segundo.polares();
		Complejo prueba1=new Complejo(Math.sqrt(Math.pow(x1,  2)+Math.pow(y1,  2)),Math.atan(y1/x1));
		boolean equals1=prueba1.equals(resultado1);
		assertTrue(equals1);
		Complejo prueba2=new Complejo(Math.sqrt(Math.pow(x2,  2)+Math.pow(y2,  2)),Math.atan(y2/x2));
		boolean equals2=prueba2.equals(resultado2);
		assertTrue(equals2);
	}
	
	/**TEST DE MATRICES Y VECTORES*/
	
	
	@Test
	void testMatriz() {
		
		Complejo[][] dat=new Complejo[1][2];
		dat[0][0]=new Complejo(0,0);
		dat[0][1]=new Complejo(1,0);
		Matriz mat=new Matriz(dat);
		
		Complejo[][] dat2=new Complejo[2][2];
		dat2[0][0]=new Complejo(2,0);
		dat2[0][1]=new Complejo(3,0);
		dat2[1][0]=new Complejo(4,0);
		dat2[1][1]=new Complejo(5,0);
		Matriz mat2=new Matriz(dat2);
		
		try {
			Matriz mat1=mat2.productoTensor(mat);
			for(int i=0;i<mat1.getLength();i++) {
				for(int j=0;j<mat1.getLengthFila();j++) {
					System.out.print(mat1.getComplejo(i, j).getX()+"+"+mat1.getComplejo(i, j).getY()+"i,  ");
				}
				System.out.println();
			}
		} catch (CalculadoraExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testVectorProductoTensorVector() {
		
		Complejo[] dat=new Complejo[3];
		dat[0]=new Complejo(3,0);
		dat[1]=new Complejo(4,0);
		dat[2]=new Complejo(7,0);
		Vector mat=new Vector(dat);
		
		Complejo[] dat1=new Complejo[2];
		dat1[0]=new Complejo(-1,0);
		dat1[1]=new Complejo(2,0);
		Vector mat1=new Vector(dat1);
		
		try {
			Vector mat2=mat.productoTensor(mat1);
			for(int j=0;j<mat2.getLength();j++) {
				//System.out.print(mat2.getComplejo(j).getX()+"+"+mat2.getComplejo(j).getY()+"i,  ");
			}
		} catch (CalculadoraExcepcion e) {
			//System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testVectorProductoTensorMatriz() {
		
		Complejo[] dat=new Complejo[3];
		dat[0]=new Complejo(1,0);
		dat[1]=new Complejo(2,0);
		dat[2]=new Complejo(3,0);
		Vector mat=new Vector(dat);
		
		Complejo[][] dat1=new Complejo[2][3];
		dat1[0][0]=new Complejo(1,0);
		dat1[0][1]=new Complejo(2,0);
		dat1[0][2]=new Complejo(3,0);
		dat1[1][0]=new Complejo(4,0);
		dat1[1][1]=new Complejo(5,0);
		dat1[1][2]=new Complejo(6,0);
		Matriz mat1=new Matriz(dat1);
		
		try {
			Matriz mat2=mat1.productoTensor(mat);
			for(int i=0;i<mat2.getLength();i++) {
				for(int j=0;j<mat2.getLengthFila();j++) {
					System.out.print(mat2.getComplejo(i,j).getX()+"+"+mat2.getComplejo(i,j).getY()+"i,  ");
				}
				System.out.println("");
			}
		} catch (CalculadoraExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testLaboratorio() {
		//Valores del vector correspondiente a |00>
		Complejo[] dat=new Complejo[4];
		dat[0]=new Complejo(1,0);
		dat[1]=new Complejo(0,0);
		dat[2]=new Complejo(0,0);
		dat[3]=new Complejo(0,0);
		Vector mat=new Vector(dat);
		//Valores del vector correspondiente a H
		Complejo[][] dat1=new Complejo[2][2];
		dat1[0][0]=new Complejo(1/(Math.sqrt(2)),0);
		dat1[0][1]=new Complejo(1/(Math.sqrt(2)),0);
		dat1[1][0]=new Complejo(1/(Math.sqrt(2)),0);
		dat1[1][1]=new Complejo(-1/(Math.sqrt(2)),0);
		Matriz mat1=new Matriz(dat1);
		//Valores del vector correspondiente a X
		Complejo[][] dat2=new Complejo[2][2];
		dat2[0][0]=new Complejo(0,0);
		dat2[0][1]=new Complejo(1,0);
		dat2[1][0]=new Complejo(1,0);
		dat2[1][1]=new Complejo(0,0);
		Matriz matx=new Matriz(dat2);
		try {
			Matriz mat2=mat1.productoTensor(mat1);
			Matriz mat3=mat1.productoTensor(matx);
			Matriz mat4=mat3.multiplicacion(mat2);
			Matriz mat5=mat4.multiplicacion(mat);
			//imprime valores
			for(int i=0;i<mat5.getLength();i++) {
				for(int j=0;j<mat5.getLengthFila();j++) {
					System.out.print(mat5.getComplejo(i,j).getX()+"+"+mat5.getComplejo(i,j).getY()+"i, ");
				}
				System.out.println("");
			}
		} catch (CalculadoraExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	void testMultiplicacionMatricez() {
		Complejo[][] dat1=new Complejo[2][3];
		dat1[0][0]=new Complejo(0,0);
		dat1[0][1]=new Complejo(1,0);
		dat1[0][2]=new Complejo(2,0);
		dat1[1][0]=new Complejo(3,0);
		dat1[1][1]=new Complejo(4,0);
		dat1[1][2]=new Complejo(5,0);
		Matriz matx=new Matriz(dat1);
		
		Complejo[][] dat2=new Complejo[3][2];
		dat2[0][0]=new Complejo(6,0);
		dat2[0][1]=new Complejo(7,0);
		dat2[1][0]=new Complejo(8,0);
		dat2[1][1]=new Complejo(9,0);
		dat2[2][0]=new Complejo(10,0);
		dat2[2][1]=new Complejo(11,0);
		Matriz maty=new Matriz(dat2);
		
		try {
			Matriz sol=maty.productoTensor(matx);
			for(int i=0;i<sol.getLength();i++) {
				for(int j=0;j<sol.getLengthFila();j++) {
					System.out.print(sol.getComplejo(i,j).getX()+"+"+sol.getComplejo(i,j).getY()+"i,y ");
				}
				System.out.println("");
			}
		} catch (CalculadoraExcepcion e) {
			System.out.println(e.getMessage());
		}
	}
}