package ej6.Test;

import ej6.*;
import java.util.*;

public class Prueba {
    public static void main(String[] args) {
        List<String> operadores = Arrays.asList("+", "-", "*", "/");

        // Caso 1: Árbol vacío
        LinkedBinaryTree<String> arbolVacio = new LinkedBinaryTree<>();
        System.out.println("CASO 1: Árbol vacío");
        System.out.println("full(): " + arbolVacio.full());
        System.out.println("validExpressionTree(): " + arbolVacio.validExpressionTree(operadores));
        System.out.println("-----------------------------------");

        // Caso 2: Solo raíz (hoja)
        LinkedBinaryTree<String> soloRaiz = new LinkedBinaryTree<>();
        soloRaiz.addRoot("3");
        System.out.println("CASO 2: Solo raíz (hoja)");
        System.out.println("full(): " + soloRaiz.full());
        System.out.println("validExpressionTree(): " + soloRaiz.validExpressionTree(operadores));
        System.out.println("-----------------------------------");

        // Caso 3: Árbol lleno y válido
        LinkedBinaryTree<String> llenoValido = new LinkedBinaryTree<>();
        Position<String> r = llenoValido.addRoot("+");
        Position<String> l = llenoValido.addLeft(r, "*");
        Position<String> d = llenoValido.addRight(r, "-");
        llenoValido.addLeft(l, "3");
        llenoValido.addRight(l, "2");
        llenoValido.addLeft(d, "4");
        llenoValido.addRight(d, "5");
        System.out.println("CASO 3: Árbol lleno y válido");
        System.out.println("full(): " + llenoValido.full());
        System.out.println("validExpressionTree(): " + llenoValido.validExpressionTree(operadores));
        System.out.println("-----------------------------------");

        // Caso 4: Árbol lleno y NO válido (operador en hoja)
        LinkedBinaryTree<String> llenoNoValido = new LinkedBinaryTree<>();
        Position<String> r2 = llenoNoValido.addRoot("+");
        Position<String> l2 = llenoNoValido.addLeft(r2, "*");
        Position<String> d2 = llenoNoValido.addRight(r2, "-");
        llenoNoValido.addLeft(l2, "+"); // operador en hoja
        llenoNoValido.addRight(l2, "2");
        llenoNoValido.addLeft(d2, "4");
        llenoNoValido.addRight(d2, "5");
        System.out.println("CASO 4: Árbol lleno y NO válido (operador en hoja)");
        System.out.println("full(): " + llenoNoValido.full());
        System.out.println("validExpressionTree(): " + llenoNoValido.validExpressionTree(operadores));
        System.out.println("-----------------------------------");

        // Caso 5: Árbol NO lleno y válido (falta un hijo pero operadores y operandos correctos)
        LinkedBinaryTree<String> noLlenoValido = new LinkedBinaryTree<>();
        Position<String> r3 = noLlenoValido.addRoot("+");
        Position<String> l3 = noLlenoValido.addLeft(r3, "*");
        noLlenoValido.addLeft(l3, "3");
        // No agregamos right(l3)
        System.out.println("CASO 5: Árbol NO lleno y válido");
        System.out.println("full(): " + noLlenoValido.full());
        System.out.println("validExpressionTree(): " + noLlenoValido.validExpressionTree(operadores));
        System.out.println("-----------------------------------");

        // Caso 6: Árbol NO lleno y NO válido (operador en hoja y falta un hijo)
        LinkedBinaryTree<String> noLlenoNoValido = new LinkedBinaryTree<>();
        Position<String> r4 = noLlenoNoValido.addRoot("+");
        Position<String> l4 = noLlenoNoValido.addLeft(r4, "*");
        noLlenoNoValido.addLeft(l4, "+"); // operador en hoja
        // No agregamos right(l4)
        System.out.println("CASO 6: Árbol NO lleno y NO válido");
        System.out.println("full(): " + noLlenoNoValido.full());
        System.out.println("validExpressionTree(): " + noLlenoNoValido.validExpressionTree(operadores));
        System.out.println("-----------------------------------");
    }
}
