package Model;

public class Usuario {
    private String nombre, contrasenia;

    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    public String getNombre() {
        return nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }

}
