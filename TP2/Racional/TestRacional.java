package Racional;

/**
 * Clase de prueba para la clase Racional.
 * Permite verificar el correcto funcionamiento de las operaciones aritméticas
 * y otros métodos de la clase Racional.
 */
public class TestRacional {
    /**
     * Método principal para ejecutar las pruebas de la clase Racional.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear dos números racionales
        Racional r1 = new Racional(5, 4);
        Racional r2 = new Racional(1, 6);
        Racional r3 = new Racional(10, 8);

        // Ver los atributos de un objeto
        System.out.println("Numerador de r1: " + r1.getNumerador());
        System.out.println("Denominador de r1: " + r1.getDenominador());

        // Cambiar los atributos de un objeto
        r1.setNumerador(3);
        r1.setDenominador(5);

        // Ver un objeto
        System.out.println("r1: " + r1);

        // Realizar operaciones con racionales
        System.out.println(r1 + " + " + r2 + " = " + r1.suma(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.resta(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiplicacion(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.division(r2));
        System.out.println(r1 + " ^ 2 = " + r1.potencia(2));

        // Operaciones encadenadas
        Racional r4 = r1.suma(r2).suma(r3);
        System.out.println(r1 + " + " + r2 + " + " + r3 + " = " + r4);

        // Simplificación
        Racional r5 = Racional.simplificar(r4);
        System.out.println(r1 + " + " + r2 + " + " + r3 + " = " + r5);

        // Prueba si dos objetos son iguales (estado)
        if (r1.equals(r2))
            System.out.println(r1 + " es igual a " + r2);
        else
            System.out.println(r1 + " es distinto a " + r2);

        r1.setDenominador(4);
        if (r1.equals(r2))
            System.out.println(r1 + " es igual a " + r2);
        else
            System.out.println(r1 + " es distinto a " + r2);

        if (r4.equals(r5))
            System.out.println(r4 + " es igual a " + r5);
        else
            System.out.println(r4 + " es distinto a " + r5);
    }
}
