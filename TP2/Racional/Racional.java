package Racional;

class Racional {
    private int numerador;
    private int denominador;

    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    private int mcd(int a, int b) {
        if (b == 0) return a;
        return mcd(b, a % b);
    }

    private void simplificar() {
        int divisor = mcd(numerador, denominador);
        numerador /= divisor;
        denominador /= divisor;
    }

    public void suma(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        simplificar();
        System.out.println("Resultado de la suma: " + numerador + "/" + denominador);
    }

    public void resta(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador - otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        simplificar();
        System.out.println("Resultado de la resta: " + numerador + "/" + denominador);
    }

    public void producto(Racional otro) {
        int nuevoNumerador = this.numerador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        simplificar();
        System.out.println("Resultado del producto: " + numerador + "/" + denominador);
    }

    public void division(Racional otro) {
        if (otro.numerador == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        int nuevoNumerador = this.numerador * otro.denominador;
        int nuevoDenominador = this.denominador * otro.numerador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        simplificar();
        System.out.println("Resultado de la división: " + numerador + "/" + denominador);
    }

    public void potencia(int potencia) {
        int nuevoNumerador = (int) Math.pow(this.numerador, potencia);
        int nuevoDenominador = (int) Math.pow(this.denominador, potencia);
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        simplificar();
        System.out.println("Resultado de la potencia: " + numerador + "/" + denominador);
    }
}