package ej2;
public class prueba {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Elemento en la parte superior: " + stack.peek());
        System.out.println("Tamaño de la pila: " + stack.size());

        while (!stack.isEmpty()) {
            System.out.println("Elemento eliminado: " + stack.pop());
        }

        System.out.println("¿La pila está vacía? " + stack.isEmpty());
    }    
}

