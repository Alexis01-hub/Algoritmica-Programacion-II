# 🌳 Resumen – Árboles Binarios de Búsqueda
## 📘 Definición general
- Un árbol binario de búsqueda (ABB) es una estructura donde:
    Cada nodo almacena un par clave-valor (k,v).

    - Las claves en el subárbol izquierdo son menores que k.

    - Las claves en el subárbol derecho son mayores que k.

Esto permite búsquedas, inserciones y eliminaciones eficientes en estructuras dinámicas de datos.

## 🔍 Relación con los Mapas Ordenados
- Los ABB implementan mapas ordenados, donde las claves están en un orden total. Esto permite realizar consultas como:

    - Encontrar el elemento con la mayor clave ≤ k

    - Encontrar el elemento con la menor clave ≥ k

### ⚙️ Operaciones Fundamentales en ABB
1. get(k): devuelve el valor asociado a la clave k o null si no existe.

2. put(k, v): inserta o reemplaza el valor v asociado a la clave k.

3. remove(k): elimina la clave k del árbol, si existe.

## 🔍 Búsqueda binaria y tablas
Además de los árboles, un mapa ordenado se puede implementar con una tabla (arreglo) ordenada por clave.
Esto permite usar la búsqueda binaria, que reduce la cantidad de comparaciones a la mitad en cada paso.

- Búsqueda: Muy eficiente → O(log n)

- Inserción y eliminación: Lentas → O(n)
(porque puede requerir mover muchos elementos para mantener el orden)

🔎 Ejemplo práctico: sistema de vuelos
Si usamos como clave (origen, destino, fecha, hora), podemos buscar todos los vuelos en un rango usando subMap(k1, k2).

**💡 Este enfoque es ideal cuando**:

Se hacen muchas búsquedas.

Las inserciones y eliminaciones son poco frecuentes.

## 🌱 Inserción en un ABB
Se realiza comparando la clave a insertar con las existentes, bajando por el árbol hasta encontrar el lugar adecuado (como en búsqueda binaria).

## 🧹 Eliminación en ABB: Dos Casos
✅ Caso 1: Nodo con cero o un hijo interno
Se reemplaza el nodo por su hijo, o se lo elimina directamente si es una hoja.

🔁 Caso 2: Nodo con dos hijos
Se busca el predecesor del nodo (mayor clave del subárbol izquierdo).

Se reemplaza el nodo a eliminar con esa clave.

Se elimina el nodo que contenía el predecesor (que ahora es fácil de eliminar → caso 1).

