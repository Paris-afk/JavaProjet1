/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.View;

/**
 *
 * @author Paris Lopez
 */
public class Model {
    View v = new View();
    
    public void StartModel(){
        LockeUser();
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
