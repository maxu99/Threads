package UTN.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static void insert(String query) {
        try {
            Statement miStatement = conectarbd();
            miStatement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error al insertar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Statement conectarbd() {
        Connection miConexion;
        Statement miStatement = null;
        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/threads", "root", "");
            miStatement = miConexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al conectar");
            ex.printStackTrace();
        }
        return miStatement;
    }

}