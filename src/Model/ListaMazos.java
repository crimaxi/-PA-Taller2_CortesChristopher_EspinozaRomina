package Model;

public class ListaMazos {
private Mazo[] Mazos;
private int cantidadActual, cantidadMaxima;

    public ListaMazos(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.Mazos=new Mazo[cantidadMaxima];
    }
    public boolean agregarMazos(int cantidadDeCartas){

        return false;
    }
    public boolean eliminarMazos(int posicionDelMazo){
        return false;
    }



}
