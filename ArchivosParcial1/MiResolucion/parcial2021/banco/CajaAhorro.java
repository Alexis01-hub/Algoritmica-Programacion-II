package ArchivosParcial1.MiResolucion.parcial2021.banco;

public class CajaAhorro extends Cuenta{

    public CajaAhorro(int nroCuenta, double saldo) {
        super(nroCuenta, saldo);
    }

    @Override
    public void extraer(double importe) {
        double nuevoSaldo = getSaldo() - importe;
        if (nuevoSaldo >= 0){
            setSaldo(nuevoSaldo);
        } else {
            throw new RuntimeException("No se puede extraer el importe, saldo insuficiente.");
        }
    }

    
    
}
