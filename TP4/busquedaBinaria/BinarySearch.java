/**
 * Clase que implementa el algoritmo de búsqueda binaria en versiones recursiva e iterativa.
 * Permite buscar un valor objetivo en un arreglo ordenado de enteros.
 */
public class BinarySearch {

  /**
   * Realiza una búsqueda binaria recursiva en un intervalo del arreglo.
   *
   * @param data   El arreglo de enteros ordenado.
   * @param target El valor objetivo a buscar.
   * @param low    El índice inferior del intervalo de búsqueda.
   * @param high   El índice superior del intervalo de búsqueda.
   * @return {@code true} si el valor objetivo se encuentra en el intervalo, {@code false} en caso contrario.
   */
  public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
      return false;                                           // intervalo vacío; no hay coincidencia
    else {
      int mid = (low + high) / 2;
            if (target == data[mid])
        return true;                                          // se encontró una coincidencia
      else if (target < data[mid])
        return binarySearch(data, target, low, mid - 1);      // buscar a la izquierda del medio
      else
        return binarySearch(data, target, mid + 1, high);     // buscar a la derecha del medio
    }
  }

  /**
   * Realiza una búsqueda binaria recursiva en todo el arreglo.
   *
   * @param data   El arreglo de enteros ordenado.
   * @param target El valor objetivo a buscar.
   * @return {@code true} si el valor objetivo se encuentra en el arreglo, {@code false} en caso contrario.
   */
  public static boolean binarySearch(int[] data, int target) {
    return binarySearch(data, target, 0, data.length - 1);   // usa la versión parametrizada
  }


  /**
   * Realiza una búsqueda binaria iterativa en todo el arreglo.
   *
   * @param data   El arreglo de enteros ordenado.
   * @param target El valor objetivo a buscar.
   * @return {@code true} si el valor objetivo se encuentra en el arreglo, {@code false} en caso contrario.
   */
  public static boolean binarySearchIterative(int[] data, int target) {
    int low = 0;
    int high = data.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (target == data[mid])          // se encontró una coincidencia
        return true;
      else if (target < data[mid])
        high = mid - 1;                 // solo considerar valores a la izquierda de mid
      else
        low = mid + 1;                  // solo considerar valores a la derecha de mid
    }
    return false;                       // el bucle terminó sin éxito
  }


  /**
   * Método principal que permite probar las implementaciones de búsqueda binaria.
   * Si se proporciona un argumento desde la línea de comandos, busca ese valor en el arreglo.
   * Si no se proporciona un argumento, muestra un mensaje indicando que se necesita un valor objetivo.
   *
   * @param args Argumentos de línea de comandos. El primer argumento debe ser un número entero.
   */
  public static void main(String[] args) {
    final int N = 5;
    int[] data = new int[N];
    for (int j = 0; j < N; j++)
        data[j] = 1 + 2 * j;

    if (args.length > 0) {
        try {
            int target = Integer.parseInt(args[0]);
            if (binarySearch(data, target))
                System.out.println("El valor " + target + " fue encontrado (recursivo).");
            else
                System.out.println("El valor " + target + " no fue encontrado (recursivo).");

            if (binarySearchIterative(data, target))
                System.out.println("El valor " + target + " fue encontrado (iterativo).");
            else
                System.out.println("El valor " + target + " no fue encontrado (iterativo).");
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número entero válido como argumento.");
        }
    } else {
        System.out.println("Por favor, proporciona un valor objetivo como argumento.");
    }
  }
}
