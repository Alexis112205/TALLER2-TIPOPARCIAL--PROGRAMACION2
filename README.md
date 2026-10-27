# ⚔️ Parcial II - Programación II (G411)

**Autor:** Alexis
**Programa:** Tecnología en Sistemas de Información

## 📖 Descripción

Juego de batallas entre criaturas en Java, aplicando **polimorfismo** y **clases abstractas**. Cada criatura ataca y se defiende de forma distinta.

## 📁 Estructura

```
├── Arma.java
├── Criatura.java   (clase abstracta)
├── Dragon.java
├── Mago.java
├── Guerrero.java
└── Main.java
```

## 🛠️ Cómo se creó cada clase

### 🧬 `Criatura` (abstracta)
- Atributos `protected`: `nombre`, `salud`, `fuerza`.
- Métodos abstractos: `atacar(Criatura objetivo)` y `defender(int daño)`.
- Método concreto: `estaViva()` (`salud > 0`).

### 🐉 `Dragon`
- `atacar`: daño de `fuerza * 2`.
- `defender`: las escamas reducen el daño en 25 %.

### 🧙 `Mago`
- `atacar`: hechizo con daño igual a `fuerza`.
- `defender`: escudo mágico que absorbe un tercio del daño.

### 🛡️ `Guerrero`
- `atacar`: golpe de espada con daño igual a `fuerza`.
- `defender`: el escudo reduce el daño en 20 %.

### 🎮 `Main`
- `simularBatalla(c1, c2)`: repite rondas hasta que una criatura muere, mostrando cada ataque, la salud y el ganador.
- `main`: simula tres batallas entre criaturas distintas.

## 🗡️ Cómo se agregó la funcionalidad de armas

1. **Se creó la clase `Arma`** con `nombre` y `bonusDaño`, más sus getters.
2. **Se agregó el atributo `arma` en `Criatura`**, junto con el método `equiparArma(Arma arma)`.
3. **Se creó `getBonusArma()` en `Criatura`**: devuelve el bonus del arma, o 0 si no tiene.
4. **Se modificó `atacar` en cada subclase** para sumar el bonus al daño:
   ```java
   int daño = fuerza + getBonusArma();
   ```
5. **En `Main` se equiparon armas** antes de pelear:
   ```java
   mago1.equiparArma(new Arma("Bastón arcano", 5));
   ```

Como `arma` está en la clase padre, todas las criaturas pueden usarla sin repetir código.

## ▶️ Cómo ejecutarlo

```bash
javac -encoding UTF-8 *.java
java Main
```
