
public class Inmueble extends Bien {
    
    private String partida;
    private double valorFiscal;
    private double alicuotaBaldio;
    private double alicuotaEdificado;
    private boolean baldio;

    public Inmueble(String fechaAlta, Titular titular, String partida, double valorFiscal, double alicuotaBaldio, double alicuotaEdificado,
            boolean baldio) {
                super(fechaAlta, titular);
        this.partida = partida;
        this.valorFiscal = valorFiscal;
        this.alicuotaBaldio = alicuotaBaldio;
        this.alicuotaEdificado = alicuotaEdificado;
        this.baldio = baldio;
    }
    public double calcularImpuesto() {
        if (baldio) {
            return valorFiscal * alicuotaBaldio;
        } else {
            return valorFiscal * alicuotaEdificado;
        }
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public double getValorFiscal() {
        return valorFiscal;
    }

    public void setValorFiscal(double valorFiscal) {
        this.valorFiscal = valorFiscal;
    }

    public double getAlicuotaBaldio() {
        return alicuotaBaldio;
    }

    public void setAlicuotaBaldio(double alicuotaBaldio) {
        this.alicuotaBaldio = alicuotaBaldio;
    }

    public double getAlicuotaEdificado() {
        return alicuotaEdificado;
    }

    public void setAlicuotaEdificado(double alicuotaEdificado) {
        this.alicuotaEdificado = alicuotaEdificado;
    }

    public boolean isBaldio() {
        return baldio;
    }

    public void setBaldio(boolean baldio) {
        this.baldio = baldio;
    }
    
    
    

}
