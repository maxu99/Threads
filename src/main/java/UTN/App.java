package UTN;

import UTN.clases.Connect;
import UTN.clases.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Jugador j = new Jugador(20, "Jugador");
        Jugador j2 = new Jugador(20, "Maquina");
        j.start();
        j2.start();






    }


}
