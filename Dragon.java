public class Dragon extends Criatura {

    public Dragon(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    // Ataque más fuerte: fuerza * 2
    @Override
    public void atacar(Criatura objetivo) {
        int daño = fuerza * 2;
        System.out.println(nombre + " lanza una llamarada a " + objetivo.getNombre()
                + " y causa " + daño + " de daño.");
        objetivo.defender(daño);
    }

    // Forma única de defender: sus escamas reducen el daño en un 25%
    @Override
    public void defender(int daño) {
        int dañoRecibido = daño - (daño / 4);
        salud -= dañoRecibido;
        if (salud < 0) {
            salud = 0;
        }
        System.out.println(nombre + " resiste con sus escamas y recibe " + dañoRecibido
                + " de daño. Salud actual: " + salud);
    }
}
