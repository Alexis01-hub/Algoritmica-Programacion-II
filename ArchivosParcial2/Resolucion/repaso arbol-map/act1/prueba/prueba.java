package prueba;

import java.util.List;
import java.util.ArrayList;
 
import act1.Map;
import act1.LinkedBinaryTree;
import act1.Position;
import act1.ProbeHashMap;

/**
 * Clase de prueba para recorrer un árbol de expresiones y obtener su notación postfija.
 */
public class prueba {
    /**
     * Retorna una lista con la expresión postfija de un árbol de expresiones.
     * Si el operando es una variable busca su valor en el Map v.
     * Si la variable no existe lanza la excepción ArithmeticException indicando el nombre de la variable.
     *
     * @param t Árbol binario de expresiones (LinkedBinaryTree<String>)
     * @param v Mapa de variables y sus valores (Map<String, Double>)
     * @return Lista de Strings con la expresión en notación postfija
     * @throws ArithmeticException si alguna variable no está en el mapa
     */
    public static List<String> postfixExpression(LinkedBinaryTree<String> t, Map<String, Double> v) {
        List<String> result = new ArrayList<>();
        if (t == null || t.isEmpty()) {
            return result;
        }
        // Recorrer el árbol en postorden usando el método postorder() de LinkedBinaryTree
        for(Position<String> p : t.postorder()) {
            String value = p.getElement();
            // Si es un operador, agregarlo directamente
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                result.add(value);
            } else {
                try {
                    // Si es un número, agregarlo directamente
                    Double.parseDouble(value); // Intentar convertir a número
                    result.add(value); // Si es un número válido, se agrega directamente
                } catch (NumberFormatException e){
                    // Si es una variable, buscar su valor en el mapa
                    Double val = v.get(value); // 
                    if (val == null) throw new ArithmeticException("Variable no existe: " + value);
                    result.add(val.toString());
                }
            }
        }
        return result;
    }

    /**
     * Método principal para probar postfixExpression.
     * Construye el árbol de la expresión (B+C)*(A-1), define los valores de las variables,
     * elimina una variable del mapa y muestra el manejo de la excepción.
     */
    public static void main(String[] args) {
        // Construir el árbol para la expresión (B+C)*(A-1)
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("*");
        Position<String> left = tree.addLeft(root, "+");
        Position<String> right = tree.addRight(root, "-");
        tree.addLeft(left, "B");
        tree.addRight(left, "C");
        tree.addLeft(right, "A");
        tree.addRight(right, "1");

        // Crear un Map de variables y asignar valores
        Map<String, Double> variables = new ProbeHashMap<>();
        variables.put("A", 2.0);
        variables.put("B", 5.0);
        variables.put("C", 8.0);

        // Eliminar una variable para forzar la excepción
        // variables.remove("B");

        try {
            List<String> postfix = postfixExpression(tree, variables);
            System.out.println("Expresión postfija: " + postfix);
        } catch (ArithmeticException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
    }
}