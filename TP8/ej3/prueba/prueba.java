package ej3.prueba;

import java.util.ArrayList;
import java.util.List;

public class prueba {

    public static boolean similar(List<String> l,List<String> s) {
        if (l.size() != s.size()) return false; // si tienen diferente tamaño, no son similares
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i).equals(s.get(i))) return false; // si algún elemento no es igual, no son similares
        }
        return true; // si todos los elementos son iguales, son similares
    }
    public static void main(String[] args) {
        
        List<String> lista1 = new ArrayList<>();
        lista1.add("Ana");
        lista1.add("Juan");
        lista1.add("Ana");
        lista1.add("Pedro");
        lista1.add("Ana");

        List<String> lista2 = new ArrayList<>();
        lista2.add("Juan");
        lista2.add("Pedro");
        lista2.add("Ana");
        lista2.add("Ana");
        lista2.add("Ana");

        System.out.println("Son similares? "+ similar(lista1, lista2));

    }
}
