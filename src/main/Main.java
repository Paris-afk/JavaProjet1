/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import controller.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.*;
import view.View;
import controller.*;
public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        Model m = new Model();
        View v = new View();
        Conn con = new Conn();
        Table table = new Table();
        con.connect();
        table.createNewTable();
        InsertApp app = new InsertApp();
       Controller c   = new Controller(m,v);
     // v.setVisible(true);
      c.start();
//      app.insert("Nuevo1", "Stark");
//      app.insert("Nuevo2", "Rogers");
    
       
    }
        
    
}
