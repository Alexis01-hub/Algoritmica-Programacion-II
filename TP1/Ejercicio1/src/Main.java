import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double resultado;


        System.out.println("Ingrese su Numero A:");
        double numA = teclado.nextDouble();
        System.out.println("Ingrese su Numero B:");
        double numB = teclado.nextDouble();
        System.out.println("Elija la operacion a hacerse:");

        int operacion = teclado.nextInt();
        teclado.close();
        switch (operacion){
        case 1:
            resultado= numA + numB;
        System.out.println("el resultado de la suma es: "+resultado);
            break;
        case 2:
            resultado = numA - numB;
        System.out.println("el resultado de la resta es: "+resultado);
            break;
        case 3:
            resultado = numA * numB;
        System.out.println("el resultado de la potencia es: "+resultado);
            break;
        case 4:
            if (numB != 0){
                resultado = numA / numB;
                System.out.println("el resultado del cociente es: "+resultado);
            }else {
                System.out.println("Ingrese un numero B distinto a cero para realizar la operacion");
            }
        default:
        System.out.println("Error de Operacion");
        }
    }
}