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
    int numeroSocial, taille, masseCorporelle, contateur, age, alimentation;
    boolean genre, activitésPhisiques, traitementHTA, diabète, glicémie;

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

    public String algoritmo(int i) {
        //int i =0;
        String mensaje = "";
        if (i == 0) {
            mensaje = "genial";
        }
        return mensaje;
    }

    public void contador(int contateur) {
        this.contateur += contateur;
    }

    public void glycemie() {
        if (glicémie) {
            contador(5);
        }
    }

    public void leguemes(int leguemes) {
        //aqui iran las codiciones para las leguemes

        //non
        if (alimentation == 1) {
            contador(2);
        }
        //tous les jours
        if (alimentation == 2) {
            contador(0);
        }
        //pas tous les jours
        if (alimentation == 3) {
            contador(1);
        }
    }

    public void masseCorporelle() {
        if (masseCorporelle > 24 && masseCorporelle < 30) {
            contador(1);
        } else if (masseCorporelle > 30) {
            contador(3);
        }
    }

    public void diabete() {
        if (diabète) {
            contador(3);
        }
    }

    public void traitementHTA() {
        if (traitementHTA) {
            contador(2);
        }
    }

    public void ActivitesPhysiques(boolean activitésPhisiques) {
        if (activitésPhisiques) {
            contador(0);
        } else {
            contador(2);
        }
    }

    public void taille(int taille) {
        //true == feminan
        if (this.genre == false) {
            if (this.taille < 94) {
                contador(0);
            } else if (this.taille > 94 && this.taille < 102) {
                contador(3);
            } else if (this.taille > 102) {
                contador(4);
            }
            //---------------------------------------
        }
        if (this.genre == true) {
            if (this.taille < 80) {
                contador(0);
            } else if (this.taille > 80 && this.taille < 88) {
                contador(3);
            } else if (this.taille > 88) {
                contador(4);
            }
        }
    }

    public void calcularEdad(int age) {
        if (age < 45) {
            contador(0);
        }
        if (age < 54) {
            contador(2);
        }
        if (age < 65) {
            contador(3);
        }
        if (age > 65) {
            contador(4);
        }

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
                genre = rs.getBoolean("genero");
                glicémie = rs.getBoolean("glycemia");
                alimentation = rs.getInt("legume");
                masseCorporelle = rs.getInt("masaCorporal");
                diabète = rs.getBoolean("diabetes");
                traitementHTA = rs.getBoolean("antiHTA");
                activitésPhisiques = rs.getBoolean("actividadesFisicas");
                taille = rs.getInt("talla");
                age = rs.getInt("edad");

                calcularEdad(age);
                taille(taille);
                ActivitesPhysiques(activitésPhisiques);
                leguemes(alimentation);
                traitementHTA();
                diabete();
                masseCorporelle();
                glycemie();

                dato1 += 1;
                // datos[4] = Integer.toString(dato1);
                //datos[4] = algoritmo(0);
                datos[4] = Integer.toString(contateur);
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
