package UTN.clases;

import UTN.controladores.CJugar;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Thread {
    private int vidas;
    private String nombre;
    static char[] usadas = null;

    public Jugador(int vidas, String nombre) {
        super(nombre);
        this.vidas = vidas;
        this.nombre = nombre;
    }

    public  void intento(){
        String palabra = "Hola";
        palabra=  palabra.toUpperCase();
        String letra = generarLetra();
        List<String> usadas=new ArrayList<String>();

            /*if(!CJugar.getEjecucion()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{*/
                CJugar.setEjecucion(false);

            //}
            while (usadas.contains(letra)){
                letra=generarLetra();

            }
            usadas.add(letra);

            int result = CJugar.Jugar(palabra,letra);

            if (result == 1){
                System.out.println(super.getName()+ " adivino la letra " +letra);
                this.vidas--;

            }else if (result == 0){
                System.out.println(super.getName()+ " erro "+ letra );
                this.vidas--;


            }
            else if(result == 2){
                System.out.println("Hilo "+super.getName()+ " adivino la ultima letra y gano. Palabra: " + palabra);
                this.vidas=0;
            }

    }

    @Override
    public synchronized void run() {
        while(vidas>0 && CJugar.getIntento()){
           if(!CJugar.getEjecucion()) {
               try {
                   wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            intento();
            CJugar.setEjecucion(true);
            notifyAll();
        }


    }
    public String generarLetra(){
         String letras []={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z"};
        int numRandom = (int) ((Math.random() * letras.length-1)+1) ;
         return letras[numRandom];
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
