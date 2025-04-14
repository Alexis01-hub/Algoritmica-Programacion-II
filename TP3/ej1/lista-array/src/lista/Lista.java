package lista;
public class Lista<E> {

	private E lista[];
	private int indice;
	private final int MAXELEM;

	public Lista(int n) {
		lista = (E[]) new Object[n];
		MAXELEM = n;
		indice = 0;
	}

	/* Agrega un elemento al final de la lista */
	public void add(E e) throws IndexOutOfBoundsException {
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		lista[indice++] = e;
	}

	/* Agrega un elemento a la lista en la posici�n p */
	public void add(int p, E e) throws IndexOutOfBoundsException {
		if (p < 0 || p > indice)
			throw new IndexOutOfBoundsException("Indice invlido: " + p);
		if (indice == MAXELEM)
			throw new IndexOutOfBoundsException("Lista llena");
		for (int i = indice ; i > p; i--)
			lista[i] = lista[i - 1];
		lista[p] = e;
		indice++;
	}

	/* Retorna el elemento que se encuentra en p */
	public E get(int p) throws IndexOutOfBoundsException {		
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice inv�lido: " + p);
		return lista[p];
	}

	/* Remueve el elemento E de la lista. Retorna null sino se encuentra */
	public E remove(E e) {
		boolean encontrado = false;
		int i;
		for (i = 0; i < indice && !encontrado; i++)
			if (lista[i].equals(e))
				encontrado = true;
		if (!encontrado)
			return null;
		return remove(i);
	}

	/* Remueve el elemento que se encuentra en la posici�n p */
	public E remove(int p) throws IndexOutOfBoundsException {
		if (p < 0 || p >= indice)
			throw new IndexOutOfBoundsException("Indice invalido: " + p);
		E e = lista[p];

		for (int i = p; i < indice - 1; i++)
			lista[i] = lista[i + 1];
		//lista[indice - 1] = null;
		indice--;
		return e;
	}

	// equals y hashCode son necesarios para las pruebas unitarias
	//----------------------------
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Lista<?>))
			return false;
		Lista<?> l = (Lista<?>) o;
		if (l.indice != indice)
			return false;
		for (int i = 0; i < indice; i++)
			if (!lista[i].equals(l.lista[i]))
				return false;
		return true;
	}

	public int hashCode() {
		int h = 0;
		for (int i = 0; i < indice; i++)
			h += lista[i].hashCode();
		return h;
	}
	//---------------------------
	public String toString(){
		String s = "";
		for(int i=0; i<indice; i++)
			s +=lista[i]+"\n";
		return s;
		 
	}
}
