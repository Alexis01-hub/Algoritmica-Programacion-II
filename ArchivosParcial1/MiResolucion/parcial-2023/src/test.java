public class test {
    
    public static void main(String[] args) {
        // Crear un objeto Vehiculo
        Vehiculo vehiculo = new Vehiculo ("2023-01-01", new Titular("Juan", "Pérez"), "ABC123", "Toyota", 2020, 0.02, 20000);
        // Crear un objeto Inmueble
        Inmueble inmueble = new Inmueble("2023-01-01", new Titular("Ana", "Gómez"), "123456", 300000, 0.01, 0.015, false);
        // Crear un objeto Bien
        Bien bien = new Bien("2023-01-01", new Titular("Pedro", "López")) {
            @Override
            public double calcularImpuesto() {
                return 0;
            }
        };
        // Imprimir los objetos
        System.out.println(vehiculo);
        System.out.println(inmueble);
        System.out.println(bien);
        // Calcular y mostrar el impuesto
        System.out.println("Impuesto Vehiculo: " + vehiculo.calcularImpuesto());
        System.out.println("Impuesto Inmueble: " + inmueble.calcularImpuesto());
        System.out.println("Impuesto Bien: " + bien.calcularImpuesto());
        // Comparar objetos
        System.out.println("Vehiculo e Inmueble son iguales: " + vehiculo.equals(inmueble));
        System.out.println("Vehiculo e Inmueble son iguales: " + vehiculo.equals(vehiculo));
        System.out.println("Inmueble e Bien son iguales: " + inmueble.equals(bien));
        System.out.println("Bien e Bien son iguales: " + bien.equals(bien));

    }
}
