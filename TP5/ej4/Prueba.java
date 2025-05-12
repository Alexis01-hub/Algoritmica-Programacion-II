package ej4;

public class Prueba {
    
    public static void main(String[] args) {
        // Crear una pila y agregar elementos
        LinkedStack<Integer> originalStack = new LinkedStack<>();
        originalStack.push(10);
        originalStack.push(20);
        originalStack.push(30);

        // Clonar la pila
        LinkedStack<Integer> clonedStack = originalStack.clone();

        // Eliminar un elemento de la pila original
        originalStack.pop();

        // Mostrar los elementos de la pila original (con un elemento menos)
        System.out.println("Elementos de la pila original (con un elemento menos):");
        while (!originalStack.isEmpty()) {
            System.out.println(originalStack.pop());
        }

        // Mostrar los elementos de la pila clonada
        System.out.println("Elementos de la pila clonada:");
        while (!clonedStack.isEmpty()) {
            System.out.println(clonedStack.pop());
        }
    }
}
