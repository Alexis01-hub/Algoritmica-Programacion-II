# 🗂️ Resumen: Mapas (o Diccionarios / Arreglos Asociativos)
**¿Qué es un mapa?**
    Un mapa es una estructura de datos que guarda pares clave-valor (k, v).
    Cada clave debe ser única y permite acceder rápidamente a su valor sin buscar en todo el conjunto.

- Ejemplo:
```
Clave: "usuario123" → Valor: "Juan Pérez"
```

### Diferencias con un arreglo
- En un arreglo, la clave es un índice numérico (0, 1, 2...).

- En un mapa, la clave puede ser cualquier identificador único (string, ID, nombre...).

### Ejemplos Reales:

| Contexto    | Clave         | Valor                  |
| ----------- | ------------- | ---------------------- |
| Web         | URL           | Contenido de la página |
| Universidad | Legajo        | Datos del estudiante   |
| DNS         | `google.com`  | IP `142.250.64.78`     |
| Empresa     | ID de cliente | Datos del cliente      |
| Gráficos    | `'turquesa'`  | `(64, 224, 208)` (RGB) |

## Operaciones del TAD Map
```
size() → cantidad de entradas.

isEmpty() → ¿está vacío?

get(k) → devuelve el valor asociado a k (o null si no existe).

put(k, v) → agrega o actualiza el valor de k.

remove(k) → elimina la entrada con clave k.

keySet() → conjunto de claves.

values() → colección de valores.

entrySet() → conjunto de pares (k, v).
```

- [🚀 HASH MAP en JAVA POO 🖥️ | COLLECTIONS | Explicación FÁCIL 💥#16 Bis](https://www.youtube.com/watch?v=jT0gnObfFls)

