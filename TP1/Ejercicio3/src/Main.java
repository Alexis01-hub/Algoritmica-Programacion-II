import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double num1;
        double num2;
        System.out.println("Ingrese sus dos numeros:");
        num1 = teclado.nextDouble();
        num2 = teclado.nextDouble();
        teclado.close();
        comparacion(num1,num2);
    }

    public static void comparacion(double num1, double num2){
        if (num1 == num2){
            System.out.println("Los numeros son iguales");
        } else if (num1 > num2) {
            System.out.println(num1+" Es mas grande!");
        }else{
            System.out.println(num2+" Es mas grande!");
        }

    }
}