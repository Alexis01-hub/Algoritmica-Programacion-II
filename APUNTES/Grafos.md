## 📌 Apunte sobre Grafos – Algorítmica y Programación II

### 📘 Definición de Grafo

* Un **grafo G = (V, E)** es una colección de **vértices (nodos)** conectados por **aristas (edges)** o **arcos**.
* Las **aristas pueden ser dirigidas** (ordenadas) o **no dirigidas** (no ordenadas).

#### 📝 Representación visual:

```
Grafo no dirigido:       Grafo dirigido:

    A---B                 A ---> B
    |   |                 ^      |
    C---D                 |      v
                          D <--- C
```

---

### 🔄 Tipos de Relaciones

* **Simétricas**: Ejemplo, coautoría (si A es coautor de B, entonces B lo es de A).
* **Herencia (POO)**: Grafo dirigido donde una clase v hereda de otra clase u.

```java
// Ejemplo en Java: herencia entre clases
class Animal {}
class Perro extends Animal {}
class Gato extends Animal {}
```

Esto puede representarse como:

```
Animal --> Perro
       --> Gato
```

---

### 🏩 Ejemplos Comunes

* Intersecciones de calles
* Red de vuelos: aeropuertos (vértices) y vuelos (aristas)
* Líneas de colectivo
* Red eléctrica o de cañerías

---

### 🧹 Caminos y Ciclos

* **Camino (path)**: secuencia de vértices unidos por arcos
* **Ciclo**: camino que inicia y termina en el mismo vértice
* **Camino simple**: sin vértices ni arcos repetidos


---

### 📏 Subgrafos y Árboles

* **Subgrafo**: subconjunto de vértices y aristas de G
* **Árbol**: grafo conexo sin ciclos
* **Bosque**: conjunto de árboles (grafo sin ciclos, no necesariamente conexo)

#### 📃 Ejemplo visual:

```
Grafo original:     Subgrafo (arbol):
 A---B              A---B
 |   |               \
 C---D                C
```

---

### 💡 TAD Grafo (Tipo Abstracto de Datos)

#### Métodos clave:

* `insertVertex(x)`, `insertEdge(u, v, x)`
* `getEdge(u,v)`, `endVertices(e)`
* `outDegree(v)`, `inDegree(v)`
* `removeVertex(v)`, `removeEdge(e)`

```java
Graph<String, Integer> grafo = new AdjacencyMapGraph<>(false);
Vertex<String> v1 = grafo.insertVertex("A");
Vertex<String> v2 = grafo.insertVertex("B");
grafo.insertEdge(v1, v2, 5); // Arista con peso 5
```

---

### 🔹 Representaciones Internas

* Lista de arcos
* Lista/mapa de adyacencia
* Matriz de adyacencia (n x n) → acceso O(1)

#### 📊 Matriz de adyacencia (ejemplo):

```
   A B C
A [0 1 0]
B [1 0 1]
C [0 1 0]
```

---

### 🔍 Recorridos de Grafos

#### 🔎 DFS (Búsqueda en Profundidad)

* Explora lo más profundo primero
* Usa pila o recursión
* Tiempo: O(n + m)

```java
void DFS(Graph g, Vertex v, Set<Vertex> visitados) {
    visitados.add(v);
    for (Edge e : g.outgoingEdges(v)) {
        Vertex w = g.opposite(v, e);
        if (!visitados.contains(w)) {
            DFS(g, w, visitados);
        }
    }
}
```

#### 🔎 BFS (Búsqueda en Amplitud)

* Explora primero los vecinos inmediatos
* Usa cola
* Tiempo: O(n + m)

```java
void BFS(Graph g, Vertex s) {
    Queue<Vertex> q = new LinkedList<>();
    Set<Vertex> visitados = new HashSet<>();
    q.add(s);
    visitados.add(s);
    while (!q.isEmpty()) {
        Vertex v = q.poll();
        for (Edge e : g.outgoingEdges(v)) {
            Vertex w = g.opposite(v, e);
            if (!visitados.contains(w)) {
                visitados.add(w);
                q.add(w);
            }
        }
    }
}
```

---

### ⚖️ Comparativa DFS vs. BFS

| Característica   | DFS              | BFS                   |
| ---------------- | ---------------- | --------------------- |
| Estructura       | Pila / recursión | Cola                  |
| Explora primero  | Profundidad      | Amplitud              |
| Camino más corto | No garantiza     | Sí (en nº de aristas) |
| Tiempo           | O(n + m)         | O(n + m)              |

---

### 📚 Bibliografía

* *Data Structures and Algorithms in Java*, Goodrich, Tamassia & Goldwasser – 6ª Ed., Wiley, 2014

