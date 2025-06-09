package prueba;

import act2.Position;
import act2.LinkedBinaryTree;
import act2.TreeMap;
import java.util.List;

public class prueba {
    public static void main(String[] args) {
        // Crear un árbol binario
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Agregar nodos al árbol
        Position<String> root = tree.addRoot("F");
        Position<String> left = tree.addLeft(root, "B");
        Position<String> right = tree.addRight(root, "G");
        tree.addLeft(right, "A");
        Position<String> leftRight = tree.addRight(left, "D");
        Position<String> rightRight = tree.addRight(right, "F");
        tree.addLeft(leftRight, "C");
        tree.addRight(leftRight, "F");
        tree.addLeft(rightRight, "H");

        // Llamar al método mapDepth
        TreeMap<Integer, List<String>> depthMap = tree.mapDepth();

        // Verificar las posiciones del árbol
        System.out.println("Posiciones del árbol:");
        for (Position<String> p : tree.positions()) {
            System.out.println("Elemento: " + p.getElement() + ", Profundidad: " + tree.depth(p));
        }

        // Verificar el mapa de profundidades
        System.out.println("Mapa de profundidades:");
        for (Integer depth : depthMap.keySet()) {
            System.out.println("Profundidad " + depth + ": " + depthMap.get(depth));
        }
    }
}
