import java.util.Arrays;

public class Conjunto<T> {
    private T[] data; // Arreglo genérico para almacenar los elementos del conjunto.
    private int p; // Contador que indica la cantidad de elementos en el conjunto.

    /**
     * Constructor que inicializa el conjunto con una capacidad específica.
     * 
     * @param capacity Capacidad máxima del conjunto.
     */
    public Conjunto(int capacity) {
        data = (T[]) new Object[capacity]; // Inicializa el arreglo genérico con la capacidad dada.
        p = 0; // Inicializa el contador de elementos en 0.
    }

    /**
     * Inserta un elemento al conjunto si el mismo no está.
     * Si se supera la capacidad del conjunto, no hace nada.
     * 
     * @param d Elemento a insertar en el conjunto.
     */
    public void insertarElemento(T d) {
        if (p < data.length && !find(d)) { // Si hay espacio y el elemento no existe en el conjunto.
            data[p] = d; // Se inserta el elemento.
            p++; // Incrementa el contador de elementos.
        }
    }

    /**
     * Retorna la cantidad de elementos de un conjunto.
     * 
     * @return Número de elementos en el conjunto.
     */
    public int cardinalidad() {
        if (p < data.length) { // Si hay espacio en el conjunto.
            return p; // Retorna la cantidad de elementos.
        } else { // Si no hay espacio en el conjunto.
            return data.length; // Retorna la capacidad del conjunto.
        }
    }

    /**
     * Retorna un nuevo conjunto con la unión del conjunto actual con el conjunto c.
     * 
     * @param c Conjunto con el que se realizará la unión.
     * @return Nuevo conjunto que contiene la unión de ambos conjuntos.
     */
    public Conjunto<T> union(Conjunto<T> c) {
        Conjunto<T> union = new Conjunto<T>(this.cardinalidad() + c.cardinalidad()); // Crea un nuevo conjunto con la suma de las cardinalidades.
        for (int i = 0; i < this.cardinalidad(); i++) { // Recorre el conjunto actual.
            union.insertarElemento(this.data[i]); // Inserta los elementos del conjunto actual en el nuevo conjunto.
        }
        
        for (int i = 0; i < c.cardinalidad(); i++) { // Recorre el conjunto c.
            T temp = c.data[i]; // Guarda el elemento en una variable temporal.
            if (!union.find(temp)) { // Si el elemento no existe en el nuevo conjunto.
                union.insertarElemento(temp); // Inserta el elemento en el nuevo conjunto.
            }
        }
        return union; // Retorna el nuevo conjunto.
    }

    /**
     * Retorna un nuevo conjunto con la intersección del conjunto actual con el conjunto c.
     * 
     * @param c Conjunto con el que se realizará la intersección.
     * @return Nuevo conjunto que contiene la intersección de ambos conjuntos.
     */
    public Conjunto<T> interseccion(Conjunto<T> c) {
        Conjunto<T> interseccion = new Conjunto<T>(this.cardinalidad() + c.cardinalidad()); // Crea un nuevo conjunto con la suma de las cardinalidades.
        for (int i = 0; i < this.cardinalidad(); i++) { // Recorre el conjunto actual.
            T temp = this.data[i]; // Guarda el elemento en una variable temporal.
            if (c.find(temp)) { // Si el elemento existe en el conjunto c.
                interseccion.insertarElemento(temp); // Inserta el elemento en el nuevo conjunto.
            }
        }
        return interseccion; // Retorna el nuevo conjunto.
    }

    /**
     * Retorna si dos conjuntos tienen los mismos elementos.
     * 
     * @param c Conjunto con el que se comparará.
     * @return true si ambos conjuntos tienen los mismos elementos, false en caso contrario.
     */
    public boolean iguales(Conjunto<T> c) {
        if (this.cardinalidad() != c.cardinalidad()) { // Si la cantidad de elementos de los conjuntos no es la misma.
            return false; // Retorna falso.
        }
        for (int i = 0; i < this.cardinalidad(); i++) { // Recorre el conjunto actual.
            T temp = this.data[i]; // Guarda el elemento en una variable temporal.
            if (!c.find(temp)) { // Si el elemento no existe en el conjunto c.
                return false; // Retorna falso.
            }
        }
        return true; // Retorna verdadero si todos los elementos del conjunto actual existen en el conjunto c.
    }

    /**
     * Retorna si un elemento está en el conjunto.
     * 
     * @param find Elemento a buscar en el conjunto.
     * @return true si el elemento está en el conjunto, false en caso contrario.
     */
    private boolean find(T find) {
        for (int i = 0; i < p; i++) { // Recorre el conjunto actual.
            if (data[i].equals(find)) { // Si el elemento existe en el conjunto actual.
                return true; // Retorna verdadero.
            }
        }
        return false; // Retorna falso si el elemento no existe en el conjunto actual.
    }

    /**
     * Retorna una representación en formato de cadena del conjunto.
     * 
     * @return Cadena que representa el conjunto.
     */
    @Override
    public String toString() {
        return " Conjunto [data=" + Arrays.toString(data) + ", p=" + p + "]"; // Retorna el conjunto en formato de cadena.
    }
}
