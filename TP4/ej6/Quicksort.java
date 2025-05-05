package tp04;

public class Quicksort {
        private int[] numbers;
        private int number; 
        
        public void sort(int[] values) {
                // Verificar si el array está vacío o es nulo
                if (values == null || values.length == 0) {
                        return; // retornar sin hacer nada
                }
                this.numbers = values; 
                number = values.length; 
                quicksort(0, number - 1);
        }

        private void quicksort(int low, int high) {
                int i = low, j = high;
                // Obtener el elemento pivote del medio de la lista
                int pivot = numbers[low + (high - low) / 2];

                // Dividir en dos listas
                while (i <= j) {
                        // Si el valor actual de la lista izquierda es menor que el elemento pivote,
                        // entonces obtener el siguiente elemento de la lista izquierda
                        while (numbers[i] < pivot) {
                                i++;
                        }
                        // Si el valor actual de la lista derecha es mayor que el elemento pivote,
                        // entonces obtener el siguiente elemento de la lista derecha
                        while (numbers[j] > pivot) {
                                j--;
                        }

                        // Si hemos encontrado un valor en la lista izquierda que es mayor que
                        // el elemento pivote y si hemos encontrado un valor en la lista derecha
                        // que es menor que el elemento pivote, entonces intercambiamos los valores.
                        // Como hemos terminado, podemos incrementar i y j
                        if (i <= j) {
                                exchange(i, j);
                                i++;
                                j--;
                        }
                }
                // Recursión
                if (low < j)
                        quicksort(low, j);
                if (i < high)
                        quicksort(i, high);
        }

        private void exchange(int i, int j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
        }
}