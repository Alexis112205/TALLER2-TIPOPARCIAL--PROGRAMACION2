public class Main {

    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("=== BATALLA: " + c1.getNombre() + " vs " + c2.getNombre() + " ===");
        System.out.println(c1.getNombre() + " (salud " + c1.getSalud() + ") | "
                + c2.getNombre() + " (salud " + c2.getSalud() + ")");

        int ronda = 1;
        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            c1.atacar(c2);

            if (c2.estaViva()) {
                c2.atacar(c1);
            }

            System.out.println("Salud -> " + c1.getNombre() + ": " + c1.getSalud()
                    + " | " + c2.getNombre() + ": " + c2.getSalud());
            ronda++;
        }

        Criatura ganador = c1.estaViva() ? c1 : c2;
        System.out.println("\nResultado final: ¡" + ganador.getNombre() + " gana la batalla en "
                + (ronda - 1) + " rondas con " + ganador.getSalud() + " de salud!");
        System.out.println();
    }

    public static void main(String[] args) {
        Criatura dragon1 = new Dragon("Smaug", 150, 15);
        Criatura mago1 = new Mago("Merlín", 100, 25);
        simularBatalla(dragon1, mago1);

        Criatura guerrero1 = new Guerrero("Aragorn", 120, 20);
        Criatura dragon2 = new Dragon("Drogon", 140, 14);
        simularBatalla(guerrero1, dragon2);

        Criatura mago2 = new Mago("Gandalf", 100, 22);
        Criatura guerrero2 = new Guerrero("Conan", 130, 18);
        simularBatalla(mago2, guerrero2);
    }
}
