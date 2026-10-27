public class Guerrero extends Criatura {

    public Guerrero(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza;
        System.out.println(nombre + " golpea con su espada a " + objetivo.getNombre()
                + " y causa " + daño + " de daño.");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int dañoRecibido = daño - (daño / 5);
        salud -= dañoRecibido;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " se cubre con su escudo y recibe " + dañoRecibido
                + " de daño. Salud actual: " + salud);
    }
}
