package Services;

import Model.*;
import ucn.In;
import ucn.StdIn;
import ucn.StdOut;

import java.io.File;

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
    }

    private void verMisMazos() {

    }

    private void BuscarCartas() {

    }

    private void CerrarSesion() {

    }


    private boolean LecturaDeBaseDeDatos() {

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
            if (!nombre.equals("Card Name")) {
                String type = linea[1];
                String color = linea[2];
                Carta carta = new Land(nombre, type, color);
                listaNoTierrasEntrada[contTierras] = carta;
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


        return true;
    }
    private boolean LecturaDeMazos(String nombreDeUsuario) {
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

                String[] linea = archivoDeck.readLine().split(";");

                if (linea[0].equals("SIDEBOARD")) {
                    sidedeck = true;
                    cont2 = 0;
                } else {
                    MainDeck[0][cont2] = linea[0];
                    MainDeck[1][cont2] = linea[1];
                    cont2++;

                }
                if (sidedeck) {
                    sideDeck[0][cont3] = linea[0];
                    sideDeck[0][cont3] = linea[1];
                    cont3++;
                }
               Mazo mazo = new Mazo(cont2);

            }
            cont++;
            this.NOMBRE_ARCHIVO_TEXTO_MAZO = "mazo" + cont + nombreDeUsuario + ".txt";
            Archivo = new File(this.NOMBRE_ARCHIVO_TEXTO_MAZO);
        }
        return true;

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
    public void sistemaCreacion() {
        StdOut.println("=============Menu Principal=============\n 1. construir mazo\n 2. ver mis mazos \n 3. buscar Carta \n 4. Cerrar sesion");
        String respuesta = StdIn.readString();
        boolean menuActivo = true;
        while (menuActivo)
            switch (respuesta) {
                case "1":
                    menuCreacionMazo();
                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    menuActivo = false;
                    break;
                default:
                    StdOut.println("el valor ingresado no es correcto, intentar nuevamente");
                    break;
            }
    }

    private void menuCreacionMazo() {
        boolean menuActivo = true;
        StdOut.println("=============Menu de Construccion=============\n 1. construir mazo nuevo\n 2. Modificar Mazo \n 3. volver");
        String respuesta = StdIn.readString();
        while (menuActivo) {
            switch (respuesta) {
                case "1":
                    construirMazo();
                case "2":
                    ModificarMazo();
                case "3":
                    menuActivo = false;
                    break;
                default:
            }
        }
    }

    private void ModificarMazo() {
    }

    @Override
    public void Salir() {

    }
}