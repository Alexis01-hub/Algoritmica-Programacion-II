

public abstract class Bien {
    private String fechaAlta;
    private Titular titular;

    public Bien(String fechaAlta, Titular titular) {
        this.fechaAlta = fechaAlta;
        this.titular = titular;
    }

    public abstract double calcularImpuesto();

    // Getters y Setters
    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bien bien = (Bien) obj;
        return fechaAlta.equals(bien.fechaAlta) && titular.equals(bien.titular);
    }

    @Override
    public String toString() {
        return "Bien{" +
                "fechaAlta='" + fechaAlta + '\'' +
                ", titular=" + titular +
                '}';
    }
}