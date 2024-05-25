package Model;

public class Land extends Carta {
    private final String Colores;

    public Land(String tipo, String nombre, String colores) {
        super(tipo, nombre);
        this.Colores = colores;
    }

    public String getColores() {
        return Colores;
    }

    @Override
    public boolean buscarCarta(String nombre) {
        return false;
    }

    @Override
    public boolean agregarCarta(String nombre, String tipo, String texto) {
        return false;
    }
}
