package Core;

public class CartaSubirNivel extends Carta {

    public CartaSubirNivel() {
        super("Ascender", "Sube inmediatamente 1 nivel.", Rareza.EPICA, 65);
    }

    @Override
    public void aplicar(Entidad objetivo) {
        if (objetivo.getVivo()) {
            int nuevoNivel = objetivo.getNivel() + 1;
            objetivo.setNivel(nuevoNivel);
            System.out.println("¡" + objetivo.getName() + " ha ascendido al nivel " + nuevoNivel + "!");
        }
    }
}
