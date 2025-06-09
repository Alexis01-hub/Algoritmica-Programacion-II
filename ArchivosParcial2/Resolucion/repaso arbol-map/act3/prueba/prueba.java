package prueba;


import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import net.datastructures.TreeMap;

public class prueba {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        Position<String> root = tree.addRoot("F");
        Position<String> left = tree.addLeft(root, "B");
        Position<String> right = tree.addRight(root, "G");
        // izquierda del arbol
        tree.addLeft(left, "A");
        Position<String> leftRight = tree.addRight(left, "D");
        tree.addLeft(leftRight, "C");
        tree.addRight(leftRight,"F");
        // derecha del arbol
        Position<String> rightRight = tree.addRight(right, "F");
        tree.addLeft(rightRight, "H");

        for(Position<String> p : tree.positions()) {
            System.out.println("Elemento: " + p.getElement() + ", Profundidad: " + tree.depth(p));
        }

        TreeMap<String, String> mp = new TreeMap<String, String>();
        mp.put("F", "Z");
        mp.put("C", "W");

        System.out.println("----- reemplazo -----");

        int replacedCount = tree.replaceAll(mp);
        System.out.println("Cantidad de reemplazos: " + replacedCount);
        System.out.println("----- elementos del arbol -----");
        for (Position<String> p : tree.positions()) {
            System.out.println("Elemento: " + p.getElement() + ", Profundidad: " + tree.depth(p));
        }




    }
}
