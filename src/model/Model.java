/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import view.View;

/**
 *
 * @author Paris Lopez
 */
public class Model {
    View v = new View();
    InsertApp insertApp = new InsertApp();

    
    public void StartModel(){
        LockeUser();
        
    }
    
    public void InsertarUsuarios(boolean actividadesFisicas,boolean genero,boolean antiHTA,boolean diabete , boolean glycemie , int legume ){
        System.out.println("SI ESTAAAA ENTRANDO");
        String prenom = v.nameTxt.getText();
        String nom = v.lastNameTxt.getText();
        int seguroSocial = Integer.parseInt(v.seguroSocialTxt.getText());
        String fechaNacimiento = v.fechaNacimientoTxt.getText();
        int stature =  Integer.parseInt(v.statureTxt.getText());
        int anios = Integer.parseInt(v.yearsTxt.getText());
        int masaCorporal = Integer.parseInt(v.bodyMassTxt.getText());
        System.out.println("----------------------------------------------------");
        System.out.println("Prenom" + prenom);
        System.out.println("Nom" + nom);
        System.out.println("seguroSocual" + seguroSocial) ;
        System.out.println("Fecha de nacimienti" + fechaNacimiento);
        System.out.println("estatura" + stature);
        System.out.println("anios" + anios);
        System.out.println("masa Corporal " + masaCorporal);
        System.out.println("---------------------------------------------------");
        System.out.println("activididades Fisicas"+ actividadesFisicas);
        System.out.println("genero" + genero);
        System.out.println("anitHTA" + antiHTA);
        System.out.println("diabete" + diabete);
        System.out.println("glycemie" + glycemie);
        System.out.println("legume" + legume);
        System.out.println("---------------------------------------------------");
        
        insertApp.insert(prenom, nom, seguroSocial, fechaNacimiento, stature, anios, masaCorporal, actividadesFisicas, genero, antiHTA, diabete, glycemie, legume);
        
        
        
        
    //    insertApp.insert(1, "nombre", "apellido");
    }
    
    public void  NewUser(){
          v.nameTxt.setEnabled(true);
        v.lastNameTxt.setEnabled(true);
        v.statureTxt.setEnabled(true);
        v.yearsTxt.setEnabled(true);
        v.bodyMassTxt.setEnabled(true);
        v.newBtn.setEnabled(true);
        v.cancelBtn.setEnabled(true);
        v.registerBtn.setEnabled(true);  
        System.out.println("los botones han sido habilitados");
        
    }
    
    public void LockeUser(){
        v.nameTxt.setEnabled(false);
        v.lastNameTxt.setEnabled(false);
        v.statureTxt.setEnabled(false);
        v.yearsTxt.setEnabled(false);
        v.bodyMassTxt.setEnabled(false);
        v.newBtn.setEnabled(true);
        v.cancelBtn.setEnabled(false);
        v.registerBtn.setEnabled(false);  
        System.out.println("model has been inicialited");
    }
    

            
    
}
