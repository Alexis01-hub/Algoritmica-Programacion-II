
/**
 * Demonstration of recursive factorial function.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Factorial {

  /** Computes the factorial of the given (nonnegative) integer) */
  public static int factorial(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException();     // argument must be nonnegative
    else if (n == 0)
      return 1;                                 // base case
    else
      return n * factorial(n-1);                // recursive case
  }

  public static int factorialI(int n) throws IllegalArgumentException {
    if (n < 0) {
      throw new IllegalArgumentException();     // argument must be nonnegative
    }
      int resultado = 1;          // o(1)
      for(int i = 1; i <= n; i++){    // o(n)
          resultado *= i;     //o(1)
      }
      return resultado;       // o(1)
  }
    

  /** Simple test, assuming valid integer given as command-line argument */
  public static void main(String[] args) {
    int n = 0;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
      try { System.out.println("factorial("+n+") = " + factorial(n)); }
      catch (IllegalArgumentException e) {
        System.out.println("Error: the factorial function is undefined for negative integers"); }
    }
    
    System.out.println("factorial Iterativa("+ n +") = " + factorialI(n));
    System.out.println("factorial Recursiva("+ n +") = " + factorial(n));


  }

}
