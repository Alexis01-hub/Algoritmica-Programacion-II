package ArchivosParcial1.MiResolucion.parcial2022.actividad.logic;

public class SocioActivo extends Socio{
    private static double porcDescuento = 30;
    private static int cantActividades = 3;
    //constructor
    public SocioActivo(int nroSocio, String nombre) {
        super(nroSocio, nombre);
    }
    //metodos
    @Override
    public double calcularCuota(){
        double total = super.calcularActividades() + super.getValorCuota(); //calculo de la cuota 
        if (super.getNroActividades() >= cantActividades)
            total = total - (total * (porcDescuento / 100)); //calculo del descuento
        return total; //retorno el total
    }
    //getters and setters

    public static double getPorcDescuento() {
        return porcDescuento; //porcentaje de descuento
    }
    public static void setPorcDescuento(double porcDescuento) {
       SocioActivo.porcDescuento = porcDescuento; //porcentaje de descuento
    }
    public static int getCantActividades() {
        return cantActividades; //cantidad de actividades
    }
    public static void setCantActividades(int cantActividades) { 
        SocioActivo.cantActividades = cantActividades; //cantidad de actividades
    }

    
}
