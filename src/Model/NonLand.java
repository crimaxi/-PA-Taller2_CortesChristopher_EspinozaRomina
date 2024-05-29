package Model;

public class NonLand extends Carta {
    private String texto;
    private int power,toughness,CMC;
    private String  manaCost;

    public NonLand(String tipo, String nombre, String texto, String manaCost, int CMC, int toughness, int power) {
        super(tipo, nombre);
        this.texto = texto;
        this.manaCost = manaCost;
        this.CMC = CMC;
        this.toughness = toughness;
        this.power = power;
    }

    @Override
    public boolean buscarCarta(String nombre) {
        return false;
    }

    public String getTexto() {
        return texto;
    }

    public String getManaCost() {
        return manaCost;
    }

    public int getCMC() {
        return CMC;
    }

    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    @Override
    public boolean agregarCarta(String nombre, String tipo, String texto) {
        return false;
    }
}