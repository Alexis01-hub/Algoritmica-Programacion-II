# Resumen: Árboles en Estructuras de Datos

## 1. Concepto Básico
- **Definición**: Estructura jerárquica no lineal compuesta por nodos con relaciones padre-hijo.
  - **Raíz**: Nodo sin padre.
  - **Nodos internos**: Tienen al menos un hijo.
  - **Nodos externos (hojas)**: Sin hijos.
- **Aplicaciones**: Organigramas, sistemas de archivos, expresiones aritméticas.

## 2. Terminología Clave
- **Ancestros/Descendientes**: Padre, abuelo, hijo, nieto, etc.
- **Profundidad**: Número de ancestros de un nodo (raíz = 0).
- **Altura**: Máxima profundidad del árbol.
- **Subárbol**: Nodo + todos sus descendientes.

## 3. Tipos de Árboles
### Árbol Binario
- Cada nodo tiene máximo 2 hijos: **izquierdo** y **derecho**.
- **Aplicaciones**: 
  - Expresiones aritméticas (operadores en nodos internos, operandos en hojas).
  - Árboles de decisión (preguntas Si/No en nodos internos).

### Árbol General
- Nodos pueden tener múltiples hijos (ej: árbol genealógico).

## 4. Recorridos
- **PreOrden**: Visita raíz → subárbol izquierdo → subárbol derecho.  
  **Usos**: Imprimir documentos estructurados.

- **InOrden (solo binarios)**: Subárbol izquierdo → raíz → subárbol derecho.   
  **Usos**: Evaluar expresiones aritméticas.


-  **PostOrden**: Subárbol izquierdo → subárbol derecho → raíz.   
   **Usos**: Calcular espacio en disco.

```java
// Clase para representar un nodo del árbol
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int item) {
        valor = item;
        izquierda = derecha = null;
    }
}

// Clase del árbol binario
class ArbolBinario {
    Nodo raiz;

    // Recorrido en preorden: raíz -> izquierda -> derecha
    void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            recorridoPreorden(nodo.izquierda);
            recorridoPreorden(nodo.derecha);
        }
    }

    // Recorrido en inorden: izquierda -> raíz -> derecha
    void recorridoInorden(Nodo nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            recorridoInorden(nodo.derecha);
        }
    }

    // Recorrido en postorden: izquierda -> derecha -> raíz
    void recorridoPostorden(Nodo nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izquierda);
            recorridoPostorden(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    // Método principal para ejecutar los recorridos
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        /* Se crea el siguiente árbol:
                  1
                /   \
               2     3
              / \
             4   5
        */
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierda = new Nodo(2);
        arbol.raiz.derecha = new Nodo(3);
        arbol.raiz.izquierda.izquierda = new Nodo(4);
        arbol.raiz.izquierda.derecha = new Nodo(5);

        System.out.println("Recorrido Preorden:");
        arbol.recorridoPreorden(arbol.raiz);

        System.out.println("\nRecorrido Inorden:");
        arbol.recorridoInorden(arbol.raiz);

        System.out.println("\nRecorrido Postorden:");
        arbol.recorridoPostorden(arbol.raiz);
    }
}

```

```terminal salida
Recorrido Preorden:
1 2 4 5 3 

Recorrido Inorden:
4 2 5 1 3 

Recorrido Postorden:
4 5 2 3 1 
```

## 5. TAD (Tipo Abstracto de Datos)
**Métodos clave**:
root(), parent(p), children(p), isInternal(p), isLeaf(p).

**Para binarios**: left(p), right(p), sibling(p).

## 6. Ejemplo Práctico
Árbol de Expresión Aritmética:

Expresión: 
(2×(a−1)+(3×b)).

Recorrido InOrden: Imprime con paréntesis: ((2 × (a - 1)) + (3 × b)).