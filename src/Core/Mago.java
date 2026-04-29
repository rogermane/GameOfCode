package Core;

public class Mago extends Entidad{

    private int mana;

    public Mago() {
        super();
        this.name = "Ma";
        this.puntosVida = 80;
        this.mana = 100;
        this.type = "Mago";
    }

    public int getMana() {
        return mana;
    }

    protected void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    protected void atacar(Entidad rival) {
        System.out.println("Rayo a " + rival.name);
        hacerDano(rival);
        vida(rival);

        this.ganarXp(10);
        this.agregarMonedas(5);
        System.out.println(this.name + " obtiene 1 moneda (Total: " + this.monedas + ")");
    }

    @Override
    protected int hacerDano(Entidad p) {
        int min = 9 * nivel;
        int max = 18 * nivel;
        if (p.getResistencia() > 0) {
            int dano = (int) (Math.random() * (max - min + 1)) + min;
            dano = dano - 5;
            p.reducirResistencia();
            p.puntosVida = p.puntosVida - dano;
            p.getVivo();
        } else {
            int dano = (int) (Math.random() * (max - min + 1)) + min;
            p.puntosVida = p.puntosVida - dano;
            p.getVivo();
        }
        return p.puntosVida;
    }

    @Override
    protected void vida(Entidad p) {
        if (p.puntosVida <= 0) {
            p.puntosVida = 0;
            p.vivo = false;
            System.out.println("Esta Muerto");
        } else {
            p.vivo = true;
        }
    }
}
