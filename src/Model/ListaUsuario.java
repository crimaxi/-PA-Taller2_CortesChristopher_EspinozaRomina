package Model;

public class ListaUsuario {
    private int cantidadMaxima, cantidadActual;
    Usuario[] listausuario;

    public ListaUsuario(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.listausuario= new Usuario[cantidadMaxima];
        this.cantidadActual=0;
    }
    public boolean agregarUsuario(String nombre, String contraseña){


        return true;
    }
    public int buscarUsuario(String nombre){


        return -1;
    }
}
