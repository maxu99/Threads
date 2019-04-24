package UTN.controladores;

import java.util.ArrayList;
import java.util.List;

public final class CJugar {
   private static boolean intento = true;
    private static List<String> palabrita;
    private static boolean ejecucion = true;
    public static synchronized int Jugar(String palabra,String letra){
            if(palabrita== null){
                palabrita=palabracomolista(palabra);
            }

            if(palabrita.contains(letra)){
                palabrita.remove(letra);

                if(palabrita.isEmpty()){
                    intento=false;
                    return 2;

                }
                return 1;
            }else {
                return 0;
            }


        }

    private static List palabracomolista(String palabra){
       List <String> palabranueva = new ArrayList<>();
        for (int i=0;i<palabra.length();i++) {
            String letra = String.valueOf(palabra.charAt(i));
            if(!palabranueva.contains(letra)){
                palabranueva.add(letra);
            }

        }
        return palabranueva;
    }

    public static boolean getEjecucion() {
        return ejecucion;
    }

    public static void setEjecucion(boolean ejecucion) {
        CJugar.ejecucion = ejecucion;
    }
    public static boolean getIntento() {
        return intento;
    }

    public static void setIntento(boolean intento) {
        CJugar.intento = intento;
    }
}
