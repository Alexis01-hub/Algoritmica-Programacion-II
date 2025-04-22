package ArchivosParcial1.MiResolucion.parcial2024.internet;

public class Empresa extends Cliente{
    private String razonSocial;
    private boolean ivaExento;

    public Empresa(int id, String direccion, Plan plan, String razonSocial, boolean ivaExento) {
        super(id, direccion, plan);
        this.razonSocial = razonSocial;
        this.ivaExento = ivaExento;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public boolean isIvaExento() {
        return ivaExento;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public void setIvaExento(boolean ivaExento) {
        this.ivaExento = ivaExento;
    }
    @Override
    public String toString() {
        return "Empresa [razonSocial=" + razonSocial + ", ivaExento=" + ivaExento + "]";
    }
    @Override
    public double calcularFactura() {
        double total = super.getPlan().getTarifa();
        if (!ivaExento) {
            total += total * Cliente.getIva() / 100;
        }
        return total;
    }

}
