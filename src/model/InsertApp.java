/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.*;

/**
 *
 * @author Paris Lopez
 */
public class InsertApp {
       private Connection Connnect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
//        public void InsertarUsuarios(boolean actividadesFisicas,boolean genero,boolean antiHTA,boolean diabete , boolean glycemie , int legume ){
//        System.out.println("SI ESTAAAA ENTRANDO");
//        String prenom = v.nameTxt.getText();
//        String nom = v.lastNameTxt.getText();
//        int seguroSocial = Integer.parseInt(v.seguroSocialTxt.getText());
//        String fechaNacimiento = v.fechaNacimientoTxt.getText();
//        int stature =  Integer.parseInt(v.statureTxt.getText());
//        int anios = Integer.parseInt(v.yearsTxt.getText());
//        int masaCorporal = Integer.parseInt(v.bodyMassTxt.getText());
       
           public void insert(String name, String nom) {
        String sql = "INSERT INTO Coucou(id,name,nom) VALUES(NULL,?,?)";
 
        try (Connection conn = this.Connnect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            //pstmt.setInt(1, id);
            pstmt.setString(1, name);
            pstmt.setString(2,nom);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
