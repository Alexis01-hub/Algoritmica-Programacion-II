# Resumen: Árboles AVL

## 1. Conceptos Básicos
- **Árbol AVL**: Árbol binario de búsqueda auto-balanceable donde la diferencia de alturas entre subárboles izquierdo y derecho de cualquier nodo es ≤ 1.

## Recorrido en amplitud (Breadth-First Traversal)
- Utiliza una cola (FIFO) para recorrer el árbol por niveles.
- Se visitan los nodos en el orden en que fueron agregados.

```
     A
    / \
   B   C
  / \
 D   E
```
Recorrido BFS: `A → B → C → D → E`

## Arboles Balanceados

- **Se logra el balanceo mediante rotaciones**:

    - Rotación simple (izquierda o derecha).

    - Rotación doble (reorganización mediante trinodos).

**Ejemplo de rotación simple (derecha)**:

- Antes:
```
     C
    /
   B
  /
 A
```
- Despues:
```
   B
  / \
 A   C
```

## Arboles AVL
- **Operaciones básicas**:

    - Inserción: puede causar desbalance que se corrige con rotaciones.

    - Eliminación: también puede requerir reequilibrar.

**Ejemplo (rotación doble izq-der)**:

Insertás en este orden: 30, 40, 35
```
   30           30
     \     →      \
      40           35
     /               \
   35                 40
```
Despues de balancear:
```
   35
  /  \
 30   40
```


