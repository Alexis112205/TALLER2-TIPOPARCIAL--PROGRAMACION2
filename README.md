# ⚔️ Parcial II - Programación II (G411)

Autor: Alexis
Programa: Tecnología en Sistemas de Información

## 📖 Descripción

Juego de batallas entre criaturas en Java, usando polimorfismo y clases abstractas. Cada criatura ataca y se defiende de forma distinta.

## 🛠️ Cómo se creó cada clase

### 🧬 Criatura (abstracta)
- Se declaró con la palabra abstract, así que no se puede instanciar directamente.
- Atributos protected: nombre (String), salud (int) y fuerza (int), para que las subclases accedan a ellos.
- Constructor que recibe y asigna los tres atributos.
- Métodos abstractos sin cuerpo: atacar(Criatura objetivo) y defender(int daño). Cada subclase está obligada a implementarlos.
- Método concreto estaViva(): devuelve true si salud > 0.
- Getters: getNombre, getSalud y getFuerza.

### 🐉 Dragon
- Hereda de Criatura con extends y llama al constructor padre con super(nombre, salud, fuerza).
- atacar: calcula el daño como fuerza * 2, imprime el ataque y llama a objetivo.defender(daño).
- defender: resta 25 % del daño (daño - daño / 4) por sus escamas, descuenta el resultado de la salud y evita que baje de 0.

### 🧙 Mago
- Hereda de Criatura y usa super para el constructor.
- atacar: lanza un hechizo con daño igual a fuerza, lo imprime y llama a objetivo.defender(daño).
- defender: su escudo mágico absorbe un tercio del daño (daño - daño / 3). Descuenta el resultado de la salud sin bajar de 0.

### 🛡️ Guerrero
- Hereda de Criatura y usa super para el constructor.
- atacar: golpea con su espada con daño igual a fuerza y llama a objetivo.defender(daño).
- defender: su escudo reduce el daño en 20 % (daño - daño / 5). Descuenta el resultado de la salud sin bajar de 0.

### 🎮 Main
- simularBatalla(c1, c2): muestra a los dos combatientes y repite rondas con un while mientras ambos estén vivos. En cada ronda c1 ataca a c2 y, si c2 sigue viva, contraataca. Al final de cada ronda imprime la salud de ambos.
- Cuando una muere, imprime el ganador, las rondas jugadas y su salud restante.
- main: crea criaturas nuevas para cada combate (Dragon vs Mago, Guerrero vs Dragon y Mago vs Guerrero) y llama a simularBatalla.

## 🗡️ Cómo se agregó la funcionalidad de armas

1. Se creó la clase Arma con nombre y bonusDaño, más sus getters.
2. Se agregó el atributo arma en Criatura y el método equiparArma(Arma arma).
3. Se creó getBonusArma en Criatura: devuelve el bonus del arma o 0 si no tiene.
4. En atacar de cada subclase se suma el bonus al daño:
   ```java
   int daño = fuerza + getBonusArma();
   ```
5. En Main se equiparon armas antes de pelear:
   ```java
   mago1.equiparArma(new Arma("Bastón arcano", 5));
   ```
