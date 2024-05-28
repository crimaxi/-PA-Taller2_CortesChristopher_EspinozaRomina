package Model;

public class ListaUsuario {
    private int cantidadMaxima, cantidadActual;
    Usuario[] listausuario;

    public ListaUsuario(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.listausuario= new Usuario[cantidadMaxima];
        this.cantidadActual=0;
    }
    public boolean agregarUsuario(String nombre, String contrasenia){
        Usuario usuario = new Usuario(nombre,contrasenia);
        this.listausuario[cantidadActual]=usuario;
        this.cantidadActual++;
        return true;
    }
    public boolean buscarUsuario(String nombre){
        for(int i=0;i<cantidadActual;i++){
            if(nombre.equals(this.listausuario[i].getNombre())){
                return true;
            }
        }
        return false;
    }
    public boolean inicioDeSesion(String nombre, String contrasenia){
        for(int i=0;i<cantidadActual;i++){
            if(nombre.equals(this.listausuario[i].getNombre())&&contrasenia.equals((this.listausuario[i].getContrasenia()))){
                return true;
            }
        }
        return false;
    }
}
