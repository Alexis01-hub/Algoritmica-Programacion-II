import java.util.Stack;
public class PruebaStack{

    public static main(String[] args){
        //pila implementada con array
        Stack<Integer> arrayStack = new ArrayStack<>();
        long arrayStackTime = tiempoStack(arrayStack, 1000);
        System.out.println("Tiempo de la pila implementada con array: " + arrayStackTime + " nanosegundos");

        //pila implementada con lista enlazada
        Stack<Integer> linkedStack = new LinkedStack<>();
        long linkedStackTime = tiempoStack(linkedStack, 1000);
        System.out.println("Tiempo de la pila implementada con lista enlazada: " + linkedStackTime + " nanosegundos");

        //pila implementada con lista doblemente enlazada
        Stack<Integer> doublyLinkedStack = new DoublyLinkedStack<>();
        long doublyLinkedStackTime = tiempoStack(doublyLinkedStack, 1000);
        System.out.println("Tiempo de la pila implementada con lista doblemente enlazada: " + doublyLinkedStackTime + " nanosegundos");

    }

    private static long tiempoStack(Stack<Integer> stack, int n){
        long startTime = System.nanoTime();

        //operacion push
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        //operacion pop
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    } 
}