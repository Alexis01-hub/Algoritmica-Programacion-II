package CuentaBancaria.logica;

/**
 * Clase que representa un cliente bancario.
 */
public class Cliente {
    private String nombre;
    private String cuit;
    private String direccion;
    private String email;
    

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre    Nombre del cliente.
     * @param cuit      CUIT del cliente.
     * @param direccion Dirección del cliente.
     * @param email     Correo electrónico del cliente.
     */
    public Cliente(String nombre, String cuit, String direccion, String email) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el CUIT del cliente.
     * 
     * @return CUIT del cliente.
     */
    public String getCuit() {
        return cuit;
    }

    /**
     * Establece el CUIT del cliente.
     * 
     * @param cuit CUIT del cliente.
     */
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return Correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param email Correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Representación en cadena del cliente.
     * 
     * @return Información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cuit='" + cuit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
