package Model;

public class ListaCartas {
    Carta [] ListaCartas;
    private int cantidadMaxima, cantidadActual;

    public ListaCartas(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.ListaCartas= new Carta[cantidadMaxima];
        this.cantidadActual=0;
    }
    public void agregarCartas(Carta carta){
        ListaCartas[cantidadActual]=carta;
        this.cantidadActual++;
    }
}
