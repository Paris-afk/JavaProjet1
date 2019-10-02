/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Paris Lopez
 */
public class Table {
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Coucou (\n"
                + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    name text ,\n"
                 + "    numeroSocial int ,\n"
                + "    talla int ,\n"
                + "    edad int ,\n"
                + "    masaCorporal int ,\n"
                 + "    fechaNacimiento date ,\n"
                + "    actividadesFisicas boolean ,\n"
                + "    genero boolean ,\n"
                + "    antiHTA boolean ,\n"
                + "    diabetes boolean ,\n"
                + "    glycemia boolean ,\n"
                + "    legume int ,\n"
                + "    nom text "
                + ");";
  
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
}
