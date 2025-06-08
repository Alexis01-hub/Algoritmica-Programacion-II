package actividad2.prueba;

import actividad2.LinkedBinaryTree;

public class prueba {
    public static void main(String[] args) {
        // Crear una instancia de LinkedBinaryTree
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        
        // Insertar nodos para formar un árbol completo
        var root = tree.addRoot(1);
        var left = tree.addLeft(root, 2);
        var right = tree.addRight(root, 3);
        tree.addLeft(left, 4);
        tree.addRight(left, 5);
        tree.addLeft(right, 6);
        tree.addRight(right, 7);

        System.out.println("¿El árbol es completo? " + tree.complete()); // Debe imprimir true

        // Quitar una hoja para que no sea completo
        tree.remove(tree.left(right)); // eliminar el nodo 6, es decir elimina la hoja que este a la izquierda del nodo 3



        System.out.println("¿El árbol es completo después de quitar un nodo? " + tree.complete()); // Debe imprimir false      
    }
}
