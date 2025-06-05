package ej4.prueba;

import ej4.hash.*;
import java.util.List;

/**
 * Prueba del método mapDepth de AbstractTree.
 */
public class prueba {
    public static void main(String[] args) {
        // Creamos un árbol binario simple para probar
        LinkedBinaryTree<String> arbol = new LinkedBinaryTree<>();
        Position<String> raiz = arbol.addRoot("A");
        Position<String> b = arbol.addLeft(raiz, "B");
        Position<String> c = arbol.addRight(raiz, "C");
        Position<String> d = arbol.addLeft(b, "D");
        Position<String> e = arbol.addRight(b, "E");
        Position<String> f = arbol.addLeft(c, "F");

        // Usamos el método mapDepth
        Map<Integer, List<String>> resultado = arbol.mapDepth();

        // Mostramos el resultado
        System.out.println("Nodos agrupados por profundidad:");
        for (Integer profundidad : resultado.keySet()) {
            System.out.println("Profundidad " + profundidad + ": " + resultado.get(profundidad));
        }
        // Resultado esperado:
        // Profundidad 0: [A]
        // Profundidad 1: [B, C]
        // Profundidad 2: [D, E, F]
        
    }
}
