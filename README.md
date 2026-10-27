# ⚔️ Parcial II - Programación II (G411)

Autor: Alexis
Programa: Tecnología en Sistemas de Información

## 📖 Descripción

Juego de batallas entre criaturas en Java, usando polimorfismo y clases abstractas. Cada criatura ataca y se defiende de forma distinta.

## 🛠️ Cómo se creó cada clase

### 🧬 Criatura

La clase Criatura se declaró con la palabra abstract, así que no se puede instanciar directamente y solo sirve como molde para las demás. Tiene los atributos protected nombre, salud y fuerza para que las subclases accedan a ellos, un constructor que los asigna, los métodos abstractos atacar(Criatura objetivo) y defender(int daño), que cada subclase está obligada a implementar, y el método concreto estaViva(), que devuelve true si la salud es mayor que 0. También tiene los getters getNombre, getSalud y getFuerza.

### 🐉 Dragon

La clase Dragon hereda de Criatura con extends y llama al constructor padre con super. En atacar calcula el daño como fuerza * 2, imprime el ataque y llama a objetivo.defender(daño). En defender, sus escamas reducen el daño en un 25 % (daño - daño / 4), el resultado se descuenta de la salud y se evita que baje de 0.

### 🧙 Mago

La clase Mago también hereda de Criatura. Su método atacar lanza un hechizo con daño igual a fuerza y llama a objetivo.defender(daño). En defender, su escudo mágico absorbe un tercio del daño (daño - daño / 3), y el resultado se descuenta de la salud sin bajar de 0.

### 🛡️ Guerrero

La clase Guerrero hereda de Criatura. En atacar golpea con su espada con daño igual a fuerza y llama a objetivo.defender(daño). En defender, su escudo reduce el daño en un 20 % (daño - daño / 5), y el resultado se descuenta de la salud sin bajar de 0.

### 🎮 Main

La clase Main tiene el método simularBatalla(c1, c2), que muestra a los dos combatientes y repite rondas con un while mientras ambos estén vivos. En cada ronda c1 ataca a c2 y, si c2 sigue viva, contraataca; al final de la ronda imprime la salud de ambos. Cuando una muere, imprime el ganador, las rondas jugadas y su salud restante. El método main crea criaturas nuevas para cada combate (Dragon vs Mago, Guerrero vs Dragon y Mago vs Guerrero) y llama a simularBatalla.

## 🗡️ Cómo se agregó la funcionalidad de armas

Primero se creó la clase Arma con los atributos nombre y bonusDaño y sus getters. Luego se agregó en Criatura el atributo arma, el método equiparArma(Arma arma) y el método getBonusArma, que devuelve el bonus del arma o 0 si la criatura no tiene. Después, en el método atacar de cada subclase se suma ese bonus al daño, por ejemplo:

```java
int daño = fuerza + getBonusArma();
```

Por último, en Main se equiparon armas antes de las batallas:

```java
mago1.equiparArma(new Arma("Bastón arcano", 5));
```
