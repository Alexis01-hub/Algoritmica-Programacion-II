public class Lista<E> {

	private E lista[];
	private int indice;
	private final int MAXELEM;

	public Lista(int n) {
		lista = (E[]) new Object[n];
		MAXELEM = n;
		indice = 0;
	}
	/**
	 *  Agrega un elemento al final de la lista. Si la lista esta llena lanza una
	 *  IndexOutOfBoundsException. 
	 *  @param e
	 *  @throws IndexOutOfBoundsException
	 */
	public void add(E e) throws IndexOutOfBoundsException {
		if (indice == MAXELEM) //si el indice supera el maximo de elementos lanza una exepcion
			throw new IndexOutOfBoundsException("Lista llena");
		lista[indice++] = e; //agrega el elemento al final de la lista y aumenta el indice.
	}
	/**
	 *  Agrega un elemento a la lista en la posicion p. Si la lista esta llena lanza
	 *  IndexOutOfBoundsException. 
	 * @param p
	 * @param e
	 * @throws IndexOutOfBoundsException
	 * 
	 */
	public void add(int p, E e) throws IndexOutOfBoundsException {
		if (indice == MAXELEM) 
			throw new IndexOutOfBoundsException("Lista llena"); //si el indice supera el maximo de elementos lanza una exepcion
		if (p < 0 || p > indice) //si la posicion es menor a 0 o mayor al indice lanza una exepcion
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		for (int i = indice; i > p; i--) //mueve los elementos a la derecha
			lista[i] = lista[i - 1];
		lista[p] = e; //agrega el elemento en la posicion p
		indice++; //aumenta el indice
	}
	
	/**
	* Retorna el elemento que se encuentra en la posicion p. Si la lista esta vacia
	* lanza una IndexOutOfBoundsException. Si p es menor que 0 o mayor que el.
	* @param p
	* @throws IndexOutOfBoundsException
	* @return lista[p]

	*/
	public E get(int p) throws IndexOutOfBoundsException {		
		if (p < 0 || p >= indice) //si la posicion es menor a 0 o mayor al indice lanza una exepcion
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		return lista[p]; //retorna el elemento que se encuentra en la posicion p
	}
	/**
	 *  
	 * 
	 * @param e
	 * 
	 */
	public E remove(E e) {
		boolean encontrado = false;
		int i;
		for(i =0;i<indice && !encontrado;i++) //recorre la lista buscando el elemento
			if(lista[i].equals(e)) //si encuentra el elemento lo marca como encontrado
				encontrado = true;
		if(!encontrado) //si no encuentra el elemento lanza una exepcion
			return null;
		return remove(i);
	}
	/**
	 *  Remueve el elemento que se encuentra en la posicion p. 
	 *  Si la lista esta vacia lanza una IndexOutOfBoundsException. 
	 *  Si p es menor que 0 o mayor que el indice lanza una IndexOutOfBoundsException.
	 * @param p
	 * @throws IndexOutOfBoundsException
	 * @return lista[p]
	 */
	
	public E remove(int p) throws IndexOutOfBoundsException {
		if (p < 0 || p >= indice) //si la posicion es menor a 0 o mayor al indice lanza una exepcion
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		E e = lista[p]; //guarda el elemento que se encuentra en la posicion p
		for (int i = p; i < indice - 1; i++) //mueve los elementos a la izquierda
			lista[i] = lista[i + 1];
		lista[indice - 1] = null; // limpia la última posición
		indice--; //disminuye el indice
		return e;
	}
	
	public String toString(){
		String s = "";
		for(int i=0; i<indice; i++)
			s +=lista[i]+"\n";
	return s;
		 
	}
}
