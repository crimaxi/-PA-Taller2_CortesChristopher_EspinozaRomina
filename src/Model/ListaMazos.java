package Model;

public class ListaMazos {
private Mazo[] Mazos;
private int cantidadActual, cantidadMaxima;

    public ListaMazos(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.Mazos=new Mazo[cantidadMaxima];
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void agregarMazos(Mazo mazo){
        Mazos[cantidadActual]=mazo;
        cantidadActual++;
    }
    public boolean eliminarMazos(int posicionDelMazo){
        return false;
    }


    public Mazo getMazo(int posicion){
        if(posicion<this.cantidadActual){
            return this.Mazos[posicion];
        }
      return null;
    }
}
