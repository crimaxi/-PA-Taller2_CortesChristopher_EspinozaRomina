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
    public Carta buscarCartas(String nombreCarta){
        for (int i=0; i<this.cantidadActual ;i++){
            if(nombreCarta.equals(ListaCartas[i].getNombre())){;
            return ListaCartas[i];}
        }
        return null;
    }
}
