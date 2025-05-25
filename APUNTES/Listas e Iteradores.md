# Resumen Simplificado: Listas e Iteradores

## 1. Tipos de Listas
- **Listas con Arreglos (Arrays)**:
  - Ventaja: Acceso rápido a cualquier posición (`get(i)` es instantáneo).
  - Desventaja: Insertar o eliminar elementos es lento porque hay que mover muchos elementos.

- **Listas Enlazadas**:
  - Ventaja: Insertar o eliminar elementos es rápido (solo hay que cambiar unos pocos enlaces).
  - Desventaja: Para acceder a una posición lejana, hay que recorrer toda la lista paso a paso.

## 2. Cuando la Lista Crea
- **Problema**: Si usamos un arreglo y se llena, ¿qué hacemos?
- **Soluciones**:
  1. **Estrategia Incremental**: Agrandar el arreglo poco a poco (ej: +10 espacios). Es simple pero ineficiente.
  2. **Estrategia de Duplicación**: Duplicar el tamaño del arreglo cada vez que se llena. Es más eficiente a largo plazo.

## 3. Listas con Posiciones Especiales
- **Idea**: En lugar de usar números (índices) para las posiciones, usamos "marcadores".
  - Ejemplo: Como el cursor en un documento de Word.
  - Ventaja: Si insertas o borras texto, el cursor sigue en su lugar correcto.

```java

LinkedList<String> palabras = new LinkedList<>();
palabras.add("Hola");
palabras.add("Mundo");

// Usando Iterador (solo avanza)
Iterator<String> it = palabras.iterator();
while (it.hasNext()) {
    System.out.println(it.next()); // Imprime "Hola", luego "Mundo"
}

// Usando Cursor (ListIterator: avanza y retrocede)
ListIterator<String> cursor = palabras.listIterator();
cursor.next(); // Avanza a "Hola"
cursor.add("Java"); // Inserta "Java" entre "Hola" y "Mundo"
cursor.previous(); // Retrocede a "Java"
```
**¿Cuándo usar cada uno?**
- Cursor (ListIterator):

    - Cuando necesitas insertar/eliminar elementos en medio de una lista (ej: editar un documento).
    - Si requieres movimiento bidireccional (avanzar y retroceder).

- Iterador (Iterator):

    - Para recorrer una lista completa sin modificarla (ej: imprimir elementos).
    - Cuando solo necesitas lectura secuencial simple.

**Conclucion:** No son lo mismo, pero están relacionados. Un cursor (ListIterator) es más potente (permite navegación bidireccional y modificaciones), mientras que un iterador (Iterator) es más simple (solo para recorrido secuencial).

## 4. Recorrer Listas (Iteradores)
- **Qué son**: Herramientas para recorrer una lista elemento por elemento.
- **Cómo funcionan**:
  - `hasNext()`: ¿Quedan más elementos?
  - `next()`: Dame el siguiente elemento.
- **Tipos**:
  - **Snapshot**: Hace una copia completa de la lista (ocupa más memoria).
  - **Lazy**: Solo mira los elementos cuando los necesita (más eficiente).

