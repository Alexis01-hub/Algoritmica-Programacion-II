package factorial;

public class FactorialRecursiva {
    
    public static int factorialR(int n){
        if(n == 1){             //0(1)
            return 1;         // o(1)
        }
        return n * factorialR(n - 1);   // o(n)
    }
    // Complejidad temporal: O(n)
}
