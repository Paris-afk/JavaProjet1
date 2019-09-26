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
        String sql = "CREATE TABLE IF NOT EXISTS personne (\n"
                + "    id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "    name text NOT NULL,\n"
                + "    nom text NOT NULL,\n"
                + "    dateNaissaince integer NOT NULL,\n"
                + "    securiteSocial integer NOT NULL,\n"
                + "    age integer NOT NULL,\n"
                + "    taille integer NOT NULL,\n"  
                + "    activitePhysique boolean NOT NULL,\n"
                + "    HTA boolean  NOT NULL,\n"
                + "    familialDiabete  NOT NULL,\n"
                + "    masseCorporelle int  NOT NULL,\n"
                + "    legumes boolean  NOT NULL,\n"
                + "    glycemie boolean  NOT NULL \n"
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
