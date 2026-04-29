package Core;

public class CartaRevivir extends Carta {

    public CartaRevivir() {
        super("Tótem de Reaparicion", "Revive a una entidad caída con 1 PV.", Rareza.LEGENDARIA, 100);
    }

    @Override
    public void aplicar(Entidad objetivo) {
        if (!objetivo.getVivo()) {
            objetivo.setVivo(true);
            objetivo.setPuntosVida(1);
            System.out.println(objetivo.getName() + " ha revivido gracias al tótem.");
        } else {
            System.out.println("El objetivo ya está vivo. El tótem se consume sin efecto.");
        }
    }
}
