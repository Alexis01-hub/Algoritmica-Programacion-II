public interface Stack<T>{
    void push(T element);
    T pop();
    T top();
    boolean isEmpty();
    int size();
}
