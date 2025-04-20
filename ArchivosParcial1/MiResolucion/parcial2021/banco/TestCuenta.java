package ArchivosParcial1.MiResolucion.parcial2021.banco;
/*
 * 2) Realizar un programa de prueba donde cree un arreglo de clientes y cuentas para los mismos. Un 
cliente puede tener cero, una o más cajas de ahorro y cero, una o más cuentas corriente. 
 
a) Recorrer el arreglo mostrando el nombre y saldo total de cada cliente 
b) Mostrar la sumatoria de todos los saldos de los clientes que tiene el banco
 */
public class TestCuenta {
    private static final int MAX_CLIENTES = 5;
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[MAX_CLIENTES];
        
        clientes[0] = new Cliente("Juan", "111111111");
        clientes[0].agregarCuenta(new CajaAhorro(1, 1000));
        clientes[0].agregarCuenta(new CuentaCorriente(2, 2000));

        clientes[1] = new Cliente("Maria", "222222222");
        CuentaCorriente acc1 = new CuentaCorriente(3, 0);
        clientes[1].agregarCuenta(acc1);
        acc1.extraer(5000); 
        try {
            acc1.extraer(2000); // Intento de extracción que debería fallar
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("Saldo actual: " + acc1.getSaldo());
        }

        clientes[2] = new Cliente("Pedro", "333333333");
        clientes[3] = new Cliente("Ana", "444444444");
        CajaAhorro acc3 = new CajaAhorro( 4, 1000);
        clientes[3].agregarCuenta(acc3);
        try {
            acc3.extraer(2000);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("Saldo actual: " + acc3.getSaldo());
        }

        clientes[4] = new Cliente("Luis", "555555555");
        try {
            clientes[4].agregarCuenta(new CuentaCorriente(5, 5000));
            clientes[4].agregarCuenta(new CuentaCorriente(6, 10000));
            clientes[4].agregarCuenta(new CuentaCorriente(7, 10000));
            clientes[4].agregarCuenta(new CuentaCorriente(8, 10000));
            clientes[4].agregarCuenta(new CuentaCorriente(9, 10000));
            clientes[4].agregarCuenta(new CuentaCorriente(10, 10000));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        double totalBanco = 0;
        for (Cliente cliente : clientes) {
            double saldoTotal = cliente.calcularSaldo();
            System.out.println("Cliente: " + cliente.getNombre() + ", Saldo total: " + saldoTotal);
            totalBanco += saldoTotal;
        }
        System.out.println("Total saldo en el banco: " + totalBanco);
        
    }
}
