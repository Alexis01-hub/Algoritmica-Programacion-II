# Apunte: Programación Orientada a Objetos (POO)

## 1. Conceptos Básicos
- **Objetos y Clases**  
  - Un objeto es una instancia de una clase.  
  - Una clase define las **variables de instancia** (atributos) y **métodos** (comportamientos).  

- **Metas de POO**  
  - ✅ **Robustez**: Manejar entradas inesperadas.  
  - ✅ **Adaptabilidad**: Evolucionar con cambios en el entorno.  
  - ✅ **Reusabilidad**: Utilizar código en diferentes sistemas.

## 2. Tipos Abstractos de Datos (TAD)
### Definición
Un **Tipo Abstracto de Dato (TAD)** es un modelo matemático que especifica:
- Un **conjunto de datos** (estructura de almacenamiento)
- Un **conjunto de operaciones** que pueden realizarse sobre esos datos
- El **comportamiento esperado** de dichas operaciones

**Características principales**:
- ✨ **Abstracción**: Oculta los detalles de implementación
- 🛡️ **Encapsulamiento**: Protege los datos internos
- 📜 **Interfaz definida**: Operaciones públicas claramente especificadas

```java
public class Tamagotchi {
    // 🛡️ Datos encapsulados (privados)
    private String nombre;
    private int energia;
    private int felicidad;
    private boolean estaDormido;
    
    // 🏗️ Constructor
    public Tamagotchi(String nombre) {
        this.nombre = nombre;
        this.energia = 100;
        this.felicidad = 50;
        this.estaDormido = false;
    }
    
    // 🎮 Interfaz pública (operaciones)
    public void alimentar() {
        if(!estaDormido) {
            energia += 20;
            felicidad += 10;
            System.out.println(nombre + " dice: ¡Ñam ñam!");
        }
    }
    
    public void jugar() {
        if(!estaDormido && energia > 10) {
            energia -= 15;
            felicidad += 30;
            System.out.println(nombre + " dice: ¡Es divertido!");
        }
    }
    
    public void dormir() {
        estaDormido = true;
        energia += 40;
        System.out.println(nombre + " zzzZZZ...");
    }
    
    public void despertar() {
        estaDormido = false;
        System.out.println(nombre + " dice: ¡Buenos días!");
    }
    
    // 🔍 Getters (consultas)
    public String getEstado() {
        return "Energía: " + energia + ", Felicidad: " + felicidad;
    }
}
//IMPLEMENTACION
public class Main {
    public static void main(String[] args) {
        Tamagotchi mascota = new Tamagotchi("Pikachu");
        
        mascota.alimentar();    // Pikachu dice: ¡Ñam ñam!
        mascota.jugar();        // Pikachu dice: ¡Es divertido!
        mascota.dormir();       // Pikachu zzzZZZ...
        
        System.out.println(mascota.getEstado());  // Muestra energía y felicidad
    }
}
```
### Qué hace este TAD (Operaciones/Interfaz)

1. `alimentar()` → Aumenta energía y felicidad  
2. `jugar()` → Reduce energía pero aumenta felicidad  
3. `dormir()` → Cambia estado y recupera energía  
4. `despertar()` → Cambia estado  
5. `getEstado()` → Consulta datos (sin modificar)  

### Qué lo hace un TAD

1. **Abstracción:**  
   - Oculta cómo se calcula la energía/felicidad (solo muestra qué puede hacer).  
   - Ejemplo: El usuario llama `alimentar()` pero no ve las fórmulas internas.  

2. **Encapsulamiento:**  
   - Los atributos (`energía`, `felicidad`) son privados. Solo se modifican mediante los métodos públicos.  

3. **Interfaz clara:**  
   - Métodos bien definidos (`public`) para interactuar con la mascota.  

4. **Independencia del "cómo":**  
   - Podrías cambiar la implementación interna (ej: usar `double` en vez de `int` para la energía) sin afectar a quien usa el TAD.

   ## Principios de Diseño Orientado a Objetos

### 1. Abstracción
**Definición:**  
Representación simplificada de un objeto, mostrando solo lo esencial.

**Ejemplo:**
```java
public abstract class Figura {
    public abstract double calcularArea();
}
```
### 2. Encapsulamiento
**Definición:**
Ocultamiento de los detalles internos de un objeto.
```java
public class Persona {
    private String nombre;
    
    public void setNombre(String nombre) {
        if(nombre != null) {
            this.nombre = nombre;
        }
    }
}
```
### 3. Modularidad
**Definición:**
Organización del sistema en componentes independientes.
```
src/
├── moduloClientes/
├── moduloProductos/
└── moduloVentas/
```

**Comparativa**
| Principio       | Objetivo       | Técnica Clave               |
|----------------|---------------|-----------------------------|
| Abstracción    | Simplificar   | Interfaces/clases abstractas |
| Encapsulamiento| Proteger datos| Modificadores de acceso     |
| Modularidad    | Organizar     | Paquetes/componentes        |

## Diseño de Software Orientado a Objeto
• **Responsibilidades:** Divida el trabajo en diferentes actores (clases),
cada uno con una responsabilidad diferente.

• **Independencia:** Defina el trabajo para cada clase para ser tan
independiente de otras clases como sea posible.

• **Comportamientos:** Defina los comportamientos de cada clase con
cuidado y precisión, de modo que las consecuencias de cada acción
realizada por una clase sean bien comprendidas por otras clases que
interactúen con ella.

### 4. UML
**Un diagrama de clase tiene tres porciones:**
1. El nombre de la clase
2. Las variables de instancia recomendadas
3. Los métodos de clases recomendados.

**Ejemplo clase Base: `Animal`**
```plaintext
+---------------+
|    Animal     |
+---------------+
| - nombre: String |
| - edad: int    |
+---------------+
| + comer()     |
| + dormir()    |
+---------------+
```
**Símbolos de Acceso en UML**

```plaintext
+------------------------+
|       Símbolos         |
+------------------------+
| + público              |
| - privado              |
| # protegido            |
+------------------------+
```
## Definición de Clases 
- Una clase sirve como el medio principal para la abstracción en la
programación orientada a objetos.
- En Java, cada variable es un tipo base (primitivo) o es una referencia a una
instancia de alguna clase.
- Una clase proporciona un conjunto de comportamientos en forma de
funciones miembro (también conocidas como métodos), con
implementaciones que pertenecen a todas sus instancias.
- Una clase también sirve como modelo para sus instancias, determinando
de manera efectiva la forma en que se representa la información de estado
para cada instancia en forma de atributos (también conocidos como
campos, variables de instancia o miembros de datos).

## Constructores
- Un usuario puede crear una instancia de una clase utilizando el
operador new con un método que tiene el mismo nombre que la
clase.
- Tal método, conocido como constructor, tiene como responsabilidad
establecer el estado de un nuevo objeto con valores iniciales
apropiados para sus variables de instancia.

### 5. Herencia
+ *Extensión:* Subclases heredan atributos/métodos de superclases.

+ *Constructores:* No se heredan; usan super() para inicializar campos heredados.

**Ejemplo:**
```java
// Clase padre o superclase
class Animal {
    String nombre;

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

// Clase hija o subclase que hereda de Animal
class Perro extends Animal {

    public void moverCola() {
        System.out.println(nombre + " mueve la cola");
    }

    // Sobrescritura del método hacerSonido()
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau!");
    }
}

// Clase principal para probar
public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro();
        miPerro.nombre = "Firulais";
        miPerro.hacerSonido();  // Firulais dice: ¡Guau!
        miPerro.moverCola();    // Firulais mueve la cola
    }
}
```
### 6. Clases Abstractas
- Uso: Definir métodos abstractos (sin cuerpo) para implementación en subclases.
```java
// Clase abstracta
abstract class Animal {
    String nombre;

    // Método concreto
    public void dormir() {
        System.out.println(nombre + " está durmiendo...");
    }

    // Método abstracto (sin implementación)
    public abstract void hacerSonido();
}

// Subclase que implementa los métodos abstractos
class Gato extends Animal {

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }
}

// Clase principal para probar
public class Main {
    public static void main(String[] args) {
        Gato miGato = new Gato();
        miGato.nombre = "Michifú";
        miGato.hacerSonido();   // Michifú dice: ¡Miau!
        miGato.dormir();        // Michifú está durmiendo...
    }
}
```

//El nombre de un arreglo es la direccion de memoria
### 7. Interface
Una **interfaz** en Java es un **contrato** que define qué métodos debe implementar una clase, pero no cómo lo hace (a menos que sean métodos default o static).

📌 **Características principales**:
- Solo contiene métodos abstractos (antes de Java 8).
- Puede tener métodos default y static con implementación (desde Java 8).
- Solo admite constantes (public static final).
- No se puede instanciar (como las clases abstractas).
- Una clase puede implementar múltiples interfaces (herencia múltiple).

``` java
interface Animal {
    void hacerSonido();  // Método abstracto (sin implementación)
}

class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("¡Guau!");  // Implementación obligatoria
    }
}
```
### 8. Excepciones
- Se manejan con bloques ```try - catch```.

- Se lanzan con ```throw``` y se declaran con ```throws```

```java
public class EjemploExcepcion {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0;  // Esto lanza ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero.");
        }

        System.out.println("Fin del programa.");
    }
}
```
### 9. Casting
- **Upcasting:** Subclase a superclase (automático).
- **Downcasting:** Superclase a subclase (requiere cast explícito).
```java
Animal a = new Perro();             // Upcasting
Perro p = (Perro) a;                // Downcasting
```
### 10. Genericos
Permiten escribir clases/métodos que funcionan con cualquier tipo de dato.
```java
// Clase genérica
class Caja<T> {
    private T contenido;

    public void guardar(T valor) {
        contenido = valor;
    }

    public T obtener() {
        return contenido;
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola mundo");
        System.out.println(cajaTexto.obtener()); // Muestra: Hola mundo

        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(123);
        System.out.println(cajaNumero.obtener()); // Muestra: 123
    }
}
```