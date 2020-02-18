package CalculadoraMatriz;

import java.lang.Math;

public class Complejo {
	private double[] numero=new double[2];
	public Complejo(double x,double y) {
		numero[0]=x;
		numero[1]=y;
	}
	
	public Complejo suma(Complejo com) {
		double xsol=numero[0]+com.getX();
		double ysol=numero[1]+com.getY();
		Complejo sol=new Complejo(xsol, ysol);
		return sol;
	}
	
	public Complejo resta(Complejo com) {
		double xsol=numero[0]-com.getX();
		double ysol=numero[1]-com.getY();
		Complejo sol=new Complejo(xsol, ysol);
		return sol;
	}
	
	public Complejo multiplicacion(Complejo com) {
		double xsol=(numero[0]*com.getX())-(numero[1]*com.getY());
		double ysol=(numero[0]*com.getY())+(com.getX()*numero[1]);
		Complejo sol=new Complejo(xsol, ysol);
		return sol;
	}
	
	public Complejo multiplicacion(double i) {
		Complejo sol=new Complejo(numero[0]*i, numero[1]*i);
		return sol;
	}
	
	public Complejo division(Complejo com) {
		
		double xsol=((numero[0]*com.getX())+(numero[1]*com.getY()))/(( Math.pow(com.getX(),  2))+( Math.pow( com.getY(),  2)));
		double ysol=((com.getX()*numero[1])-(numero[0]*com.getY()))/(( Math.pow(com.getX(),  2))+( Math.pow( com.getY(),  2)));
		Complejo sol=new Complejo(xsol, ysol);
		return sol;
	}
	
	public double modulo() {
		double sol=Math.sqrt(Math.pow(numero[0],  2)+Math.pow(numero[1],  2));
		return sol;
	}
	
	public Complejo conjugada() {
		Complejo sol=new Complejo(numero[0], numero[1]*-1);
		return sol;
	}
	
	public Complejo polares() {
		double xsol=Math.sqrt(Math.pow(numero[0],  2)+Math.pow(numero[1],  2));
		double ysol=Math.atan(numero[1]/numero[0]);
		Complejo sol=new Complejo(xsol, ysol);
		return sol;
	}
	
	
	public boolean equals(Complejo com) {
		boolean sol=false;
		if(numero[0]==com.getX()&&numero[1]==com.getY()) sol=true;
		return sol;
	}
	
	//Obtener el primer numero del vector.
	public double getX() {
		return numero[0];
	}
	//Obtener el segundo numero del vector.
	public double getY() {
		return numero[1];
	}
}