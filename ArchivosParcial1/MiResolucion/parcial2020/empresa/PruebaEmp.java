package ArchivosParcial1.MiResolucion.parcial2020.empresa;


public class PruebaEmp {
    public static void main(String[] args) {
        Departamento d1 = new Departamento(001, "produccion");
        Departamento d2 = new Departamento(002, "ventas");

        Empresa empresa = new Empresa("MiEmpresa");
        //empleados fijos
        empresa.agregarEmpleado("Juan", "12345678", d1, 50000);
        empresa.agregarEmpleado("Maria", "87654321", d2, 60000);

        //empleados contratados
        empresa.agregarContratado("Pedro", "11223344", d1, 200, 10);
        //a)
        double totalSueldos = empresa.calcularSueldos();
        System.out.println("Total de sueldos: " + totalSueldos);

        //b)
        System.out.println("Sueldos del departamento de produccion: "+d2+" " + empresa.calcularSueldo(d1));
    }
}
