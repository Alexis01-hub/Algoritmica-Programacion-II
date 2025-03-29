package Complejos;
public class Complejo {
    private float real;
    private float imaginario;

    public Complejo(float real, float imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public void suma(Complejo otro) {
        this.real += otro.real;
        this.imaginario += otro.imaginario;
    }

    public void resta(Complejo otro) {
        this.real -= otro.real;
        this.imaginario -= otro.imaginario;
    }

    public void producto(Complejo otro) {
        float nuevoReal = this.real * otro.real - this.imaginario * otro.imaginario;
        float nuevoImaginario = this.real * otro.imaginario + this.imaginario * otro.real;
        this.real = nuevoReal;
        this.imaginario = nuevoImaginario;
    }

    public void cociente(Complejo otro) {
        float divisor = otro.real * otro.real + otro.imaginario * otro.imaginario;
        float nuevoReal = (this.real * otro.real + this.imaginario * otro.imaginario) / divisor;
        float nuevoImaginario = (this.imaginario * otro.real - this.real * otro.imaginario) / divisor;
        this.real = nuevoReal;
        this.imaginario = nuevoImaginario;
    }

    public void divisionEscalar(float escalar) {
        this.real /= escalar;
        this.imaginario /= escalar;
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imaginario + "i";
    }
}