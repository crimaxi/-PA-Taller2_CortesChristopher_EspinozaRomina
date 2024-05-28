package Model;

public abstract class Carta {
private String nombre, texto;
private int cantidad;

    public Carta(String texto, String nombre) {
        this.texto = texto;
        this.cantidad=1;
        this.nombre = nombre;
    }
    public abstract boolean buscarCarta  (String nombre);
    public abstract boolean agregarCarta (String nombre, String tipo, String texto);

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
