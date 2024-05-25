package Model;

public class ListaMazos {
private String Nombre;
private Mazo[] Mazos;
private int cantidadActual, cantidadMaxima;

    public ListaMazos(String nombre, int cantidadMaxima, Mazo[] mazos, int cantidadActual) {
        Nombre = nombre;
        this.cantidadMaxima = cantidadMaxima;
        Mazos = mazos;
        this.cantidadActual = cantidadActual;
    }
    public boolean agregarMazos(int cantidadDeCartas){
        return false;
    }
    public boolean eliminarMazos(int posicionDelMazo){
        return false;
    }



}
