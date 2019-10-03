/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.*;

/**
 *
 * @author Paris Lopez
 */
public class InsertApp {

    Consulta consulta = new Consulta();

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
    
    public String algoritmo(int i){
        //int i =0;
        String mensaje ="";
        if(i==0){
            mensaje = "putos";
        }
        return mensaje;
    }
    

    public void insert(String prenom, String nom, int seguroSocial, String fechaNacimiento, int stature, int anios, int masaCorporal, boolean actividadesFisicas, boolean genero, boolean antiHTA, boolean diabete, boolean glycemie, int legume) {
        String sql = "INSERT INTO Coucou(id,name,nom, numeroSocial,fechaNacimiento,talla,edad,masaCorporal,actividadesFisicas,genero,antiHTA,diabetes,glycemia,legume) VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            Date date =formatter.parse(fechaNacimiento);
        try (Connection conn = this.Connnect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //pstmt.setInt(1, id);
            pstmt.setString(1, prenom);
            pstmt.setString(2, nom);
            pstmt.setInt(3, anios);
            pstmt.setString(4, fechaNacimiento);
            pstmt.setInt(5, stature);
            pstmt.setInt(6, anios);
            pstmt.setInt(7, masaCorporal);
            pstmt.setBoolean(8, actividadesFisicas);
            pstmt.setBoolean(9, genero);
            pstmt.setBoolean(10, antiHTA);
            pstmt.setBoolean(11, diabete);
            pstmt.setBoolean(12, glycemie);
            pstmt.setInt(13, legume);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "insertion réussie !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "l'insertion n'a pas reussi");
        }
    }

    public void MostrarUsuarios() {
        DefaultTableModel modo = new DefaultTableModel();
        modo.addColumn("Nom");
        modo.addColumn("Prenom");
        modo.addColumn("date de naissaince");
        modo.addColumn("Numero sécurité social");
        modo.addColumn("");
        consulta.Tabla.setModel(modo);
        String sql = "SELECT * FROM Coucou";

        String datos[] = new String[5];
        try (Connection conn = this.Connnect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("name");
                 datos[1] = rs.getString("nom");
                  datos[2] = rs.getString("fechaNacimiento");
                   datos[3] = rs.getString("numeroSocial");
                   int dato1 = rs.getInt("edad");
                   dato1 +=1 ;
                  // datos[4] = Integer.toString(dato1);
                  datos[4] = algoritmo(0);
                System.out.println(dato1);
                    modo.addRow(datos);
            }
           // System.out.println(rs.getString(1));
            consulta.Tabla.setModel(modo);

           // pstmt.executeUpdate();
           // JOptionPane.showMessageDialog(null, "insertion réussie !");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }
}
