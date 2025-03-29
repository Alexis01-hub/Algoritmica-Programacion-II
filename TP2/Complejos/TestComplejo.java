package Complejos;
/*
 * Crear la clase Complejo para realizar aritmética de números complejos. 
a) Utilizar variables de punto flotante para representar los datos privados de la clase. 
b) Proporcionar un constructor que permita inicializar un objeto de esta clase cuando se declara.
c) Incluir métodos públicos para cada una de las si­guientes operaciones con complejos: suma, resta, producto, cociente, división escalar.
d) Implementar el método toString para imprimir un número complejo.
 */
public class TestComplejo {
    public static void main(String[] args) {
        Complejo c1 = new Complejo(10,1);
        Complejo c2 = new Complejo(5, 5);
        
        System.out.println("Números complejos iniciales:");
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        c1.suma(c2);
        System.out.println(c1);
        
        c1.divisionEscalar(2);
        System.out.println(c1);

        c1.cociente(c2);
        System.out.println(c1);

        c1.resta(c2);
        System.out.println(c1);

        c1.producto(c2);
        System.out.println(c1);
    }
}