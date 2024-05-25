package Services;

import Model.ListaMazos;
import Model.Mazo;

public class SistemaDeckList implements IsistemaDeckList {
    private ListaMazos Mazos;
    private String NOMBRE_ARCHIVO_TEXTO_LANDS="Land_List.txt";
    private String NOMBRE_ARCHIVO_TEXTO_NONLANDS="Card_List_txt";
    @Override
    public String iniciarSesison() {
        return "";
    }

    @Override
    public String registrarse() {
        return "";
    }

    @Override
    public String Salir() {
        return "";
    }
}
