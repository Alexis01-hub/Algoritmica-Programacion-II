# 📘 Resumen: Tablas Hash
**🔹 ¿Qué es una Tabla Hash?**

- Es una estructura de datos muy eficiente para implementar mapas (diccionarios).

- Usa una función hash para mapear claves (de cualquier tipo) a índices dentro de un arreglo de cubetas.

- Cada índice puede contener una o más entradas, especialmente cuando ocurren colisiones.

**🔹 Desafíos al implementarlas**

1. No siempre queremos usar un arreglo de tamaño fijo N si hay pocas claves (n < N).

2. Las claves no necesariamente son enteros.

## 🧮 Funciones Hash
**Objetivo**: Convertir una clave k en un entero h(k) dentro del rango [0, N-1].

Se compone de:

- Un código hash: transforma la clave en un número entero.

- Una función de compresión: adapta ese número al rango del arreglo.

## 🧠 Tipos de Códigos Hash
Bit a entero: uso directo de los bits del dato (ej. int, float, etc.).

Polinomial: tiene en cuenta el orden de los caracteres, útil para strings.

Evita colisiones comunes como entre "stop" y "pots".

Desplazamiento cíclico: rota bits para distribuir mejor los valores.

Java:

Todo objeto tiene hashCode().

Clases como String implementan su propio código hash coherente con equals().

## ⚙️ Funciones de Compresión
- Módulo: h(k) mod N.

- MAD (Multiplicación, Adición y División): [(a * h(k) + b) mod p] mod N.

    Mejora la distribución y reduce colisiones.

## 💥 Colisiones y Cómo Manejaras
1. Encadenamiento separado:

    Cada posición de la tabla almacena una estructura secundaria (lista).

    Sencillo y eficiente si h(k) está bien distribuida.

2. Direccionamiento abierto:

    Las entradas se almacenan directamente en el arreglo.

    Evita estructuras auxiliares.

    Ejemplos: sondeo lineal, cuadrático, etc. (no se estudian en el curso).

## 🧪 Ejemplo de Tabla Hash con Encadenamiento Separado
Supongamos que queremos guardar las siguientes claves con sus valores:

    (21, "A"), (32, "B"), (43, "C"), (54, "D")

Y usamos una función hash simple:

    h(k) = k mod 5

Entonces, calculamos los índices:
```
h(21) = 21 mod 5 = 1
h(32) = 32 mod 5 = 2
h(43) = 43 mod 5 = 3
h(54) = 54 mod 5 = 4
```
📋 Tabla hash resultante (con 5 cubetas):
```
Índice | Contenido
-----------------------
  0    | [   ]
  1    | [(21, "A")]
  2    | [(32, "B")]
  3    | [(43, "C")]
  4    | [(54, "D")]

```

🔁 Agregamos una nueva clave que produce colisión:

    (16, "E") → h(16) = 16 mod 5 = 1

En el índice 1 ya está (21, "A"), así que agregamos (16, "E") a la lista del índice 1.

📋 Tabla actualizada con colisión (encadenamiento separado):
```
Índice | Contenido
-------------------------------
  0    | [   ]
  1    | [(21, "A"), (16, "E")] ← colisión
  2    | [(32, "B")]
  3    | [(43, "C")]
  4    | [(54, "D")]

```


- [Entiende por fin el Hashing y las Tablas Hash | Estructuras de Datos](https://www.youtube.com/watch?v=CrXDTPE4DQI)
- [🚀 HASH MAP en JAVA POO 🖥️ | COLLECTIONS | Explicación FÁCIL 💥#16 Bis](https://www.youtube.com/watch?v=jT0gnObfFls)