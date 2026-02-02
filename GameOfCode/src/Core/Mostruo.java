package Core;

public class Mostruo extends Entidad{

    private Boolean salvage;

    public Mostruo() {
        this.name = "Test";
        this.nivel = 1;
        this.puntosVida = 4;
        this.salvage = false;
    }

    public Boolean getSalvage() {
        return salvage;
    }

    protected void setSalvage(Boolean salvage) {
        this.salvage = salvage;
    }

    @Override
    public void atacar(Entidad p) {
        System.out.println("Zarpazo a " + p.name);
    }
}
