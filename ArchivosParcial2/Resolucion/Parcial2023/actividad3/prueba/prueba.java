package actividad3.prueba;

import actividad3.LinkedBinaryTree;
import actividad3.Position;
import java.util.List;
import actividad3.Map;

public class prueba {
    public static void main(String[] args) {
        // Crear un árbol binario de ejemplo
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        var root = tree.addRoot(1);
        var left = tree.addLeft(root, 2);
        var right = tree.addRight(root, 3);
        var leftLeft = tree.addLeft(left, 4);
        var leftRight = tree.addRight(left, 5);
        var rightRight = tree.addRight(right, 6);

        // Probar externals()
        System.out.println("Nodos externos (hojas):");
        for (Position<Integer> p : tree.externals()) {
            System.out.println(p.getElement());
        }

        // Probar branchMap()
        System.out.println("\nRamas de cada hoja hasta la raíz:");
        
        Map<Position<Integer>, List<Position<Integer>>> branchMap = tree.branchMap();
        for (Position<Integer> leaf : branchMap.keySet()) {
            System.out.print("Hoja " + leaf.getElement() + ": ");
            List<Position<Integer>> branch = branchMap.get(leaf);
            for (int i = branch.size() - 1; i >= 0; i--) { // de raíz a hoja
                System.out.print(branch.get(i).getElement());
                if (i > 0) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}
