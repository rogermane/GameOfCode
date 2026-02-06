package Core;

public class CartaXP extends Carta {

    private int experienciaGanada;

    public CartaXP() {
        super("Tomar XP", "Otorga 100 puntos de experiencia.", Rareza.RARA, 45);
        this.experienciaGanada = 100;
    }

    @Override
    public void aplicar(Entidad objetivo) {
        if (objetivo.getVivo()) {

            objetivo.ganarXp(experienciaGanada);
            System.out.println(objetivo.getName() + " ganó " + experienciaGanada + " XP.");
        }
    }
}
