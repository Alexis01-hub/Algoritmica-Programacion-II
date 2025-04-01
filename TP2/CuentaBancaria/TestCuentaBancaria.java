package CuentaBancaria;

import CuentaBancaria.logica.CajaAhorro;
import CuentaBancaria.logica.CuentaBancaria;
import CuentaBancaria.logica.CuentaCorriente;

public class TestCuentaBancaria {
    public static void main(String[] args) {
        // Crear una cuenta de ahorro
        CuentaBancaria cuentaAhorro = new CajaAhorro("001", "Juan Perez", 1000.0);
        cuentaAhorro.depositar(500.0);
        cuentaAhorro.retirar(200.0);
        System.out.println(cuentaAhorro.toString());
        System.out.println("-------------------------------------------------");
        // Crear una cuenta corriente
        CuentaBancaria cuentaCorriente = new CuentaCorriente("002", "Maria Lopez", 2000.0, 500.0);
        cuentaCorriente.depositar(1000.0);
        cuentaCorriente.retirar(2500.0);
        System.out.println(cuentaCorriente.toString());
        System.out.println("-------------------------------------------------");
        // Crear una cuenta corriente con saldo negativo
        CuentaBancaria cuentaCorrienteNegativa = new CuentaCorriente("003", "Carlos Garcia", 1000.0, 200.0);
        cuentaCorrienteNegativa.depositar(500.0);
        cuentaCorrienteNegativa.retirar(1500.0);
        System.out.println(cuentaCorrienteNegativa.toString());
        System.out.println("-------------------------------------------------");
        // Crear una cuenta de ahorro con saldo negativo
        CuentaBancaria cuentaAhorroNegativa = new CajaAhorro("004", "Ana Torres", 500.0);
        cuentaAhorroNegativa.depositar(200.0);
        cuentaAhorroNegativa.retirar(800.0); // Intentar retirar más de lo que hay en la cuenta
        System.out.println(cuentaAhorroNegativa.toString());
        System.out.println("-------------------------------------------------");
        // Crear una cuenta corriente con saldo negativo y límite fijo
        CuentaBancaria cuentaCorrienteConLimite = new CuentaCorriente("005", "Luis Martinez", 1000.0, 300.0);
        cuentaCorrienteConLimite.depositar(200.0);
        cuentaCorrienteConLimite.retirar(1500.0); // Intentar retirar más de lo que hay en la cuenta
        System.out.println(cuentaCorrienteConLimite.toString());
       


    }
}
