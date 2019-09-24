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
      
        
    }
    
    public void LockeUser(){
        v.nameTxt.setEnabled(false);
        v.lastNameTxt.setEnabled(false);
        v.statureTxt.setEnabled(false);
        v.yearsTxt.setEnabled(false);
        v.bodyMassTxt.setEnabled(false);
        v.newBtn.setEnabled(true);
        v.cancelBtn.setEnabled(true);
        v.registerBtn.setEnabled(true);  
    }
    
}
