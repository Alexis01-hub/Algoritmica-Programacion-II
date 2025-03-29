package Racional;

/**
 * Clase que representa un número racional (fracción).
 */
class Racional {
    /**
     * Numerador de la fracción.
     */
    private int numerador;

    /**
     * Denominador de la fracción.
     */
    private int denominador;

    /**
     * Constructor de la clase Racional.
     * 
     * @param numerador   El numerador de la fracción.
     * @param denominador El denominador de la fracción. No puede ser cero.
     * @throws IllegalArgumentException Si el denominador es cero.
     */
    public Racional(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
     * Obtiene el numerador de la fracción.
     * 
     * @return El numerador.
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Establece el numerador de la fracción.
     * 
     * @param numerador El nuevo numerador.
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * Obtiene el denominador de la fracción.
     * 
     * @return El denominador.
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * Establece el denominador de la fracción.
     * 
     * @param denominador El nuevo denominador. No puede ser cero.
     * @throws IllegalArgumentException Si el denominador es cero.
     */
    public void setDenominador(int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.denominador = denominador;
    }

    /**
     * Suma esta fracción con otra.
     * 
     * @param otro La fracción a sumar.
     * @return Una nueva fracción que representa el resultado de la suma simplificada.
     */
    public Racional suma(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador + otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return simplificar(new Racional(nuevoNumerador, nuevoDenominador));
    }

    /**
     * Resta otra fracción de esta.
     * 
     * @param otro La fracción a restar.
     * @return Una nueva fracción que representa el resultado de la resta simplificada.
     */
    public Racional resta(Racional otro) {
        int nuevoNumerador = this.numerador * otro.denominador - otro.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return simplificar(new Racional(nuevoNumerador, nuevoDenominador));
    }

    /**
     * Multiplica esta fracción con otra.
     * 
     * @param otro La fracción a multiplicar.
     * @return Una nueva fracción que representa el resultado de la multiplicación simplificada.
     */
    public Racional multiplicacion(Racional otro) {
        int nuevoNumerador = this.numerador * otro.numerador;
        int nuevoDenominador = this.denominador * otro.denominador;
        return simplificar(new Racional(nuevoNumerador, nuevoDenominador));
    }

    /**
     * Divide esta fracción entre otra.
     * 
     * @param otro La fracción por la cual dividir.
     * @return Una nueva fracción que representa el resultado de la división simplificada.
     * @throws IllegalArgumentException Si el numerador de la fracción divisor es cero.
     */
    public Racional division(Racional otro) {
        if (otro.numerador == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        int nuevoNumerador = this.numerador * otro.denominador;
        int nuevoDenominador = this.denominador * otro.numerador;
        return simplificar(new Racional(nuevoNumerador, nuevoDenominador));
    }

    /**
     * Eleva esta fracción a una potencia entera.
     * 
     * @param exponente El exponente al cual elevar la fracción.
     * @return Una nueva fracción que representa el resultado de la potencia.
     */
    public Racional potencia(int exponente) {
        if (exponente == 0) {
            return new Racional(1, 1);
        }

        int nuevoNumerador = (int) Math.pow(this.numerador, Math.abs(exponente));
        int nuevoDenominador = (int) Math.pow(this.denominador, Math.abs(exponente));

        if (exponente < 0) {
            return new Racional(nuevoDenominador, nuevoNumerador); //Invierte la fraccion si el exponente es negaivo
        } else {
            return new Racional(nuevoNumerador, nuevoDenominador);
        }
    }

    /**
     * Simplifica una fracción.
     * 
     * @param otro La fracción a simplificar.
     * @return Una nueva fracción simplificada.
     */
    public static Racional simplificar(Racional otro) {
        int x = mcd(Math.abs(otro.numerador), Math.abs(otro.denominador));
        int n = otro.numerador / x;
        int d = otro.denominador / x;
        return new Racional(n, d);
    }

    /**
     * Calcula el máximo común divisor (MCD) de dos números.
     * 
     * @param a El primer número.
     * @param b El segundo número.
     * @return El MCD de los dos números.
     */
    private static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Compara esta fracción con otra para verificar si son iguales.
     * 
     * @param o El objeto a comparar.
     * @return true si las fracciones son iguales, false en caso contrario.
     */
    public boolean equals(Object o) {
        Racional r1 = simplificar(this);
        Racional r2 = simplificar((Racional) o);
        return ((r1.numerador == r2.numerador) && (r1.denominador == r2.denominador));
    }

    /**
     * Representa la fracción como una cadena de texto.
     * 
     * @return Una cadena en el formato "numerador/denominador".
     */
    public String toString() {
        return numerador + "/" + denominador;
    }
}





