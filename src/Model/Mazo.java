package Model;

public class Mazo {
private Carta[] mainDeck, sideDeck;
private int cantidadMaxima, cantidadActual;
    public Mazo(int cantidadMaxima) {
        this.cantidadActual=0;
        this.cantidadMaxima=cantidadMaxima;
        this.mainDeck = new Carta[cantidadMaxima];
        this.sideDeck = new Carta[15];
    }
    public boolean agregarCarta (Carta carta){
        mainDeck[cantidadActual]=carta;
        return false;
    }
    public boolean modificarDeck(String tipo){
        return false;
    }
    public boolean agregarCarta(Carta carta,int cantidad){
        return false;
    }
    public boolean EliminarCarta(Carta carta,int cantidad){
        return false;
    }
    public boolean verificarCantidad(){
        return false;
    }

    public Carta[] getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Carta[] mainDeck) {
        this.mainDeck = mainDeck;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public Carta[] getSideDeck() {
        return sideDeck;
    }

    public void setSideDeck(Carta[] sideDeck) {
        this.sideDeck = sideDeck;
    }
}
