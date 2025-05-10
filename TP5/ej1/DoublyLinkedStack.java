import java.util.EmptyStackException;

public class DoublyLinkedStack<T> implements Stack<T> {
    private DoublyLinkedStack<T> list;

    public DoublyLinkedStack(){
        this.list = new DoublyLinkedStack<>();
    }
    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    @Override
    public T pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    @Override
    public T top() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    
}
