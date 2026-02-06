package Core;

public class Guerrero extends Entidad{

    private int resistencia;

    public Guerrero() {
        super();
        this.name = "G";
        this.puntosVida = 100;
        this.resistencia = 50;
        this.type = "Guerrero";
    }

    public int getResistencia() {
        return resistencia;
    }

    @Override
    protected void reducirResistencia() {
        super.reducirResistencia();
        this.resistencia = this.resistencia - 10;
    }

    protected void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    protected void atacar(Entidad rival) {
        System.out.println("Puñetazo a " + rival.name);
        hacerDano(rival);
        vida(rival);

        this.ganarXp(10);
        this.agregarMonedas(5);
        System.out.println(this.name + " obtiene 1 moneda (Total: " + this.monedas + ")");
    }

    @Override
    protected int hacerDano(Entidad p) {
        int min = 7 * nivel;
        int max = 14 * nivel;
        int dano = (int) (Math.random() * (max - min + 1)) + min;
        p.puntosVida = p.puntosVida - dano;
        p.getVivo();
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
