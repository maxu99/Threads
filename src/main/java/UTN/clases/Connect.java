package UTN.clases;

import java.sql.*;

public final class Connect {

    public static void insert(String query) {
        try {
            Statement miStatement = conectarbd();
            miStatement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int contarpalabras(){
        int num=0;
        try {
            Statement miStatement = conectarbd();
            ResultSet rs = miStatement.executeQuery("select count(*) from palabras");
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return num;
    }
    public static String extraerPalabra() {
       String palabra=null;
       int numrandom = (int) Math.floor(Math.random()* contarpalabras())+1;
        try {
            Statement miStatement =  conectarbd();
          ResultSet rs = miStatement.executeQuery("SELECT palabra from palabras where id_palabra =  "+numrandom);
            while (rs.next()) {
                palabra= rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al traer");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabra;
    }

    private static Statement conectarbd() {
        Connection miConexion;
        Statement miStatement = null;
        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hilos", "root", "");
            miStatement = miConexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al conectar");
            ex.printStackTrace();
        }
        return miStatement;
    }

}