package Core;

import java.util.Scanner;
import java.util.ArrayList;

public class Tienda {
    private ArrayList<Carta> stock;

    public Tienda() {
        stock = new ArrayList<>();
        stock.add(new CartaPocionMayor());
        stock.add(new CartaDagaEnvenenada());
        stock.add(new CartaXP());
        stock.add(new CartaSubirNivel());
        stock.add(new CartaRevivir());
    }

    public void abrirTienda(Entidad comprador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BIENVENIDO A LA TIENDA ---");
        System.out.println("Tus monedas: " + comprador.getMonedas());

        for (int i = 0; i < stock.size(); i++) {
            Carta c = stock.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " | " + c.getRareza() + " | Precio: " + c.getPrecio());
        }
        System.out.println("0. Salir");

        System.out.print("Elige una carta para comprar: ");
        int opcion = scanner.nextInt();

        if (opcion > 0 && opcion <= stock.size()) {
            Carta cartaElegida = stock.get(opcion - 1);

            if (comprador.getMonedas() >= cartaElegida.getPrecio()) {
                comprador.gastarMonedas(cartaElegida.getPrecio());

                comprador.recibirCarta(cartaElegida);

                System.out.println("¡Has comprado " + cartaElegida.getNombre() + "!");
            } else {
                System.out.println("No tienes suficientes monedas.");
            }
        }
    }
}
