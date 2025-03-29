package Racional;

public class TestRacional {
    public static void main(String[] args) {
        Racional r1 = new Racional(1, 2);
        Racional r2 = new Racional(3, 4);

        System.out.println("Racional 1: " );
        System.out.println("Racional 2: " );

        r1.suma(r2);
        r1.resta(r2);
        r1.producto(r2);
        r1.division(r2);
        r1.potencia(2);
    }
}
