package ArchivosParcial1.MiResolucion.parcial2020.empresa;

public class PruebaDepa {
    public static void main(String[] args) {
        Departamento d1 = new Departamento(1, "produccion");
        Departamento d3 = d1;
        Departamento d2 = new Departamento(1, "");
        
        System.out.println(d1.equals(d3));
        //System.out.println(d1.equals(d2)); // true, porque tienen el mismo codigo
        System.out.println("--------------");

        if (d1 == d2) {
            System.out.println("son iguales"); // false, porque son dos objetos diferentes
        } else {
            System.out.println("no son iguales"); // se ejecuta este bloque
            
        }
    }
}
