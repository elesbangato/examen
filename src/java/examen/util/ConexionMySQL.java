/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.util;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elesban Antonio Gallardo Hernandez
 */
public class ConexionMySQL {

    private static Connection cnx = null;

    public static Connection conectar() {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "root");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnx;
    }

    public static void desconectar() {
        if (cnx != null) {
            try {
                cnx.close();
                cnx = null;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}