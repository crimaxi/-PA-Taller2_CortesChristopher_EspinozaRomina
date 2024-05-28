import Services.IsistemaDeckList;
import ucn.StdIn;
import ucn.StdOut;
import utils.Instalador;

public class Main {
    public static void main(String[] args) {

        IsistemaDeckList instalador = new Instalador().instalarSistema();
        instalador.inicializar();
        StdOut.println("======= Bienvenido al Gestor de mazos =======\n");
        boolean menuActivo=true;
        while (menuActivo){
            StdOut.println("\n1.iniciar sesion\n2.Registrarse\n3.salir");
            String respuesta=StdIn.readString();
        switch (respuesta){
            case "1":
                if(!instalador.iniciarSesion()){
                    StdOut.println("el usuario ingresado no existe o la contraseña ingresada es incorrecta");
                break;
                }
                instalador.sistemaCreacion();
                break;
            case "2":
                if(instalador.registrarse()){
                    StdOut.println("Usuario creado con exito");
                }
                break;
            case "3":
                StdOut.println("vuelva pronto!!");
                instalador.Salir();
                menuActivo=false;
                break;
            default:
                StdOut.println("El valor ingresado no existe, intentar nuevamente");
        }
        }
}
}