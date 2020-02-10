package calculadora;


public class CalculadoraExcepcion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String TAMA�OS_DIFERENTES="Los tama�os de las dos matrices son diferentes.";
	public static String SIN_ESPACIO="El numero no se puede a�adir ya que no hay espacio.";
	public static String FUERA_RANGO="La posici�n escogida esta fuera del rango.";
	public static String DIMENSIONES_INCORRECTAS="Las dimensiones de las dos matrices/vectores no coinciden para la operaci�n.";
	public static String INCOMPLETA="La matriz/vector no estan del todo llenas.";
	public CalculadoraExcepcion(String s) {
		super(s);
	}
}
