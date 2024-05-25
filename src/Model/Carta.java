package Model;

public abstract class Carta {
private String nombre,tipo, texto;

    public Carta(String texto, String nombre) {
        this.texto = texto;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
