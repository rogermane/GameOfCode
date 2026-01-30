package Core;

public class Mago extends Entidad{

    private int mana;

    public Mago() {
        this.name = "Test";
        this.nivel = 1;
        this.puntosVida = 4;
        this.mana = 100;
    }

    public int getMana() {
        return mana;
    }
}
