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

    protected void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void atacar(Entidad p) {
        System.out.println("Rayo a " + p.name);
    }
}
