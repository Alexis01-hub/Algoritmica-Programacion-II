
import java.util.Arrays;

public class Conjunto<T> {
	private T[] data;
	private int p;

	public Conjunto(int capacity) {
		data = (T[]) new Object[capacity]; // legal, but compiler warning
		p = 0;
	}

	/**
	 * Inserta un elemento al conjunto si el mismo no esta
	 * Si se supera la capacidad del conjunto no hace nada
	 * 
	 */
	public void insertarElemento(T d) {
		if (p < data.length && !find(d)) { //si hay espacio y no existe el elemento en el conjunto 
			data[p] = d; //se inserta el elemento
			p++; 
		}

	}

	/**
	 * Retorna la cantidad de elementos de un conjunto
	 * 
	 */
	public int cardinalidad() {
		if (p < data.length) { //si hay espacio en el conjunto
			return p; //retorna la cantidad de elementos
		}
		else { //si no hay espacio en el conjunto
			return data.length; //retorna la capacidad del conjunto
		}

	}

	/**
	 * Retorna un nuevo conjunto con la union del conjunto actual con el conjunto c
	 * 
	 */
	public Conjunto<T> union(Conjunto<T> c) {
		Conjunto<T> union = new Conjunto<T>(this.cardinalidad() + c.cardinalidad()); //crea un nuevo conjunto con la suma de los dos conjuntos
		//se crea un nuevo conjunto con la capacidad de la suma de los dos conjuntos
		for (int i = 0; i < this.cardinalidad(); i++) { //recorre el conjunto actual
			union.insertarElemento(this.data[i]); //inserta los elementos del conjunto actual en el nuevo conjunto
		}
		
		for (int i = 0; i < c.cardinalidad(); i++) { //recorre el conjunto c
			T temp = c.data[i]; //guarda el elemento en una variable temporal
			if (!union.find(temp)) { //si el elemento no existe en el nuevo conjunto
				union.insertarElemento(temp); //inserta el elemento en el nuevo conjunto
			}
		}
		return union; //retorna el nuevo conjunto
	}

	/**
	 * Retorna un nuevo conjunto con la interseccion del conjunto actual con el
	 * conjunto c
	 * 
	 */
	public Conjunto<T> interseccion(Conjunto<T> c) {
		Conjunto<T> interseccion = new Conjunto<T>(this.cardinalidad() + c.cardinalidad()); //crea un nuevo conjunto con la suma de los dos conjuntos
		//se crea un nuevo conjunto con la capacidad de la suma de los dos conjuntos
		for (int i = 0; i < this.cardinalidad(); i++) { //recorre el conjunto actual
			T temp = this.data[i]; //guarda el elemento en una variable temporal
			if (c.find(temp)) { //si el elemento existe en el conjunto c
				interseccion.insertarElemento(temp); //inserta el elemento en el nuevo conjunto
			}
		}
		return interseccion; //retorna el nuevo conjunto
	}

	/**
	 * Retorna si dos conjuntos tienen los mismos elementos
	 * 
	 */
	public boolean iguales(Conjunto<T> c) {
		if (this.cardinalidad() != c.cardinalidad()) { //si la cantidad de elementos de los conjuntos no es la misma
			return false; //retorna falso
		}
		for (int i = 0; i < this.cardinalidad(); i++) { //recorre el conjunto actual
			T temp = this.data[i]; //guarda el elemento en una variable temporal
			if (!c.find(temp)) { //si el elemento no existe en el conjunto c
				return false; //retorna falso
			}
		}
		return true; //retorna verdadero si todos los elementos del conjunto actual existen en el conjunto c
	}

	/**
	 * Retorna si un elemnto esta en el conjunto
	 * 
	 */
	private boolean find(T find) {
		for (int i = 0; i < p; i++) { //recorre el conjunto actual
			if (data[i].equals(find)) { //si el elemento existe en el conjunto actual
				return true; //retorna verdadero
			}
		}
		//si el elemento no existe en el conjunto actual
		return false;
	}

	@Override
	public String toString() {
		return " Conjunto [data=" + Arrays.toString(data) + ", p=" + p + "]"; //retorna el conjunto en formato de cadena

	}

}
