package Core;

public class Guerrero extends Entidad{

    private int resistencia;

    public Guerrero() {
        this.name = "Test";
        this.nivel = 1;
        this.puntosVida = 4;
        this.resistencia = 5;
    }

    public int getResistencia() {
        return resistencia;
    }
}
