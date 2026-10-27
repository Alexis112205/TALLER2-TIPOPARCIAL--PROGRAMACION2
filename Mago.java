public class Mago extends Criatura {

    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza;
        System.out.println(nombre + " lanza un hechizo a " + objetivo.getNombre()
                + " y causa " + daño + " de daño.");
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        int dañoRecibido = daño - (daño / 3);
        salud -= dañoRecibido;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " crea un escudo mágico y recibe " + dañoRecibido
                + " de daño. Salud actual: " + salud);
    }
}
