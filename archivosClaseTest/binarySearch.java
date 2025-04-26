public class binarySearch {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Cambiado a nanoTime

        double[] data = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 1048576, 2097152};
        int target = 256;
        int low = 0;
        int high = data.length - 1;
        boolean result = binariSearch(data, target, low, high);
        System.out.println("El número esta en el arreglo? : " + result);
        long endTime = System.nanoTime(); // Cambiado a nanoTime

        long elapsed = endTime - startTime;
        System.out.println("TARDO: " + elapsed + " nanosegundos");
    }

    public static boolean binariSearch(double[] data, int target, int low, int high) {
        if (low > high) {
            return false; // intervalo vacío; no encontrado
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true; // encontrado
            } else if (target < data[mid]) {
                return binariSearch(data, target, low, mid - 1); // buscar en la mitad izquierda
            } else {
                return binariSearch(data, target, mid + 1, high); // buscar en la mitad derecha
            }
        }
    }

}