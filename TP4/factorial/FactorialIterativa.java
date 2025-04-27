package factorial;

public class FactorialIterativa {
    
    public static int factorialI(int n){
        int resultado = 1;          // o(1)
        for(int i = 1; i <= n; i++){    // o(n)
            resultado *= i;     //o(1)
        }
        return resultado;       // o(1)
    }
    // Complejidad temporal: O(n)
}
