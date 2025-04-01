package CuentaBancaria.logica;

/**
 * Clase que representa una cuenta corriente.
 */
public class CuentaCorriente extends CuentaBancaria {
    private double limiteFijo;

    /**
     * Constructor de la clase CuentaCorriente.
     * 
     * @param idCuenta   Identificador único de la cuenta.
     * @param titular    Nombre del titular de la cuenta.
     * @param saldo      Saldo inicial de la cuenta.
     * @param limiteFijo Límite fijo permitido para saldo negativo.
     */
    public CuentaCorriente(String idCuenta, String titular, double saldo, double limiteFijo){
        super(idCuenta, titular, saldo);
        if (limiteFijo < 0) {
            throw new IllegalArgumentException("El límite fijo debe ser un valor positivo.");
        }
        this.limiteFijo = limiteFijo;
    }

    /**
     * Deposita un monto en la cuenta.
     * 
     * @param monto Monto a depositar.
     */
    @Override
    public void depositar(double monto){
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se ha depositado $" + monto + " en la cuenta " + getIdCuenta() + ". Nuevo saldo: " + getSaldo());
        }else{
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    /**
     * Retira un monto de la cuenta.
     * 
     * @param monto Monto a retirar.
     */
    @Override
    public void retirar(double monto){
        if ((saldo - monto) >= -limiteFijo) { // Permitir saldo negativo hasta el límite fijo
            saldo -= monto;
            System.out.println("Acaba de retirar $" + monto + " de la cuenta " + getIdCuenta() + ". Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("Límite fijo excedido. No se puede realizar la extracción.");
        }
    }
}
