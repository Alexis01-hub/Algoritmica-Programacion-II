/**
 * Demostración de dos implementaciones recursivas para calcular la potencia de un número.
 * La primera es menos eficiente, y la segunda optimiza el cálculo mediante resultados parciales.
 */
class PowerSlow {
  /** Calcula el valor de x elevado a la potencia n, para n como un entero no negativo. */
  public static double power(double x, int n) {
    if (n == 0)
      return 1;
    else
      return x * power(x, n - 1); // Multiplicación directa en cada paso
  }
}

public class Power {

  /** Calcula el valor de x elevado a la potencia n, para n como un entero no negativo. */
  public static double power(double x, int n) {
    if (n == 0)
      return 1;
    else {
      double partial = power(x, n / 2); // División truncada de n
      double result = partial * partial;
      if (n % 2 == 1) // Si n es impar, incluye un factor adicional de x
        result *= x;
      return result;
    }
  }

  public static void main(String[] args) {
    final int BASE = 3; // Base para las pruebas
    final int EXPONENT = 11; // Exponente máximo para las pruebas

    // Medir tiempo para PowerSlow
    long startSlow = System.nanoTime();
    double resultSlow = PowerSlow.power(BASE, EXPONENT);
    long endSlow = System.nanoTime();
    System.out.println("Resultado (PowerSlow): " + resultSlow);
    System.out.println("Tiempo (PowerSlow): " + (endSlow - startSlow) + " nanosegundos");

    // Medir tiempo para Power
    long startFast = System.nanoTime();
    double resultFast = Power.power(BASE, EXPONENT);
    long endFast = System.nanoTime();
    System.out.println("Resultado (Power): " + resultFast);
    System.out.println("Tiempo (Power): " + (endFast - startFast) + " nanosegundos");

    // Verificar si los resultados coinciden
    if (Math.abs(resultSlow - resultFast) < 1e-9) {
      System.out.println("Ambos métodos producen el mismo resultado.");
    } else {
      System.out.println("Los métodos producen resultados diferentes.");
    }
  }
}
