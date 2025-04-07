package empresa;

// En esta clase se prueba la funcionalidad de la clase Factura
public class PruebaFactura {

	public static void main(String[] args) {

		// Crear una instancia de Factura con datos iniciales
		Factura factura = new Factura("Aluar", 1234, "2023-10-01");

		// Agregar varios ítems a la factura
		factura.agregarItem("papitas slays de messi", 5, 500);
		factura.agregarItem("cocacola", 10, 1000);
		factura.agregarItem("gomitas", 100, 100);
		factura.agregarItem("pepsi", 100, 100);
		factura.agregarItem("chocolate", 100, 100);
		factura.agregarItem("agua", 100, 100);
		factura.agregarItem("jugo", 100, 100);
		factura.agregarItem("galletas", 100, 100);
		

		// Imprimir la representación de la factura
		System.out.println(factura.toString());
	}
	
}
