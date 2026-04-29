package Core;

import java.util.ArrayList;

public abstract class Entidad implements SubirNivel {

    protected String name;
    protected int nivel;
    protected int puntosVida;
    protected String type;
    protected Boolean vivo;
    protected int xp;
    protected int monedas;
    protected ArrayList<Carta> inventario;

    public Entidad() {
        this.nivel = 1;
        this.vivo = true;
        this.xp = 0;
        this.monedas = 0;
        this.inventario = new ArrayList<>();
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getName() {
        return name;
    }

    public String getType() { return type; }

    public Boolean getVivo() { return vivo; }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setNivel(int nivel) {
        this.nivel = nivel;
    }

    protected void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    protected void setType(String type) { this.type = type; }

    protected void setVivo(Boolean vivo) { this.vivo = vivo; }

    protected abstract void atacar(Entidad Entidad);

    protected abstract int hacerDano(Entidad Entidad);

    protected int getResistencia() {
        return 0;
    }

    protected void reducirResistencia() {}

    protected void vida(Entidad Entidad) {}

    public int getMonedas() {
        return monedas;
    }

    public void agregarMonedas(int cantidad) {
        this.monedas += cantidad;
    }

    public void gastarMonedas(int cantidad) {
        this.monedas -= cantidad;
    }

    public void recibirCarta(Carta carta) {
        this.inventario.add(carta);
        System.out.println(this.name + " recibió la carta: " + carta.getNombre());
    }

    public ArrayList<Carta> getInventario() {
        return inventario;
    }

    public void subirNivel() {
        this.nivel++;
        this.xp -= 100;

        this.puntosVida += 20;

        System.out.println("¡Subida de Nivel! " + this.name + " ha alcanzado el nivel " + this.nivel + "!");
        System.out.println("Estadísticas mejoradas: +20 Puntos de Vida.");
    }

    public void ganarXp(int cantidad) {
        this.xp += cantidad;
        System.out.println(this.name + " ganó " + cantidad + " XP (Total: " + this.xp + "/100).");

        while (this.xp >= 100) {
            subirNivel();
        }
    }

}
