package Services;

import Model.*;
import ucn.*;
import java.io.File;
import java.io.IOException;

public class SistemaDeckList implements IsistemaDeckList {
    private ListaUsuario usuarios = new ListaUsuario(100);
    private ListaMazos Mazos= new ListaMazos(100);
    private String NOMBRE_ARCHIVO_TEXTO_LANDS = "Land_List.txt";
    private String NOMBRE_ARCHIVO_TEXTO_NONLANDS = "Card_List.txt";
    private String NOMBRE_ARCHIVO_TEXTO_MAZO;
    private ListaCartas listaTierras;
    private ListaCartas listaNoTierras;

    private void construirMazo() {

    }
    private void construirMazo(Mazo mazo) {

        boolean menuActivo=true;
        while (menuActivo){
            StdOut.println("menu de construccion de mazo");
           StdOut.println("1. Añadir carta\n2. Eliminar Carta\n3. Buscar carta\n4. modificar sideboard\n5. volver");
           String respuesta=StdIn.readString();
           switch (respuesta){
               case "1":
                    agregarCarta(mazo);
                   break;
               case "2":

                   break;
               case "3":
                   buscarCarta();
                   break;
               case "4":
                   modificarSideboard(mazo);
                   break;
               case "5":
                   return;

               default:
                   StdOut.println("el valor ingresado es invalido");

           }
        }
    }

    private void agregarCarta(Mazo mazo) {
        StdOut.println("ingrese el nombre de la carta que quiere agregar");
        String nombre=StdIn.readString();
        Carta cartaleida =listaNoTierras.buscarCartas(nombre);
        int cantidad;
        StdOut.println("ingrese la cantidad de cartas que quiere agregar");
        cantidad=StdIn.readInt();
        if(cartaleida!=null) {
            mazo.agregarCartaMainDeck(cartaleida,cantidad);
            return;
        }
        cartaleida=listaTierras.buscarCartas(nombre);
        if(cartaleida!=null) {
            mazo.agregarCartaMainDeck(cartaleida,cantidad);
            return;
        }
        if (cartaleida==null){
            StdOut.println("la carta no existe en la base de datos");
        }

    }

    private void modificarSideboard(Mazo mazo) {
        StdOut.println("menu de construccion de mazo");
        boolean menuActivo=true;
        while (menuActivo){
            StdOut.println("1. Añadir carta\n2. Eliminar Carta\n3. Buscar carta\n4. volver");
            String respuesta=StdIn.readString();
            switch (respuesta){
                case "1":

                    break;
                case "2":
                    break;
                case "3":
                    buscarCarta();
                    break;
                case "4":
                    return;
                default:
                    StdOut.println("el valor ingresado es invalido");

            }
        }
    }

    private void buscarCarta() {
        StdOut.println("ingrese nombre de la carta que desea ");
            String respuesta=StdIn.readString();
            Carta cartaleida =listaNoTierras.buscarCartas(respuesta);
            if(cartaleida!=null) {
                NonLand carta = (NonLand) cartaleida;
                StdOut.println("nombre:" + carta.getNombre() + "\ntipo:" + carta.getTipo() + "\ntexto:" + carta.getTexto() + "\npower:" + carta.getPower() + "\ntoughness:" + carta.getToughness() + "\nmanaCost" + carta.getManaCost() + "\nCMC: " + carta.getCMC());
                return;
            }
            cartaleida=listaTierras.buscarCartas(respuesta);
            if(cartaleida!=null) {
                Land carta = (Land) cartaleida;
                StdOut.println("nombre:" + carta.getNombre() + "\ntipo:" + carta.getTipo() + "\ntexto:" + carta.getColores());
                return;
            }
            if (cartaleida==null){
                StdOut.println("la carta no existe en la base de datos");
            }
        }

    private void verMisMazos() {
        StdOut.println("elije que mazo quieres ver");
        Mazo mazo=buscarMazo();
        if(mazo!=null) {
            MostrarMazo(mazo);
        }
    }

    private void MostrarMazo(Mazo mazo) {
        Carta[] lecturaDeMazo = mazo.getMainDeck();
        StdOut.println("main deck: ");
        for (int i=0;i< mazo.getCantidadActualMainDeck();i++){
            StdOut.println(lecturaDeMazo[i].getNombre()+" cantidad: "+lecturaDeMazo[i].getCantidad());
        }
        StdOut.println("side deck: ");
        Carta[] lecturaDeMazo2 = mazo.getSideDeck();
        for (int i=0;i< mazo.getCantidadActualsideDeck();i++){
            StdOut.println(lecturaDeMazo2[i].getNombre()+" cantidad: "+lecturaDeMazo2[i].getCantidad());
        }
    }

    private void BuscarCartas() {

    }

    private void CerrarSesion() throws IOException {
        int cont=1;
        String usuario= usuarios.getUsuarioActivo().getNombre();
        for(int i = 0; i < Mazos.getCantidadActual(); i++) {
            ArchivoSalida out = new ArchivoSalida("mazo" + cont + usuario + ".txt");
            Carta[] CartaMain =Mazos.getMazo(i).getMainDeck();
            Carta[] cartaSide =Mazos.getMazo(i).getSideDeck();
            for (int j = 0; j < CartaMain.length; j++) {
                if(CartaMain[j]!=null) {
                    Registro linea = new Registro(2);
                    linea.agregarCampo(String.valueOf(CartaMain[j].getCantidad()));
                    linea.agregarCampo(CartaMain[j].getNombre());
                    out.writeRegistro(linea);
                }
            }
            Registro lineaSIde= new Registro(1);
            lineaSIde.agregarCampo("SIDEBOARD");
            out.writeRegistro(lineaSIde);

            for  (int j = 0; j < cartaSide.length; j++){
                if(cartaSide[j]!=null) {
                    Registro linea = new Registro(2);
                    linea.agregarCampo(String.valueOf(cartaSide[j].getCantidad()));
                    linea.agregarCampo(cartaSide[j].getNombre());
                    out.writeRegistro(linea );
                }else{
                    out.close();
                    return;
                }
                }
            cont++;
            out.close();
        }

    }

    private void LecturaDeBaseDeDatos() {

        Carta listaTierrasEntrada[] = new Carta[500];
        Carta listaNoTierrasEntrada[] = new Carta[1000];


        In archivoNoTierras = new In(this.NOMBRE_ARCHIVO_TEXTO_NONLANDS);
        In archivoTierras = new In(this.NOMBRE_ARCHIVO_TEXTO_LANDS);
        int contTierras = 0;
        int contNoTierras = 0;
        while (!archivoNoTierras.isEmpty()) {

            String[] linea = archivoNoTierras.readLine().split(";");
            String nombre = linea[0];
            if (!nombre.equals("CardName")) {
                String text = linea[1];
                String manaCost = linea[2];
                String type = linea[3];
                int power = Integer.parseInt(linea[4]);
                int toughness = Integer.parseInt(linea[5]);
                int CMC = Integer.parseInt(linea[6]);
                Carta carta = new NonLand(text, nombre, type, manaCost, CMC, toughness, power);
                listaNoTierrasEntrada[contNoTierras] = carta;
                contNoTierras++;
            }

        }
        archivoNoTierras.close();
        while (!archivoTierras.isEmpty()) {

            String[] linea = archivoTierras.readLine().split(",");
            String nombre = linea[0];
            if (!nombre.equals("Card name")) {
                String type = linea[1];
                String color = linea[2];
                Carta carta = new Land(nombre,type,color);
                listaTierrasEntrada[contTierras] = carta;
                contTierras++;
            }

        }
        archivoTierras.close();
        this.listaNoTierras = new ListaCartas(contNoTierras);
        this.listaTierras = new ListaCartas(contTierras);
        for (int i = 0; i < contNoTierras; i++) {
            this.listaNoTierras.agregarCartas(listaNoTierrasEntrada[i]);
        }
        for (int i = 0; i < contTierras; i++) {
            this.listaTierras.agregarCartas(listaTierrasEntrada[i]);
        }


    }

    private void LecturaDeMazos(String nombreDeUsuario) {
        int cont = 1;
        this.NOMBRE_ARCHIVO_TEXTO_MAZO = "mazo" + cont + nombreDeUsuario + ".txt";
        File Archivo = new File(this.NOMBRE_ARCHIVO_TEXTO_MAZO);
        boolean sidedeck = false;
        String[][] MainDeck = new String[2][100];
        String[][] sideDeck = new String[2][15];
        int cont2=0;
        int cont3=0;
        while (Archivo.exists()) {

            In archivoDeck = new In(this.NOMBRE_ARCHIVO_TEXTO_MAZO);
            while (!archivoDeck.isEmpty()) {

                String[] linea = archivoDeck.readLine().split(",");

                if (linea[0].equals("SIDEBOARD")) {
                    sidedeck = true;
                }

                if (sidedeck&&!linea[0].equals("SIDEBOARD")) {
                    sideDeck[0][cont3] = linea[0];
                    sideDeck[1][cont3] = linea[1];
                    cont3++;
                }else if (!sidedeck&&!linea[0].equals("SIDEBOARD")){
                    MainDeck[0][cont2] = linea[0];
                    MainDeck[1][cont2] = linea[1];
                    cont2++;
                }
            }
            crearMazoDeEntrada(cont2,cont3, MainDeck, sideDeck);
            cont2=0;
            cont3=0;
            sidedeck = false;
            cont++;
            this.NOMBRE_ARCHIVO_TEXTO_MAZO = "mazo" + cont + nombreDeUsuario + ".txt";
            Archivo = new File(this.NOMBRE_ARCHIVO_TEXTO_MAZO);
        }

    }

    private void crearMazoDeEntrada(int cont2,int cont3,  String[][] MainDeck, String[][] sideDeck) {
        Mazo mazo = new Mazo(200);
        for (int i = 0; i< cont2; i++){
            Carta cartaleida =(listaNoTierras.buscarCartas(MainDeck[1][i]));
            if(cartaleida==null){
                cartaleida=listaTierras.buscarCartas(MainDeck[1][i]);
            }
            cartaleida.setCantidad(Integer.parseInt(MainDeck[0][i]));
            mazo.agregarCartaMainDeck(cartaleida);
        }
        for (int i = 0; i< cont3; i++){
            Carta cartaleida =(listaNoTierras.buscarCartas(sideDeck[1][i]));
            if(cartaleida==null){
                cartaleida=listaTierras.buscarCartas(sideDeck[1][i]);
            }
            cartaleida.setCantidad(Integer.parseInt(sideDeck[0][i]));
            mazo.agregarCartaSideDeck(cartaleida);
        }
        Mazos.agregarMazos(mazo);
    }

    @Override
    public boolean inicializar() {
        LecturaDeBaseDeDatos();
        return true;
    }

    @Override
    public boolean iniciarSesion() {
        StdOut.println("Ingrese nombre de usuario");
        String nombre = StdIn.readString();
        StdOut.println("Ingrese contraseña");
        String contrasenia = StdIn.readString();
        if(!usuarios.inicioDeSesion(nombre, contrasenia)){
            return false;
        }
        LecturaDeMazos(nombre);
        return true;
    }

    @Override
    public boolean registrarse() {
        StdOut.println("Ingrese nombre de usuario");
        String nombre = StdIn.readString();
        StdOut.println("Ingrese contraseña");
        String contrasenia = StdIn.readString();
        if (usuarios.buscarUsuario(nombre)) {
            StdOut.println("el nombre ingresado ya se encuentra en el sistema, intentar nuevamente");
            return false;
        }
        usuarios.agregarUsuario(nombre, contrasenia);
        return true;
    }

    @Override
    public void sistemaCreacion() throws IOException {
        boolean menuActivo = true;
        while (menuActivo) {
            StdOut.println("=============Menu Principal=============");
            StdOut.println("\n 1. construir mazo\n 2. ver mis mazos \n 3. buscar Carta \n 4. Cerrar sesion");
            String respuesta = StdIn.readString();
            switch (respuesta) {
                case "1":
                    menuCreacionMazo();
                    break;
                case "2":
                    verMisMazos();
                    break;
                case "3":
                    buscarCarta();
                    break;
                case "4":
                    CerrarSesion();
                    return;
                default:
                    StdOut.println("el valor ingresado no es correcto, intentar nuevamente");
                    break;
            }
        }
    }

    private void menuCreacionMazo() {
        boolean menuActivo = true;
        while (menuActivo) {
            StdOut.println("=============Menu de Construccion=============");
            StdOut.println("\n 1. construir mazo nuevo\n 2. Modificar Mazo \n 3. volver");
            String respuesta = StdIn.readString();
            switch (respuesta) {
                case "1":
                    construirMazo();
                case "2":
                    ModificarMazo();
                case "3":
                    menuActivo = false;
                    break;
                default:
                    StdOut.println("el valor ingresado es incorrecto");
                    break;
            }
        }
    }

    private void ModificarMazo() {

        StdOut.println("Elige que mazo modificar: ");
        Mazo mazo = buscarMazo();
        if(mazo!=null){
        construirMazo(mazo);
        }
    }

    private Mazo buscarMazo() {
        int contador = 0;
        if (Mazos.getCantidadActual() == 0) {
            StdOut.println("No existen mazos asociados a esta cuenta");
            return null;
        }
        for (int i = 0; i < Mazos.getCantidadActual(); i++) {
            contador = i + 1;
            StdOut.println(contador + "." + " mazo " + contador);
        }

        int respuesta = StdIn.readInt();

        if (respuesta > contador) {
            StdOut.println("el mazo ingresado no existe");
            return null;
        }
        return Mazos.getMazo(contador - 1);

    }

    @Override
    public void Salir() {

    }
}