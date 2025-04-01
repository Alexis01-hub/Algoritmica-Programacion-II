package CuentaBancaria.logica;

/**
 * Clase abstracta que representa una cuenta bancaria.
 */
public abstract class CuentaBancaria {
    protected String idCuenta;
    protected String titular;
    protected double saldo;

    /**
     * Constructor de la clase CuentaBancaria.
     * 
     * @param idCuenta Identificador único de la cuenta.
     * @param titular  Nombre del titular de la cuenta.
     * @param saldo    Saldo inicial de la cuenta.
     */
    public CuentaBancaria(String idCuenta, String titular, double saldo) {
        this.idCuenta = idCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Método abstracto para depositar un monto en la cuenta.
     * 
     * @param monto Monto a depositar.
     */
    public abstract void depositar(double monto);

    /**
     * Método abstracto para retirar un monto de la cuenta.
     * 
     * @param monto Monto a retirar.
     */
    public abstract void retirar(double monto);

    /**
     * Obtiene el identificador de la cuenta.
     * 
     * @return Identificador de la cuenta.
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     * 
     * @return Nombre del titular.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * 
     * @return Saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Representación en cadena de la cuenta bancaria.
     * 
     * @return Información de la cuenta bancaria.
     */
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta='" + idCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
