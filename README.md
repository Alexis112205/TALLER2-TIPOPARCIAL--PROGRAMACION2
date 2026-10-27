# Parcial II - Programacion

**Autor:** Alexis
**Programa:** Tecnología en Sistemas de Información

## Descripción

Juego de batallas entre criaturas desarrollado en Java, aplicando **polimorfismo** y **clases abstractas**. Cada criatura tiene su propia forma de atacar y de defenderse.

## Estructura del proyecto

```
├── Criatura.java    (clase abstracta)
├── Dragon.java      (subclase)
├── Mago.java        (subclase)
├── Guerrero.java    (subclase)
└── Main.java        (simulación de batallas y clase principal)
```

## Cómo se creó cada clase

### 1. `Criatura` (clase abstracta)

Es la clase base de todas las criaturas. Se declaró como `abstract` para que no se pueda instanciar directamente y sirva solo como molde.

- **Atributos:** `nombre`, `salud` y `fuerza`, declarados `protected` para que las subclases accedan a ellos directamente.
- **Constructor:** recibe y asigna los tres atributos.
- **Métodos abstractos:** `atacar(Criatura objetivo)` y `defender(int daño)`. No tienen cuerpo; cada subclase está obligada a implementarlos a su manera.
- **Método concreto:** `estaViva()`, que devuelve `true` si `salud > 0`. Se escribió una sola vez porque la regla es igual para todas.
- **Getters:** `getNombre()`, `getSalud()` y `getFuerza()`, necesarios para mostrar información durante la batalla.

### 2. `Dragon`

Hereda de `Criatura` con `extends` y llama al constructor padre con `super(...)`.

- **`atacar`:** lanza una llamarada con un daño de `fuerza * 2` (el ataque más fuerte) y llama a `objetivo.defender(daño)`.
- **`defender`:** sus escamas reducen el daño recibido en un 25 %. La salud nunca baja de 0.

### 3. `Mago`

Hereda de `Criatura`.

- **`atacar`:** ataca con hechizos, con un daño igual a `fuerza`.
- **`defender`:** crea un escudo mágico que absorbe un tercio del daño. La salud nunca baja de 0.

### 4. `Guerrero`

Hereda de `Criatura`.

- **`atacar`:** golpea con su espada, con un daño igual a `fuerza`.
- **`defender`:** se cubre con su escudo, que reduce el daño en un 20 %. La salud nunca baja de 0.

### 5. `Main` (simulación de batallas)

- **`simularBatalla(Criatura c1, Criatura c2)`:** muestra a los combatientes y repite rondas mientras ambos estén vivos. En cada ronda `c1` ataca a `c2` y, si `c2` sobrevive, contraataca. Al final de cada ronda imprime la salud de ambos y, cuando una criatura muere, muestra el ganador, las rondas jugadas y su salud restante.
- **`main`:** crea criaturas nuevas para cada combate y simula tres batallas: Dragón vs Mago, Guerrero vs Dragón y Mago vs Guerrero.

## Polimorfismo en acción

Las variables se declaran del tipo `Criatura`, pero guardan objetos de las subclases:

```java
Criatura dragon = new Dragon("Smaug", 150, 15);
Criatura mago = new Mago("Merlín", 100, 25);
dragon.atacar(mago);
```

Al llamar a `atacar` o `defender`, Java ejecuta la versión de la clase real del objeto. Por eso `simularBatalla` funciona con cualquier criatura sin saber de qué tipo es.

## Cómo ejecutarlo

```bash
javac -encoding UTF-8 *.java
java Main
```
