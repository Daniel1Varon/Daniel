package CalculadoraMatriz;

public class Matriz {
	
	private Complejo[][] complejos;
	
	public Matriz(int filas,int columnas) {
		complejos=new Complejo[filas][columnas];
		
	}
	
	public Matriz(Complejo[][] datos) {
		complejos=datos;
	}
	
	public void setComplejo(Complejo comp) throws CalculadoraExcepcion{
		boolean completo=false;
		for(int i=0; i<complejos.length;i++) {
			for(int j=0;j<complejos[i].length;j++) {
				if(complejos[i][j]!=null && completo==false) {
					complejos[i][j]=comp;
					completo=true;
					break;
				}
			}
		}
		if(completo==false) throw new CalculadoraExcepcion(CalculadoraExcepcion.SIN_ESPACIO);
	}
	
	public void setComplejo(Complejo comp,int i,int j) throws CalculadoraExcepcion{
		if(i<complejos.length) {
			if(j<complejos[0].length)
				complejos[i][j]=comp;
		}
			
		else throw new CalculadoraExcepcion(CalculadoraExcepcion.FUERA_RANGO);
	}
	
	public boolean revisarPosiciones(Matriz ve) {
		boolean vacio=false;
		for(int i=0;i<ve.getLength();i++) {
			for(int j=0;j<ve.getLengthFila();j++) {
				if(ve.getComplejo(i,j)==null) vacio=true;
			}
		}
		return vacio;
	}
	
	public Matriz sumar(Matriz b) throws CalculadoraExcepcion {
		Matriz sol = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(b)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length!=b.getLength()||complejos[0].length!=b.getLengthFila()) throw new CalculadoraExcepcion(CalculadoraExcepcion.TAMAÑOS_DIFERENTES);
		else {
			Complejo[][] dat=new Complejo[complejos.length][complejos[0].length];
			for(int i=0;i<complejos.length;i++) {
				for(int j=0;j<complejos[0].length;j++) {
					dat[i][j]=complejos[i][j].suma(b.getComplejo(i,j));
				}
			}
			sol=new Matriz(dat);
		}
		return sol;
	}
	
	public Matriz restar(Matriz b) throws CalculadoraExcepcion {
		Matriz sol = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(b)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(complejos.length!=b.getLength()||complejos[0].length!=b.getLengthFila()) throw new CalculadoraExcepcion(CalculadoraExcepcion.TAMAÑOS_DIFERENTES);
		else {
			Complejo[][] dat=new Complejo[complejos.length][complejos[0].length];
			for(int i=0;i<complejos.length;i++) {
				for(int j=0;j<complejos[0].length;j++) {
					dat[i][j]=complejos[i][j].resta(b.getComplejo(i,j));
				}
			}
			sol=new Matriz(dat);
		}
		return sol;
	}
	
	public Matriz inversa() throws CalculadoraExcepcion {
		Matriz sol = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		else {
			Complejo[][] dat=new Complejo[complejos.length][complejos[0].length];
			for(int i=0;i<complejos.length;i++) {
				for(int j=0;j<complejos[0].length;j++) {
					dat[i][j]=complejos[i][j].multiplicacion(-1);
				}
			}
			sol=new Matriz(dat);
		}
		return sol;
	}
	
	public Matriz multiplicacionEscalar(Complejo comp) throws CalculadoraExcepcion {
		Matriz sol = null;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		else {
			Complejo[][] dat=new Complejo[complejos.length][complejos[0].length];
			for(int i=0;i<complejos.length;i++) {
				for(int j=0;j<complejos[0].length;j++) {
					dat[i][j]=complejos[i][j].multiplicacion(comp);
				}
			}
			sol=new Matriz(dat);
		}
		return sol;
	}
	
	public Matriz multiplicacion(Matriz mat) throws CalculadoraExcepcion {
		Complejo[][] c = new Complejo[complejos.length][mat.getLengthFila()];
	    // se comprueba si las matrices se pueden multiplicar
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(this.revisarPosiciones(mat)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
	    if (complejos[0].length == mat.getLength()) {
	    	for (int i=0;i<complejos.length;i++){
	    		for (int j=0;j<mat.getLengthFila();j++){
	    			c[i][j]=null;
	    			for (int k=0;k<complejos[0].length;k++){
	    				if(c[i][j]==null) c[i][j]=complejos[i][k].multiplicacion(mat.getComplejo(k,j));
	    				else c[i][j]=c[i][j].suma(complejos[i][k].multiplicacion(mat.getComplejo(k,j)));
	    			}
	    		}
	    	}
	    }
	    else throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
	    Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Matriz multiplicacion(Vector mat) throws CalculadoraExcepcion {
		Complejo[][] c = new Complejo[complejos.length][1];
	    // se comprueba si las matrices se pueden multiplicar
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(mat.revisarPosiciones(mat)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
	    if (complejos[0].length == mat.getLength()) {
	        for (int i = 0; i < complejos.length; i++) {
	            for (int j = 0; j <1; j++) {
	                for (int k = 0; k < complejos[0].length; k++) {
	                    // aquí se multiplica la matriz
	                	if(c[i][j]==null) c[i][j] = complejos[i][k].multiplicacion(mat.getComplejo(k));
	                	else c[i][j] = c[i][j].suma(complejos[i][k].multiplicacion(mat.getComplejo(k)));
	                }
	            }
	        }
	    }
	    else throw new CalculadoraExcepcion(CalculadoraExcepcion.DIMENSIONES_INCORRECTAS);
	    Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Matriz transpuesta() throws CalculadoraExcepcion{
		Complejo[][] c = new Complejo[complejos[0].length][complejos.length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			for(int j=0;j<complejos[0].length;j++) {
				c[j][i]=c[i][j];
			}
		}
		Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Matriz conjugada() throws CalculadoraExcepcion{
		Complejo[][] c = new Complejo[complejos.length][complejos[0].length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			for(int j=0;j<complejos[0].length;j++) {
				c[i][j]=c[i][j].conjugada();
			}
		}
		Matriz sol=new Matriz(c);
	    return sol;
	}
	
	public Matriz adjunta() throws CalculadoraExcepcion{
		Complejo[][] c = new Complejo[complejos[0].length][complejos.length];
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		for(int i=0;i<complejos.length;i++) {
			for(int j=0;j<complejos[0].length;j++) {
				c[j][i]=c[i][j].conjugada();
			}
		}
		Matriz sol=new Matriz(c);
	    return sol;
	}
	
	/**Cambiar*/
	public Matriz productoTensor(Matriz mat) throws CalculadoraExcepcion {
		Matriz sol;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(mat.revisarPosiciones(mat)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Complejo[][]dat=new Complejo[complejos.length*mat.getLength()][complejos[0].length*mat.getLengthFila()];
		for(int i=0; i<complejos.length;i++) {
			for(int j=0;j<complejos[0].length;j++) {
				for(int k=0;k<mat.getLength();k++) {
					for(int n=0;n<mat.getLengthFila();n++) {
						dat[k+(mat.getLength()*i)][n+(mat.getLengthFila()*j)]=mat.getComplejo(k,n).multiplicacion(complejos[i][j]);
					}
				}
			}
		}
		sol=new Matriz(dat);
		return sol;
	}
	
	public Matriz productoTensor(Vector mat) throws CalculadoraExcepcion {
		Matriz sol;
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		if(mat.revisarPosiciones(mat)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		Complejo[][]dat=new Complejo[complejos.length*mat.getLength()][complejos[0].length];
		for(int i=0; i<complejos.length;i++) {
			for(int j=0;j<complejos[0].length;j++) {
				for(int k=0;k<mat.getLength();k++) {
					dat[k+(mat.getLength()*i)][j]=mat.getComplejo(k).multiplicacion(complejos[i][j]);
				}
			}
		}
		sol=new Matriz(dat);
		return sol;
	}
	
	public boolean hermitiana() throws CalculadoraExcepcion {
		if(this.revisarPosiciones(this)) throw new CalculadoraExcepcion(CalculadoraExcepcion.INCOMPLETA);
		boolean sol=true;
		if(complejos.length!=complejos[0].length) sol=false;
		else {
			Matriz adj=this.adjunta();
			for(int i=0;i<complejos.length;i++) {
				for(int j=0;j<complejos[0].length;j++) {
					if(!complejos[i][j].equals(adj.getComplejo(i, j))) sol=false;
				}
			}
		}
		return sol;
	}
	
	
	
	public Complejo getComplejo(int i,int j) {
		return complejos[i][j];
	}
	public int getLength() {
		return complejos.length;
	}
	public int getLengthFila() {
		return complejos[0].length;
	}
}