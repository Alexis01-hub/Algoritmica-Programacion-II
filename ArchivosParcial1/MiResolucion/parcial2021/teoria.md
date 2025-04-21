- 1) ¿Qué provee el disponer de clases abstractas al tener que definir una jerarquía de clases en nuestro 
código?

Respuesta:
cada clase abstracta define un conjunto de métodos que deben ser implementados por las subclases, lo que permite una mayor flexibilidad y reutilización del código. Además, las clases abstractas pueden contener métodos concretos que pueden ser utilizados por las subclases, lo que facilita la implementación de funcionalidades comunes. Esto ayuda a mantener un diseño limpio y organizado, y a evitar la duplicación de código.

- 2) Analice las ventajas y desventajas que surgen de la comparación del uso de arreglos y listas simplemente 
enlazadas en las operaciones de: 
a. Inserción ordenada 
b. Eliminación ordenada
Dé un ejemplo donde se evidencie lo planteado por Usted. Puede ser de manera gráfica.

Respuesta: 

**a.** Inserción ordenada:
- Ventajas de los arreglos: 
  - Acceso rápido a los elementos mediante índices.
  - Permite mantener el orden de los elementos fácilmente.
- Desventajas de los arreglos: 
  - Requiere mover elementos para mantener el orden, lo que puede ser costoso en términos de tiempo.
  - El tamaño del arreglo es fijo, lo que puede limitar la capacidad de inserción.
- Ventajas de las listas simplemente enlazadas: 
  - Permite insertar elementos de manera eficiente sin necesidad de mover otros elementos.
  - No tiene un tamaño fijo, lo que permite una mayor flexibilidad.
- Desventajas de las listas simplemente enlazadas: 
  - Acceso secuencial a los elementos, lo que puede ser más lento que el acceso directo de los arreglos.
  - Requiere más memoria debido a los punteros adicionales.

**b.** Eliminación ordenada:
- Ventajas de los arreglos: 
  - Acceso rápido a los elementos mediante índices.
  - Permite mantener el orden de los elementos fácilmente.
- Desventajas de los arreglos: 
  - Requiere mover elementos para mantener el orden, lo que puede ser costoso en términos de tiempo.
  - El tamaño del arreglo es fijo, lo que puede limitar la capacidad de eliminación.
- Ventajas de las listas simplemente enlazadas: 
  - Permite eliminar elementos de manera eficiente sin necesidad de mover otros elementos.
  - No tiene un tamaño fijo, lo que permite una mayor flexibilidad.
- Desventajas de las listas simplemente enlazadas: 
  - Acceso secuencial a los elementos, lo que puede ser más lento que el acceso directo de los arreglos.
  - Requiere más memoria debido a los punteros adicionales.

ejemplo:

```java
    Arreglo: [10, 20, 30, 40, 50, null]
    Lista: 1 -> 2 -> 3 -> 4 -> 5 -> null

    - Inserción ordenada en arreglo, inserto 25: [10, 20, 25, 30, 40, 50] es necesario desde antes prevenir el tamaño del arreglo. 
    - Inserción ordenada en lista, inserto 25: 10 -> 20 -> 25 -> 30 -> 40 -> 50 -> null, se inserta entre el 20 y el 30 sin necesidad de mover otros elementos.
    
    - Eliminación ordenada en arreglo, elimino 30: [10, 20, 25, 40, 50, null], es necesario mover los elementos para mantener el orden.
    - Eliminación ordenada en lista, elimino 30: 10 -> 20 -> 25 -> 40 -> 50 -> null, se elimina el nodo sin necesidad de mover otros elementos.
```

- 3) ¿Cuál es la diferencia entre estudios experimentales de algoritmos y análisis asintótico “Big Oh”?

Respuesta:
...
