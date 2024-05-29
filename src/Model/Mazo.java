package Model;

public class Mazo {
private Carta[] mainDeck, sideDeck;
private int cantidadMaxima, cantidadActualMainDeck,cantidadActualsideDeck;
    public Mazo(int cantidadMaxima) {
        this.cantidadActualsideDeck=0;
        this.cantidadActualMainDeck =0;
        this.cantidadMaxima=cantidadMaxima;
        this.mainDeck = new Carta[cantidadMaxima];
        this.sideDeck = new Carta[15];
    }
    public void agregarCartaMainDeck(Carta carta){
        mainDeck[cantidadActualMainDeck]=carta;
        cantidadActualMainDeck++;
    }
    public void agregarCartaSideDeck (Carta carta){
        sideDeck[cantidadActualsideDeck]=carta;
        cantidadActualsideDeck++;
    }

    public boolean modificarDeck(String tipo){
        return false;
    }
    public boolean agregarCartaMainDeck(String nombre, int cantidad){

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

    public int getCantidadActualsideDeck() {
        return cantidadActualsideDeck;
    }

    public int getCantidadActualMainDeck() {
        return cantidadActualMainDeck;
    }

    public void setCantidadActualMainDeck(int cantidadActualMainDeck) {
        this.cantidadActualMainDeck = cantidadActualMainDeck;
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

    public void LeerMazo(String[][] mainDeck, String[][] sideDeck) {

    }
}
