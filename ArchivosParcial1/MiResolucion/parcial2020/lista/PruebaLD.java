package ArchivosParcial1.MiResolucion.parcial2020.lista;

public class PruebaLD {
    public static void main(String[] args) {
        
        DoublyLinkedList<String> lista = new DoublyLinkedList<>();
        lista.addFirst("A");
        lista.addLast("B");
        lista.addLast("C");
        lista.addLast("D");
        lista.addLast("E");
        try {

			System.out.println(lista.rightList(2));

			System.out.println(lista.rightList(1));

			System.out.println(lista.rightList(5));

			System.out.println(lista.rightList(0));

			System.out.println(lista.rightList(6));

		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
    }
}
