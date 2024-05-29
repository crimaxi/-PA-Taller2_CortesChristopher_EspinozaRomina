package Model;

public abstract class Carta {
private String nombre, tipo;
private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public Carta(String tipo, String nombre) {
        this.tipo = tipo;
        this.cantidad=1;
        this.nombre = nombre;
    }
    public abstract boolean buscarCarta  (String nombre);
    public abstract boolean agregarCarta (String nombre, String tipo, String texto);

    public String getTipo() {
        return tipo;
    }

    public void setTexto(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
