package empresa;

/**
 * Clase Factura que implementa la interfaz PorPagar.
 * Representa una factura con un proveedor, número, fecha y una lista de artículos.
 */
public class Factura implements PorPagar {

	// Atributos de la clase Factura
	/** Cantidad máxima de artículos permitidos en la factura. */
	private static final int CANTIDAD_ITEMS = 10;

	/** Nombre del proveedor asociado a la factura. */
	private String proveedor;

	/** Número identificador de la factura. */
	private int numero;

	/** Fecha de emisión de la factura. */
	private String fecha;

	/** Cantidad actual de artículos en la factura. */
	private int cantArticulos = 0;

	/** Arreglo que almacena los artículos de la factura. */
	private Item[] articulos;

	/**
	 * Constructor de la clase Factura.
	 * 
	 * @param proveedor Nombre del proveedor.
	 * @param numero Número identificador de la factura.
	 * @param fecha Fecha de emisión de la factura.
	 */
	public Factura(String proveedor, int numero, String fecha) {
		this.proveedor = proveedor;
		this.numero = numero;
		this.fecha = fecha;
		articulos = new Item[CANTIDAD_ITEMS];
	}

	/**
	 * Calcula el total a pagar de la factura sumando el costo de todos los artículos.
	 * 
	 * @return El total a pagar de la factura.
	 */
	public double obtenerPago() {
		double total = 0.0;
		for(int i = 0; i <cantArticulos; i++){
			total += (articulos[i].cantidad * articulos[i].precioUnitario);
		}
		return total;
	}

	/**
	 * Agrega un artículo al arreglo de artículos de la factura.
	 * 
	 * @param descripcion Descripción del artículo.
	 * @param cantidad Cantidad del artículo.
	 * @param precioUnitario Precio unitario del artículo.
	 * @throws IndexOutOfBoundsException Si se excede la cantidad máxima de artículos.
	 */
	public void agregarItem(String descripcion, int cantidad, double precioUnitario) throws IndexOutOfBoundsException {
		if (cantArticulos > CANTIDAD_ITEMS)
			throw new IndexOutOfBoundsException("Factura completa");

		this.articulos[cantArticulos++] = new Item(descripcion, cantidad, precioUnitario);
	}

	/**
	 * Devuelve una representación en forma de cadena de la factura, incluyendo
	 * los detalles de los artículos y el total a pagar.
	 * 
	 * @return Cadena con la información de la factura.
	 */
	@Override
	public String toString() {
		StringBuilder articulosStr = new StringBuilder();
		for (int i = 0; i < cantArticulos; i++) {
			articulosStr.append(articulos[i].toString()).append("\n");
		}
		return "\n" + "Proveedor: " + proveedor + "\n" + "Numero: " + numero + "\n" + "Fecha: " + fecha + "\n" +
			   "Cantidad de articulos: " + cantArticulos + "\n\n" + // Salto de línea adicional
			   "===> Articulos: " + "\n" + articulosStr.toString() +
			   "Total a pagar: $" + obtenerPago() + "\n";
	}

	/**
	 * Clase interna que representa un artículo dentro de la factura.
	 */
	private class Item {

		/** Descripción del artículo. */
		private String descripcion;

		/** Cantidad del artículo. */
		private int cantidad;

		/** Precio unitario del artículo. */
		private double precioUnitario;

		/**
		 * Constructor de la clase Item.
		 * 
		 * @param descripcion Descripción del artículo.
		 * @param cantidad Cantidad del artículo.
		 * @param precioUnitario Precio unitario del artículo.
		 */
		public Item(String descripcion, int cantidad, double precioUnitario) {
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
		}

		/**
		 * Devuelve una representación en forma de cadena del artículo.
		 * 
		 * @return Cadena con la información del artículo.
		 */
		@Override
		public String toString() {
			return "Descripcion: "+descripcion+ "\n" +"Cantidad: "+cantidad+ "\n" +"Precio unitario: $"+precioUnitario+"\n";
		}

	}

}

