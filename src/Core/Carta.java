package Core;

public abstract class Carta {
    protected String nombre;
    protected String descripcion;
    protected Rareza rareza;
    protected int precio;

    public Carta(String nombre, String descripcion, Rareza rareza, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Rareza getRareza() {
        return rareza;
    }

    public int getPrecio() {
        return precio;
    }

    public abstract void aplicar(Entidad objetivo);
}
