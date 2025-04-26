public class iterativoSearch {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        double[] data = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 1048576, 2097152};
        int target = 256;
        // Comparar métodos
        boolean iterativeResult = iterativeBinarySearch(data, target);
        System.out.println("Resultado con método iterativo: " + iterativeResult);
        long endTime = System.nanoTime();

        long elapsed = endTime - startTime;
        System.out.println("TARDO: " + elapsed + " milisegundos");
    }

    
    public static boolean iterativeBinarySearch(double[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true; // encontrado
            } else if (target < data[mid]) {
                high = mid - 1; // buscar en la mitad izquierda
            } else {
                low = mid + 1; // buscar en la mitad derecha
            }
        }
        return false; // no encontrado
    }
}
