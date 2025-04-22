package ArchivosParcial1.MiResolucion.parcial2024.internet;

public class Plan {
    private double tarifa;
    private TipoServicio tipoServicio;
    private Servicio servicio;

    public Plan(double tarifa, TipoServicio tipoServicio, Servicio servicio) {
        this.tarifa = tarifa;
        this.tipoServicio = tipoServicio;
        this.servicio = servicio;
    }
    public double getTarifa() {
        return tarifa;
    }
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipoServicio == null) ? 0 : tipoServicio.hashCode());
        result = prime * result + ((servicio == null) ? 0 : servicio.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plan other = (Plan) obj;
        if (tipoServicio == null) {
            if (other.tipoServicio != null)
                return false;
        } else if (!tipoServicio.equals(other.tipoServicio))
            return false;
        if (servicio == null) {
            if (other.servicio != null)
                return false;
        } else if (!servicio.equals(other.servicio))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Plan [tarifa=" + tarifa + ", tipoServicio=" + tipoServicio + ", servicio=" + servicio + "]";
    }

    

}
