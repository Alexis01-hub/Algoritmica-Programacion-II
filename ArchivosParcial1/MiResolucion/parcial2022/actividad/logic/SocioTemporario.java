package ArchivosParcial1.MiResolucion.parcial2022.actividad.logic;

public class SocioTemporario extends Socio {
    //constructor
    public SocioTemporario(int nroSocio, String nombre) {
        super(nroSocio, nombre);
    }
    //metodos
    @Override
    public double calcularCuota() {
        return super.calcularActividades() + super.getValorCuota(); //calculo de la cuota
    }
    
}
