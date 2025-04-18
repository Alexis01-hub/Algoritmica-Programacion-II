import java.time.LocalDate;

public class test2 {
    public static void main(String[] args) {
        // a) Crear titulares
        Titular titular1 = new Titular("Juan Pérez", "20-12345678-9");
        Titular titular2 = new Titular("María Gómez", "27-87654321-0");
        Titular titular3 = new Titular("Carlos López", "23-45678901-2");

        // b) Crear bienes con las alícuotas especificadas
        Inmueble inmueble1 = new Inmueble("2023-01-15", titular1, "12345", 
                                        500000, 0.006, 0.002, false); // Edificado
        Inmueble inmueble2 = new Inmueble("2023-02-20", titular2, "67890", 
                                        300000, 0.006, 0.002, true);  // Baldío
        
        // Vehículos: uno con menos de 20 años y otro con más
        int añoActual = LocalDate.now().getYear();
        Vehiculo vehiculo1 = new Vehiculo("2023-03-10", titular1, "ABC123", 
                                        "Ford", añoActual - 5, 0.004, 200000);
        Vehiculo vehiculo2 = new Vehiculo("2023-04-05", titular3, "XYZ789", 
                                        "Fiat", añoActual - 25, 0.004, 150000);

        // Arreglo de bienes
        Bien[] bienes = {inmueble1, inmueble2, vehiculo1, vehiculo2};

        // c) Recorrer el arreglo y mostrar impuestos
        System.out.println("=== IMPUESTOS DE TODOS LOS BIENES ===");
        double totalImpuestos = 0;
        for (Bien bien : bienes) {
            double impuesto = bien.calcularImpuesto();
            System.out.println(bien.getClass().getSimpleName() + ":");
            System.out.println("  " + bien);
            System.out.println("  Impuesto a cobrar: $" + impuesto);
            System.out.println("----------------------------------");
            totalImpuestos += impuesto;
        }
        System.out.println("TOTAL DE IMPUESTOS A COBRAR: $" + totalImpuestos);

        // d) Mostrar impuestos para un titular específico (Juan Pérez)
        System.out.println("\n=== IMPUESTOS PARA TITULAR: Juan Pérez ===");
        double totalTitular = 0;
        for (Bien bien : bienes) {
            if (bien.getTitular().getNombre().equals("Juan Pérez")) {
                double impuesto = bien.calcularImpuesto();
                System.out.println(bien.getClass().getSimpleName() + ":");
                System.out.println("  " + bien);
                System.out.println("  Impuesto a cobrar: $" + impuesto);
                System.out.println("----------------------------------");
                totalTitular += impuesto;
            }
        }
        System.out.println("TOTAL PARA EL TITULAR: $" + totalTitular);
    }
}