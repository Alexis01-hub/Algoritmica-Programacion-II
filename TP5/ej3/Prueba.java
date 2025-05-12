public class Prueba {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Clonando la pila
        ArrayStack<Integer> clonedStack = stack.clone();

        // Modificando la pila original
        stack.pop();

        // Imprimiendo los elementos de ambas pilas
        System.out.println("Pila original:");
        for (int i = 0; i < 2; i++) {
            System.out.println(stack.pop());
        }

        System.out.println("Pila clonada:");
        for (int i = 0; i < 3; i++) {
            System.out.println(clonedStack.pop());
        }
    }
}
