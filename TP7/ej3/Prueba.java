package ej3;

public class Prueba {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("     DEMOSTRACIÓN DEL RECORRIDO CON PILA      ");
        System.out.println("==============================================\n");

        // Crear un árbol de ejemplo
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> b = tree.addLeft(root, "B");
        Position<String> c = tree.addRight(root, "C");
        Position<String> d = tree.addRight(c, "D");
        tree.addLeft(b, "E");
        tree.addRight(b, "F");
        tree.addLeft(c, "G");
        tree.addLeft(d, "H");
        tree.addRight(d, "I");

        System.out.println("Árbol binario creado:");
        System.out.println("         A");
        System.out.println("       /   \\");
        System.out.println("      B     C");
        System.out.println("     / \\   / \\");
        System.out.println("    E   F G   D");
        System.out.println("             / \\");
        System.out.println("            H   I\n");

        // Probar el método breadthfirst() modificado (con pila)
        System.out.println("Recorrido usando pila (preorden iterativo):");
        System.out.print("Orden de visita: ");
        for (Position<String> p : tree.breadthfirst()) { // Aquí usamos el método breadthfirst modificado
            // Imprimir el elemento de cada posición visitada
            System.out.print(p.getElement() + " "); 
        }
        System.out.println("\n");

        System.out.println(">>> Este recorrido corresponde a un preorden iterativo,");
        System.out.println(">>> NO a un recorrido por niveles (anchura).");
        System.out.println("==============================================");
    }
}
