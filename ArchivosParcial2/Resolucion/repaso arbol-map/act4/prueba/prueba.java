package prueba;

import act4.Position;
import act4.LinkedBinaryTree;

public class prueba {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        
        Position<String> root = tree.addRoot("F");
        Position<String> left = tree.addLeft(root, "B");
        Position<String> right = tree.addRight(root, "G");
        Position<String> leftLeft = tree.addLeft(left, "A");
        Position<String> leftRight = tree.addRight(left, "D");
        Position<String> rightRight = tree.addRight(right, "I");
        Position<String> leftRightLeft = tree.addLeft(leftRight, "C");
        Position<String> leftRightRight = tree.addRight(leftRight, "E");
        Position<String> rightRightLeft = tree.addLeft(rightRight, "H");

        // llama al metodo path
        System.out.println("----- Caminos desde la raiz -----");
        System.out.println("camino de F a E");
        for (Position<String> p : tree.path(root, leftRightRight)) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println("\ncamino de F a H");
        for (Position<String> p : tree.path(root, rightRightLeft)) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println("\ncamino de A a I");
        for (Position<String> p : tree.path(leftLeft, rightRight)) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println("\ncamino de B a B");
        for (Position<String> p : tree.path(left, left)) {
            System.out.print(p.getElement() + " ");
        }

        System.out.println("\ncamino de E a A");
        for (Position<String> p : tree.path(leftRightRight, leftLeft)) {
            System.out.print(p.getElement() + " ");
        }
    }
}
