package empresa;

/**
 * La interfaz PorPagar debe ser implementada por cualquier clase cuyos objetos puedan ser procesados
 * para obtener un monto de pago. Ejemplos de clases que implementan esta interfaz son Empleado y Factura.
 */
public interface PorPagar {
	/**
	 * Calcula y devuelve el monto del pago.
	 * 
	 * @return el monto del pago como un valor de tipo double.
	 */
	public double obtenerPago();
}
