package CalculadoraMatriz;

public class Vector {
	public Complejo[] complejos;
	
	
	public Vector(int i) {
		complejos=new Complejo[i];
	}
	
	public Vector(Complejo[] comp) {
		complejos=comp;
	}
	
	public void setComplejo(Complejo comp) throws CalculadoraExcepcion{
		boolean completo=false;
		for(int i=0; i<complejos.length;i++) {
			if(complejos[i]!=null) {
				complejos[i]=comp;
				completo=true;
				break;
			}
		}
		if(completo==false) throw new CalculadoraExcepcion(CalculadoraExcepcion.SIN_ESPACIO);
	}
	
	public void setComplejo(Complejo comp,int i) throws CalculadoraExcepcion{
		if(i<complejos.length)
			complejos[i]=comp;
		else throw new CalculadoraExcepcion(CalculadoraExcepcion.FUERA_RANGO);
	}
	
	public boolean revisarPosiciones(Vector ve) {
		boolean vacio=false;
		for(int i=0;i<ve.getLength();i++) {
			if(ve.getComplejo(i)==null) vacio=true;
		}
		return vacio;
	}
	
	public Vector suma(Vector comp) throws CalculadoraExcepcion{
		Vector resultado = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(comp)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length==comp.getLength()) {
			resultado=new Vector(comp.getLength());
			for(int i=0;i<complejos.length;i++) {
				resultado.setComplejo(complejos[i].suma(comp.getComplejo(i)), i);
			}
		}
		else throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
		return resultado;
	}
	
	public Vector resta(Vector comp) throws CalculadoraExcepcion{
		Vector resultado = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(comp)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length==comp.getLength()) {
			resultado=new Vector(comp.getLength());
			for(int i=0;i<complejos.length;i++) {
				resultado.setComplejo(complejos[i].resta(comp.getComplejo(i)), i);
			}
		}
		else throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
		return resultado;
	}
	
	public Vector inversa() throws CalculadoraExcepcion{
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Vector resultado=new Vector(complejos.length);
		for(int i=0;i<complejos.length;i++) {
			resultado.setComplejo(complejos[i].multiplicacion(-1), i);
		}
		return resultado;
	}
	
	public Vector multiplicacionEscalar(Complejo comp) throws CalculadoraExcepcion{
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Vector resultado=new Vector(complejos.length);
		for(int i=0;i<complejos.length;i++) {
			resultado.setComplejo(complejos[i].multiplicacion(comp), i);
		}
		return resultado;
	}
	
	public Matriz transpuesta() throws CalculadoraExcepcion {
		Complejo[][] c = new Complejo[1][complejos.length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			c[0][i]=complejos[i];
		}
		Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Vector conjugada() throws CalculadoraExcepcion {
		Complejo[] c = new Complejo[complejos.length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			c[i]=complejos[i].conjugada();
		}
		Vector sol=new Vector(c);
	    return sol;
	}
	
	public Matriz adjunta() throws CalculadoraExcepcion {
		Complejo[][] c = new Complejo[1][complejos.length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			c[0][i]=complejos[i].conjugada();
		}
		Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Complejo productoInterno(Vector ve) throws CalculadoraExcepcion {
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(ve)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length!=ve.getLength()) throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
		Complejo sol = null;
		for(int i=0;i<complejos.length;i++) {
			if(sol==null) sol=complejos[i].multiplicacion(ve.getComplejo(i));
			else sol=sol.suma(complejos[i].multiplicacion(ve.getComplejo(i)));
		}
		return sol;
	}
	
	public double norma() throws CalculadoraExcepcion {
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Complejo res = this.productoInterno(this);
		double sol=res.modulo();
		return sol;
	}
	
	public double distanciaEntreVectores(Vector ve) throws CalculadoraExcepcion {
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(ve)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length!=ve.getLength()) throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
		Vector resultado = this.resta(ve);
		return resultado.norma();
	}
	
	public Vector productoTensor(Vector ve) throws CalculadoraExcepcion {
		Vector resultado = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(ve)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Complejo[] dat=new Complejo[ve.getLength()*complejos.length];
		for(int i=0;i<complejos.length;i++) {
			for(int j=0;j<ve.getLength();j++) {
				dat[(i*ve.getLength())+j]=complejos[i].multiplicacion(ve.getComplejo(j));
			}
		}
		resultado=new Vector(dat);
		return resultado;
	}
	
	public Matriz productoTensor(Matriz mat) throws CalculadoraExcepcion {
		Matriz sol;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(mat.revisarPosiciones(mat)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Complejo[][]dat=new Complejo[complejos.length*mat.getLength()][mat.getLengthFila()];
		for(int i=0; i<complejos.length;i++) {
			for(int j=0;j<mat.getLength();j++) {
				for(int k=0;k<mat.getLengthFila();k++) {
					dat[j+((mat.getLength()*i))][k]=mat.getComplejo(j,k).multiplicacion(complejos[i]);
				}
			}
		}
		sol=new Matriz(dat);
		return sol;
	}
	
	public int getLength() {
		return complejos.length;
	}
	
	public Complejo getComplejo(int i) {
		return complejos[i];
	}
}