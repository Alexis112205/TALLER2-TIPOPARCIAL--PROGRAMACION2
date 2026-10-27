# ⚔️ Parcial II - Programación II (G411)

Autor: Alexis
Programa: Tecnología en Sistemas de Información

## 📖 Descripción

Juego de batallas entre criaturas en Java, usando polimorfismo y clases abstractas. Cada criatura ataca y se defiende de forma distinta.

## 🛠️ Cómo se creó cada clase

### 🧬 Criatura (abstracta)
- Atributos: nombre, salud y fuerza.
- Métodos abstractos: atacar y defender.
- Método concreto: estaViva (salud > 0).

### 🐉 Dragon
- Ataca con fuerza * 2.
- Sus escamas reducen el daño en 25 %.

### 🧙 Mago
- Ataca con hechizos (fuerza).
- Su escudo mágico absorbe un tercio del daño.

### 🛡️ Guerrero
- Ataca con su espada (fuerza).
- Su escudo reduce el daño en 20 %.

### 🎮 Main
- simularBatalla: repite rondas hasta que una criatura muere, mostrando cada ataque, la salud y el ganador.
- main: crea las criaturas y simula tres batallas.

## 🗡️ Cómo se agregó la funcionalidad de armas

1. Se creó la clase Arma con nombre y bonusDaño.
2. Se agregó el atributo arma en Criatura y el método equiparArma.
3. Se creó getBonusArma, que devuelve el bonus del arma o 0 si no tiene.
4. En atacar de cada subclase se suma el bonus al daño:
   ```java
   int daño = fuerza + getBonusArma();
   ```
5. En Main se equiparon armas antes de pelear:
   ```java
   mago1.equiparArma(new Arma("Bastón arcano", 5));
   ```
