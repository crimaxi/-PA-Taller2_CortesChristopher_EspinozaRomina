package Model;

public class NonLand extends Carta {
    private String tipo;
    private int power,toughness,CMC;
    private String [] manaCost;

    public NonLand(String texto, String nombre, String tipo, String[] manaCost, int CMC, int toughness, int power) {
        super(texto, nombre);
        this.tipo = tipo;
        this.manaCost = manaCost;
        this.CMC = CMC;
        this.toughness = toughness;
        this.power = power;
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