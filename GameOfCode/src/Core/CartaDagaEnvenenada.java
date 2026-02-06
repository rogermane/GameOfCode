package Core;

public class CartaDagaEnvenenada extends Carta {

    private int dano;

    public CartaDagaEnvenenada() {
        super("Daga Envenenada", "Inflige 30 de daño. Puede ser letal.", Rareza.POCO_COMUN, 25);
        this.dano = 30;
    }

    @Override
    public void aplicar(Entidad objetivo) {
        if (!objetivo.getVivo()) return;

        int nuevaVida = objetivo.getPuntosVida() - dano;
        objetivo.setPuntosVida(Math.max(0, nuevaVida)); // Evita vida negativa

        System.out.println(objetivo.getName() + " recibe " + dano + " de daño.");

        if (objetivo.getPuntosVida() <= 0) {
            objetivo.setVivo(false);
            System.out.println(objetivo.getName() + " ha muerto por el veneno.");
        }
    }
}
