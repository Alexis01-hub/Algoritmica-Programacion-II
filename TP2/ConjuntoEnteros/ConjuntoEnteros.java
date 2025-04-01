package ConjuntoEnteros;

/**
 * Clase que representa un conjunto de enteros en el rango de 0 a 100.
 * Utiliza un arreglo de valores booleanos para indicar la presencia de elementos en el conjunto.
 * 
 * Métodos principales:
 * - insertarElemento: Inserta un entero en el conjunto.
 * - eliminarElemento: Elimina un entero del conjunto.
 * - aStringConjunto: Devuelve una representación en cadena de los elementos del conjunto.
 * - esIgualA: Determina si dos conjuntos son iguales.
 * - union: Crea un nuevo conjunto con la unión de dos conjuntos.
 * - interseccion: Crea un nuevo conjunto con la intersección de dos conjuntos.
 * - diferencia: Crea un nuevo conjunto con la diferencia entre dos conjuntos.
 */
public class ConjuntoEnteros {
    
    private boolean[] conjunto; //Arreglo de booleans que representa el conjunto
    private static final int MAX = 101; // Tamaño máximo del conjunto (0 a 100)
    
    /**
     * Constructor que inicializa el conjunto como vacío (todos los valores en false).
     */
    public ConjuntoEnteros() {
        conjunto = new boolean[MAX]; // Inicializa el arreglo con el tamaño máximo
    }

    /**
     * Inserta un elemento en el conjunto.
     * 
     * @param k El entero a insertar (debe estar en el rango 0-100).
     */
    public void insertarElemento(int k){
        if (k >= 0 && k < MAX) {
            conjunto[k] = true; // Marca el elemento como presente en el conjunto
        }else {
            System.out.println("Elemento fuera de rango (0-100): " + k);
        }
    }

    /**
     * Elimina un elemento del conjunto.
     * 
     * @param k El entero a eliminar (debe estar en el rango 0-100).
     */
    public void eliminarElemento(int k){
        if (k >= 0 && k < MAX) {
            conjunto[k] = false; // Marca el elemento como ausente en el conjunto
        }else {
            System.out.println("Elemento fuera de rango (0-100): " + k);
        }
    }


    /**
     * Crea un nuevo conjunto que representa la unión de este conjunto con otro.
     * 
     * @param otroConjunto El conjunto con el que se realizará la unión.
     * @return Un nuevo conjunto que contiene la unión de ambos conjuntos.
     */
    public ConjuntoEnteros union(ConjuntoEnteros otroConjunto){
        ConjuntoEnteros unionConjunto = new ConjuntoEnteros();
        for(int i = 0; i<MAX; i++){
            unionConjunto.conjunto[i] = this.conjunto[i] || otroConjunto.conjunto[i]; // Marca true si al menos uno de los conjuntos tiene el elemento
        }
    return unionConjunto; // Devuelve el nuevo conjunto de unión
    }

    /**
     * Crea un nuevo conjunto que representa la intersección de este conjunto con otro.
     * 
     * @param otroConjunto El conjunto con el que se realizará la intersección.
     * @return Un nuevo conjunto que contiene la intersección de ambos conjuntos.
     */
    public ConjuntoEnteros interseccion(ConjuntoEnteros otroConjunto){
        ConjuntoEnteros interseccionConjunto = new ConjuntoEnteros();
        for(int i = 0; i<MAX; i++){
            interseccionConjunto.conjunto[i] = this.conjunto[i] && otroConjunto.conjunto[i]; // Marca true si ambos conjuntos tienen el elemento
        }
    return interseccionConjunto; // Devuelve el nuevo conjunto de intersección
    }

    /**
     * Crea un nuevo conjunto que representa la diferencia entre este conjunto y otro.
     * 
     * @param otroConjunto El conjunto con el que se realizará la diferencia.
     * @return Un nuevo conjunto que contiene los elementos que están en este conjunto pero no en el otro.
     */
    public ConjuntoEnteros diferencia(ConjuntoEnteros otroConjunto){
        ConjuntoEnteros diferenciaConjunto = new ConjuntoEnteros();
        for(int i = 0; i<MAX; i++){
            diferenciaConjunto.conjunto[i] = this.conjunto[i] && !otroConjunto.conjunto[i]; // Marca true si el elemento está en el primer conjunto y no en el segundo
        }
        return diferenciaConjunto; // Devuelve el nuevo conjunto de diferencia
    }

    @Override
    public int hashCode() {
        int hash = 7; // Inicializa el valor del hash
        for (int i = 0; i < MAX; i++) {
            hash = 31 * hash + (conjunto[i] ? 1 : 0); // Calcula el hash combinando los valores booleanos
        }
        return hash; // Devuelve el valor del hash
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica si son la misma instancia
        if (obj == null || !(obj instanceof ConjuntoEnteros)) return false; // Verifica si el objeto es nulo o del mismo tipo
        ConjuntoEnteros otroConjunto = (ConjuntoEnteros) obj; // Convierte el objeto a ConjuntoEnteros
        for (int i = 0; i < MAX; i++) {
            if (this.conjunto[i] != otroConjunto.conjunto[i]) return false; // Compara los elementos de ambos conjuntos
        }
        return true; // Devuelve true si todos los elementos son iguales
    }
    
    /**
    * Devuelve una representación en cadena de los elementos presentes en el conjunto.
    * 
    * @return Una cadena con los elementos del conjunto separados por espacios.
    */
    public String aStringConjunto(){
       StringBuilder sb = new StringBuilder();
        for(int i =0; i<MAX; i++){
            if (conjunto[i]) {
                sb.append(i).append(" ");
            }
        }
        return sb.toString().trim(); // Devuelve la cadena sin espacios al final
    }
}

