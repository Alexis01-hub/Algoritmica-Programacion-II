package ArchivosParcial1.MiResolucion.parcial2021.banco;

public class CuentaCorriente extends Cuenta{
    private static final double DESCUBIERTO = 5000.00;

    public CuentaCorriente(int nroCuenta, double saldo) {
        super(nroCuenta, saldo);
    }
    @Override
    public void extraer(double importe){
        double nuevoSaldo = getSaldo() - importe;
        if (nuevoSaldo >= -DESCUBIERTO){
            setSaldo(nuevoSaldo);
        }else{
            throw new RuntimeException("No se puede extraer el importe, saldo insuficiente.");
        }
    }

}
