Autor: Daniel Alejandro Varón Rojas
Institución: Escuela Colombiana de Ingenieria Julio Garavito
Fecha: 14 de Enero de 2020
Version: 1.0
Contenido: {
	Clase: Complejo
	Tipo: Objeto
	Metodos:{
		public Complejo(double x, double y) recibe la parte real y la parte imaginaria por separado del numero complejo y actualiza su estado.
		public Complejo suma(Complejo com) recibe el numero complejo con el cual se quiere sumar y se devuelve un numero complejo con la solución.
		public Complejo resta(Complejo com) recibe el numero complejo con el cual se quiere restar y se devuelve un numero complejo con la solución.
		public Complejo multiplicacion(Complejo com) recibe el numero complejo con el cual se quiere multiplicar y se devuelve un numero complejo con la solución.
		public Complejo division(Complejo com) recibe el numero complejo con el cual se quiere dividir y se devuelve un numero complejo con la solución.}
		public double modulo() devuelve el numero resultado de sacarle el modulo al numero complejo.
		public Complejo conjugada() devuelve el numero complejo correspondiente a la conjugada.
		public Complejo polares() devuelve el numero complejo correspondiente al pasar el numero original a polares.
		public boolean equals(Complejo com) recibe el numero complejo con el cual se quiere comparar y se devuelve un booleano dado el caso.
		public double getX() devuelve el numero correspondiente a la parte real del numero complejo.
		public double getY() devuelve el numero correspondiente a la parte imaginaria del numero complejo.
	}
	Tests: CalculadoraTest
	Pruebas:{
		testSuma: suma dos numeros complejos y lo compara con su respuesta real.
		testResta: resta dos numeros complejos y lo compara con su respuesta real.
		testMultiplicacion: multiplica dos numeros complejos y lo compara con su respuesta real.
		testDivision: divide dos numeros complejos y lo compara con su respuesta real.
		testModulo: calcula el modulo a dos numeros y lo compara con sus respuestas reales.
		testConjugada: calcula el conjugado de dos numeros complejos y lo compara con sus respuesta reales.
		testPolares: calcula el numero complejo en polares de dos numeros complejos y lo compara con sus respuesta reales.
	}
}