package CuentaBancaria.logica;

/**
 * Clase que representa una caja de ahorro.
 */
public class CajaAhorro extends CuentaBancaria {

    /**
     * Constructor de la clase CajaAhorro.
     * 
     * @param idCuenta Identificador único de la cuenta.
     * @param titular  Nombre del titular de la cuenta.
     * @param saldo    Saldo inicial de la cuenta.
     */
    public CajaAhorro(String idCuenta, String titular, double saldo) {
        super(idCuenta, titular, saldo);
    }

    /**
     * Deposita un monto en la cuenta.
     * 
     * @param monto Monto a depositar.
     */
    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se ha depositado " + monto + " en la cuenta " + getIdCuenta() + ". Nuevo saldo: " + getSaldo());
        } else {
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    /**
     * Retira un monto de la cuenta.
     * 
     * @param monto Monto a retirar.
     */
    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Se ha retirado "+ monto + " en la cuenta "+ getIdCuenta() + ". Nuevo saldo: "+ getSaldo());
        }else{
            System.out.println("El monto a retirar debe ser menor al saldo de la cuenta.");
        }
    }

    /**
     * Representación en cadena de la caja de ahorro.
     * 
     * @return Información de la caja de ahorro.
     */
    @Override
    public String toString() {
        return super.toString() + "\nTipo de cuenta: Caja de Ahorro.";
    }

}
