package Core;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfCode {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Scanner entrada = new Scanner(System.in);

    public void menu() {
        System.out.println(ANSI_PURPLE + "=== GAME OF CODE ===" + ANSI_RESET);

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("1. Jugar PVP (Jugador vs Jugador)");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> jugarPVP();
                case 0 -> salir = true;
                default -> System.out.println("Opcion no válida.");
            }
        }
        System.out.println("Gracias por jugar.");
    }

    private Entidad elegirClase(String nombreJugador) {
        System.out.println();
        System.out.println("Elige clase para " + nombreJugador + ":");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Monstruo");
        System.out.print("Opcion: ");
        int opcion = entrada.nextInt();

        Entidad pj = null;
        if (opcion == 1) {
            pj = new Guerrero();
        } else if (opcion == 2){
            pj = new Mago();
        } else if (opcion == 3) {
            pj = new Monstruo();
        }

        System.out.print("Introduce nombre para " + nombreJugador + ": ");
        String nombre = entrada.next();
        pj.setName(nombre);

        return pj;
    }

    private void mostrarEstado(Entidad p1, Entidad p2) {
        System.out.println();
        System.out.println(ANSI_CYAN + "----- ESTADO -----" + ANSI_RESET);
        System.out.println(p1.getName() + " (" + p1.getType() + ") - Vida: " + p1.getPuntosVida() + " | Nivel: " + p1.getNivel() + " | XP: " + p1.xp + " | Monedas: " + p1.getMonedas());
        System.out.println(p2.getName() + " (" + p2.getType() + ") - Vida: " + p2.getPuntosVida() + " | Nivel: " + p2.getNivel() + " | XP: " + p2.xp + " | Monedas: " + p2.getMonedas());
        System.out.println("------------------");
    }

    private void turnoJugador(Entidad actual, Entidad rival) {
        System.out.println();
        System.out.println(ANSI_YELLOW + "Turno de " + actual.getName() + ANSI_RESET);
        System.out.println("1. Atacar");
        System.out.println("2. Usar carta");
        System.out.println("3. Pasar turno");
        System.out.println("4. Abrir Tienda");
        System.out.print("Opcion: ");
        int opcion = entrada.nextInt();

        Tienda tienda = new Tienda();

        switch (opcion) {
            case 1:
                actual.atacar(rival);
                break;
            case 2:
                usarCarta(actual, rival);
                break;
            case 3:
                System.out.println(actual.getName() + " pasa el turno.");
                break;
            case 4:
                tienda.abrirTienda(actual);
                break;
            default:
                System.out.println("Opción no válida, pierdes el turno.");
        }
    }

    private void usarCarta(Entidad actual, Entidad rival) {
        ArrayList<Carta> inventario = actual.getInventario();
        if (inventario == null || inventario.isEmpty()) {
            System.out.println("No tienes cartas en el inventario.");
            return;
        }

        System.out.println("Cartas disponibles:");
        for (int i = 0; i < inventario.size(); i++) {
            Carta c = inventario.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " (" + c.getDescripcion() + ")");
        }
        System.out.println("0. Cancelar");
        System.out.print("Elige carta: ");
        int op = entrada.nextInt();

        if (op > 0 && op <= inventario.size()) {
            Carta elegida = inventario.get(op - 1);
            System.out.println("¿Sobre quién quieres usar la carta?");
            System.out.println("1. Sobre mí (" + actual.getName() + ")");
            System.out.println("2. Sobre rival (" + rival.getName() + ")");
            int objetivoOp = entrada.nextInt();

            Entidad objetivo = (objetivoOp == 2) ? rival : actual;
            elegida.aplicar(objetivo);

            inventario.remove(elegida);
        }
    }

    private void jugarPVP() {
        System.out.println(ANSI_GREEN + "--- MODO PVP ---" + ANSI_RESET);

        Entidad jugador1 = elegirClase("Jugador 1");
        Entidad jugador2 = elegirClase("Jugador 2");

        Entidad turnoActual = jugador1;
        Entidad turnoRival = jugador2;

        while (jugador1.getVivo() && jugador2.getVivo()) {
            mostrarEstado(jugador1, jugador2);
            turnoJugador(turnoActual, turnoRival);

            Entidad temp = turnoActual;
            turnoActual = turnoRival;
            turnoRival = temp;
        }

        System.out.println();
        System.out.println(ANSI_RED + "¡FIN DEL COMBATE!" + ANSI_RESET);
        if (jugador1.getVivo()) {
            System.out.println("Ganador: " + jugador1.getName());
        } else if (jugador2.getVivo()) {
            System.out.println("Ganador: " + jugador2.getName());
        } else {
            System.out.println("Empate, ambos han caído.");
        }
    }
}
