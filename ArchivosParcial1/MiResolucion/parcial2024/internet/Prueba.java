package ArchivosParcial1.MiResolucion.parcial2024.internet;

public class Prueba {
    public static void main(String[] args){
    TipoServicio b = new TipoServicio(1, "basico");
    TipoServicio p = new TipoServicio(2, "premium");

    Servicio s25 = new Servicio(1, "25mb");
    Servicio s50 = new Servicio(2, "50mb");
    Servicio s100 = new Servicio(3, "100mb");

    Plan p1 = new Plan(18500, b, s25);
    Plan p2 = new Plan(21700,b, s50);
    Plan p3 = new Plan(37100, p, s50);
    Plan p4 = new Plan(54500, p, s100);

    Persona per1 = new Persona(1, "Calle 1", p1, "Juan");
    Persona per2 = new Persona(2, "Calle 2", p2, "Pedro");
    Empresa emp1 = new Empresa(3, "Aluar", p3,"pedro", false);
    Empresa emp2 = new Empresa(4, "mi Kiosco", p4,"ana", true);

    Cliente clientes[] = new Cliente[4];
    clientes[0] = per1;
    clientes[1] = per2;
    clientes[2] = emp1;
    clientes[3] = emp2;

    double total = 0;
    double factura;
    for (Cliente cliente : clientes) {
        factura = cliente.calcularFactura();
        System.out.println(cliente.getId() + " - Factura: " + factura);
        total += factura;
    }
    System.out.println("Total a cobrar: " + total);

    total = 0;
    for (Cliente cliente : clientes) {
        if (cliente.getPlan().getServicio().equals(s50)) {
            factura = cliente.calcularFactura();
            System.out.println(cliente.getId() + " - Factura: " + factura);
            total += factura;
        }
    }
    System.out.println("Total a cobrar por servicio de 50mb: " + total);
    }

}
