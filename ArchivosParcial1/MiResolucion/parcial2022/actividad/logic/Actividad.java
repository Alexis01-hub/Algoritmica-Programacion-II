package ArchivosParcial1.MiResolucion.parcial2022.actividad.logic;

public class Actividad {
    private int codigo;
    private String actividad;
    private double costo;
    //constructor
    public Actividad(int codigo, String actividad, double costo) {
        super(); // Constructor de la clase padre ??
        this.codigo = codigo;
        this.actividad = actividad;
        this.costo = costo;
    }

    //getters and setters
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Actividad [codigo=" + codigo + ", actividad=" + actividad + ", costo=" + costo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        result = prime * result + ((actividad == null) ? 0 : actividad.hashCode());
        long temp;
        temp = Double.doubleToLongBits(costo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Actividad other = (Actividad) obj;
        if (codigo != other.codigo)
            return false;
        if (actividad == null) {
            if (other.actividad != null)
                return false;
        } else if (!actividad.equals(other.actividad))
            return false;
        if (Double.doubleToLongBits(costo) != Double.doubleToLongBits(other.costo))
            return false;
        return true;
    }
    
    
}
