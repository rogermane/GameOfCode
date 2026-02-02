package Core;

public abstract class Entidad {

    protected String name;
    protected int nivel;
    protected int puntosVida;

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setNivel(int nivel) {
        this.nivel = nivel;
    }

    protected void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public abstract void atacar(Entidad Entidad);
}
