package Core;

public class Monstruo extends Entidad{

    private Boolean salvage;

    public Monstruo() {
        super();
        this.name = "Mo";
        this.puntosVida = 120;
        this.salvage = false;
        this.type = "Monstruo";
    }

    public Boolean getSalvage() {
        return salvage;
    }

    protected void setSalvage(Boolean salvage) {
        this.salvage = salvage;
    }

    @Override
    protected void atacar(Entidad rival) {
        System.out.println("Zarpazo a " + rival.name);
        hacerDano(rival);
        vida(rival);

        this.ganarXp(10);
        this.agregarMonedas(5);
        System.out.println(this.name + " obtiene 1 moneda (Total: " + this.monedas + ")");
    }

    @Override
    public int hacerDano(Entidad p) {
        int min = 1 * nivel;
        int max = 15 * nivel;
        int num1 = (int) (Math.random() * (max - min + 1)) + min;
        int num2 = (int) (Math.random() * (max - min + 1)) + min;

        if (num1 == num2) {
            salvage = true;
        } else {
            salvage = false;
        }

        if (salvage == true) {
            int minS = 15 * nivel;
            int maxS = 20 * nivel;
            if (p.getResistencia() > 0) {
                int dano = (int) (Math.random() * (maxS - minS + 1)) + minS;
                dano = dano - 5;
                p.reducirResistencia();
                p.puntosVida = p.puntosVida - dano;
                p.getVivo();
            } else {
                int dano = (int) (Math.random() * (maxS - minS + 1)) + minS;
                p.puntosVida = p.puntosVida - dano;
                p.getVivo();
            }
            return p.puntosVida;
        } else {
            int minI = 5 * nivel;
            int maxI = 15 * nivel;
            if (p.getResistencia() > 0) {
                int dano = (int) (Math.random() * (maxI - minI + 1)) + minI;
                dano = dano - 5;
                p.reducirResistencia();
                p.puntosVida = p.puntosVida - dano;
                p.getVivo();
            } else {
                int dano = (int) (Math.random() * (maxI - minI + 1)) + minI;
                p.puntosVida = p.puntosVida - dano;
                p.getVivo();
            }
            return p.puntosVida;
        }
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
