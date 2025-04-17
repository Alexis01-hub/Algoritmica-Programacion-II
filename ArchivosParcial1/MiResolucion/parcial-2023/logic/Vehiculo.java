import java.time.LocalDate;
public class Vehiculo extends Bien {
    private String patente;
    private String marca;
    private int modelo;
    private static final int ANTIGUEDAD = 20;
    private double alicuotaVehiculo;
    private double valuacionFiscal;

    public Vehiculo(String fechaAlta, Titular titular, String patente, 
                   String marca, int modelo, double alicuotaVehiculo, 
                   double valuacionFiscal) {
        super(fechaAlta, titular);
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.alicuotaVehiculo = alicuotaVehiculo;
        this.valuacionFiscal = valuacionFiscal;
    }

    @Override
    public double calcularImpuesto() {
        int añoActual = LocalDate.now().getYear();
        if (añoActual - modelo >= ANTIGUEDAD) {
            return 0;
        }
        return valuacionFiscal * alicuotaVehiculo;
    }

    // Getters y Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getAlicuotaVehiculo() {
        return alicuotaVehiculo;
    }

    public void setAlicuotaVehiculo(double alicuotaVehiculo) {
        this.alicuotaVehiculo = alicuotaVehiculo;
    }

    public double getValuacionFiscal() {
        return valuacionFiscal;
    }

    public void setValuacionFiscal(double valuacionFiscal) {
        this.valuacionFiscal = valuacionFiscal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Vehiculo other = (Vehiculo) obj;
        return patente.equals(other.patente);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo=" + modelo +
                ", alicuotaVehiculo=" + alicuotaVehiculo +
                ", valuacionFiscal=" + valuacionFiscal +
                ", " + super.toString() +
                '}';
    }
}
