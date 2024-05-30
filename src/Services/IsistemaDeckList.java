package Services;

import java.io.IOException;

public interface IsistemaDeckList {
    boolean inicializar();
    boolean iniciarSesion();
    boolean registrarse();
    void sistemaCreacion() throws IOException;
    void Salir();

}
