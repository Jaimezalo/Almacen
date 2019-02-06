package almacenContenedor;

import java.util.Arrays;
import java.util.Scanner;

/**
*
*Tabla dos zonas: zona ocupada y zona libre .
* Implementar un almac�n de enteros mediante una tabla de huecos
* se supone que no puede contener el valor 0 ya que indica posiciones libre.
* @author Jaime Zalo�a Garcia
* @since 01/01/2019
*
*/
public class Almacen2 {

	Scanner sc = new Scanner(System.in);
	// Array con los valores almacenados
	static private final int LIBRE = 0;
	private int tvalores[];
	private int valoresAlmacenados = 0;
	
	
	/**
	 * Constructores sin par�metros creo una tabla de 10 elementos
	 */
	public Almacen2(){
		this(10);  /*Llamo al constructor con par�metros*/
	}


	/**
	 * Constructor donde se fija tama�o m�ximo del Almac�n
	 * @param tama�o Variable que indica el tama�o de la tabla.
	 */
	public Almacen2( int tama�o){
		tvalores = new int [tama�o];
		init();
	}
	
	
	/**
	 * Ordena la tabla con los espacios vacios a la derecha
	 */
	private void empaquetar(){
		for (int i = 0; i < tvalores.length; i++) {
			if ( tvalores[i] == 0){
				// Busco un valor a situar en el cero
				for (int j = i+1; j < tvalores.length; j++) {
					if ( tvalores[j] != 0){
						tvalores[i] = tvalores[j];
						tvalores[j] = 0;
						break;
					}
				}
			}
		}
	}
	
	
	/**
	 * Indica si el almac�n esta lleno.
	 * @return true si est� lleno o false si quedan sitios libres.
	 */
	public boolean estaLleno (){
		if (valoresAlmacenados==tvalores.length){
			valoresAlmacenados = tvalores.length;
			return true; /*@return El almacen esta lleno*/
		}
	return false;/*@return El almacen NO esta lleno*/
	}
	

	/**
	 * Comprueba que un valor introducido por el usuario est� en el almac�n.
	 * @param num Es el valor introducido por el usuario.
	 * @return Devuelve verdadero o falso si est� almacenado el valor en la tabla
	 */
	public boolean estaValor ( int num){
		System.out.print("Que valor quieres buscar: ");
		num = sc.nextInt(); /*El usuario introduce el valor que sera buscado en el almacen */
		for(int i=0; i<tvalores.length; i++) {
			if(tvalores[i]==num) {
				return true;
			}
		}
	return false;
	}
	
	

	/**
	 * Pone todas las posiciones a LIBRES
	 */
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
		valoresAlmacenados = 0;
	}
	

	/**
	 * Cuenta el n�mero de posiones donde NO existen valores.
	 * @return devuelve el n�mero de posiciones libres.
	 */
	public int numPosicionesLibres(){
		int libres=0;
		for(int i=0; i<tvalores.length; i++) {
			if(tvalores[i]==0) {
				libres++;
			}
		}
		valoresAlmacenados = tvalores.length - libres;
		return libres;
	}
	

	/**
	 * Cuenta el n�mero de posiones donde existen valores.
	 * @return devuelve el n�mero de posiciones ocupadas.
	 */
	public int numPosicionesOcupadas(){
		for(int i=0; i<tvalores.length; i++) {
			if(tvalores[i]!=LIBRE) {
				valoresAlmacenados++;
			}
		}
		return valoresAlmacenados;
	}
	

	/**
	 * Almacena el valor en la tabla. 
	 * @param valor es un valor introducido por el usuario.
	 * @return devuelve true si el valor ha sido introducido. Devuelve false sin no puede almacenarlo.
	 */
	public boolean ponValor (int valor){
		if (this.estaLleno()==true) {
			return false; /* El almacen esta lleno */
		}
		for(int i=0; i<tvalores.length; i++) {
			if(tvalores[i]==0){
				System.out.print("Introduzca un valor: ");
				valor = sc.nextInt(); /* El usuario introduce un valor que sera almacenado */
				tvalores[i]=valor;
				valoresAlmacenados++;
				return true;	/* El valor ha sido almacenado */
			}
		}
		return false;
	
	}
	

	/**
	 * Elimina del almac�n el elemento introducido por el usuario.  
	 * @param valor es un valor introducido por el usuario.
	 * @return devuelve true si el valor est� y se ha eliminado de la tabla y false si no est�.
	 */
	public boolean sacarValor (int valor){
		System.out.print("Introduzca un valor: ");
		valor = sc.nextInt(); /*El usuario introduce el valor que quiere eliminar del almacen */
		for(int i=0; i<tvalores.length; i++) {
			if(tvalores[i]==valor){
				tvalores[i]=LIBRE;
				empaquetar();
				valoresAlmacenados--; 
				return true; /*  El valor se encuentra en el almacen*/
			}
		}	
	return false; /* El valor NO se encuentra en el almacen*/
	}

	
	/**
	 * Muestra una cadena con los valores de la tabla
	 * @see java.lang.Object#toString()
	 */
	
	public String toString(){
		
		return Arrays.toString(tvalores);
	}
}
