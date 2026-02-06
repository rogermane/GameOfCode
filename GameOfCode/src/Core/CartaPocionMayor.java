package Core;

public class CartaPocionMayor extends Carta {

    private int cantidadCuracion;

    public CartaPocionMayor() {
        super("Poción Mayor", "Restaura 50 puntos de vida.", Rareza.COMUN, 15);
        this.cantidadCuracion = 50;
    }

    @Override
    public void aplicar(Entidad objetivo) {
        if (objetivo.getVivo()) {
            int nuevaVida = objetivo.getPuntosVida() + cantidadCuracion;
            objetivo.setPuntosVida(nuevaVida);
            System.out.println(objetivo.getName() + " ha recuperado " + cantidadCuracion + " PV.");
        } else {
            System.out.println("No puedes curar a una entidad muerta.");
        }
    }
}
