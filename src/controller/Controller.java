/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Paris Lopez
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.*;
import model.*;
public class Controller implements ActionListener {
    
    View v = new View();
    Model m = new Model();

    public Controller( Model m , View v) {
        this.m = m;
        this.v =v;
       
    }
    
    public void start(){
      v.setTitle("Diabete");
      v.pack();
      v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      v.setLocationRelativeTo(null);
        v.setVisible(true); 
        System.out.println("ca a entré");
      //  v.setSize(650,500);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
}
