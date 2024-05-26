package Services;

import Model.Carta;
import Model.ListaMazos;
import Model.Mazo;
import Model.NonLand;
import ucn.In;

public class SistemaDeckList implements IsistemaDeckList {
    private ListaMazos Mazos;
    private String NOMBRE_ARCHIVO_TEXTO_LANDS="Land_List.txt";
    private String NOMBRE_ARCHIVO_TEXTO_NONLANDS="Card_List_txt";


    private boolean LecturaDeArchivos(){
        In archivoNoTierras = new In(this.NOMBRE_ARCHIVO_TEXTO_NONLANDS);
        In archivoTierras = new In(this.NOMBRE_ARCHIVO_TEXTO_LANDS);
        int contador=0;
        String[][] MazoActual= new String[100][6];
        while (!archivoNoTierras.isEmpty()) {

            String[] linea = archivoNoTierras.readLine().split(";");
            String nombre = linea[0];
            if(!nombre.equals("CardName")){
            MazoActual[contador][0]=linea[0];
            MazoActual[contador][1]=linea[1];
            MazoActual[contador][2]=linea[2];
            MazoActual[contador][3]=linea[3];
            MazoActual[contador][4]=linea[4];
            MazoActual[contador][5]=linea[5];
            contador++;
            }
            //*Carta carta = new NonLand(texto,nombre,type,ManaCost,CMC,toughness,power);
        }
        archivoNoTierras.close();

        while (!archivoNoTierras.isEmpty()) {

            String[] linea = archivoTierras.readLine().split(";");
            String nombre = linea[0];
            if(!nombre.equals("Card Name")){
                MazoActual[contador][0]=linea[0];
                MazoActual[contador][1]=linea[1];
                MazoActual[contador][2]=linea[2];
                contador++;
            }
            //*Carta carta = new NonLand(texto,nombre,type,ManaCost,CMC,toughness,power);
        }
        archivoTierras.close();


        return true;
    }

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