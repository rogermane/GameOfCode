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
}
