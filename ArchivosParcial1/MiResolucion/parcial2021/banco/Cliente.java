package ArchivosParcial1.MiResolucion.parcial2021.banco;

import java.util.Arrays;

public class Cliente {
    private String nombre;
    private String dni;
    private static int MAX_CUENTA = 5;
    private Cuenta[] cuentas;
    private int cantCuentas;

    public Cliente(String nombre, String dni) {
        super();
        this.nombre = nombre;
        this.dni = dni;
        cuentas = new Cuenta[MAX_CUENTA];
        cantCuentas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void agregarCuenta(Cuenta cuenta){
        if (cantCuentas < MAX_CUENTA) {
            cuentas[cantCuentas] = cuenta;
            cantCuentas++;
        } else {
            throw new IndexOutOfBoundsException("No se pueden agregar más cuentas. Límite alcanzado.");
        }
    }
    public double calcularSaldo(){
        double total = 0;
        for (int i = 0; i < cantCuentas; i++) {
            total += cuentas[i].getSaldo();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", dni=" + dni + ", cuentas=" + Arrays.toString(cuentas) + ", cantCuentas="
                + cantCuentas + "]";
    }

    
}
