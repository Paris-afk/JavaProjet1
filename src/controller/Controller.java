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
import javax.swing.JOptionPane;
import view.*;
import model.*;
public class Controller implements ActionListener {
    
   private Model m;
   private View v;
   static boolean actividadesFisicas ;
   static boolean genero;
   static boolean antiHTA;
   static boolean diabete;
   static boolean glycemie;
   static int legume;
    public Controller( Model m , View v) {
        this.m = m;
        this.v =v;
       this.v.newBtn.addActionListener(this);
       this.v.cancelBtn.addActionListener(this);
       this.v.registerBtn.addActionListener(this);
       this.v.masculinBtn.addActionListener(this);
       this.v.feminanBtn.addActionListener(this);
       this.v.activitesphysiquesOuiBtn.addActionListener(this);
       this.v.activitesphysiquesNonBtn.addActionListener(this);
       this.v.antiHTAOuiBtn.addActionListener(this);
       this.v.antiHTANonBtn.addActionListener(this);
       this.v.diabeteOuiBtn.addActionListener(this);
       this.v.diabeteNonBtn.addActionListener(this);
    }
    
    public void start(){
        
      v.setTitle("Diabete");
      v.pack();
      v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      v.setLocationRelativeTo(null);
        v.setVisible(true); 
        m.StartModel();
        //System.out.println("ca a entré");
        
      //  v.setSize(650,500);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(v.newBtn == e.getSource()){
            try{
                System.out.println("ha sido presionado");
                m.NewUser();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "il y a eu un erreur au moment d'ajouter autre personne");
            }
        }
                if(v.cancelBtn == e.getSource()){
            try{
                System.out.println("ha sido presionado");
                m.LockeUser();
            }catch(Exception ex){
                
            }
        }
                
         if(v.registerBtn == e.getSource()){
             try{
                 System.out.println("Boton registrar ha sido presionado");
                 m.InsertarUsuarios(actividadesFisicas, genero, antiHTA, diabete, glycemie, legume);
             }catch(Exception ex){
                 JOptionPane.showMessageDialog(null, ex.toString());
             }
         }
  //-----------------------------GENRE              
                if(v.masculinBtn.isSelected()){
                   // System.out.println("Masculino");
                    genero = true;
                    System.out.println("Genero=" + genero);
                    
                } if (v.feminanBtn.isSelected()){
                    //System.out.println("Feminan");
                    genero = false;
                    System.out.println("Genero=" + genero);
                }
    //-----------------------------------------
    
    //-------------------------------Activites Physiques
                if(v.activitesphysiquesOuiBtn.isSelected()){
                   // System.out.println("activitesPhysiquesOui");
                    actividadesFisicas = true;
                    System.out.println("actividadesFisicas =" +actividadesFisicas);
                } if(v.activitesphysiquesNonBtn.isSelected()){
                    //System.out.println("activites Physiques Non");
                    actividadesFisicas = false;
                     System.out.println("actividadesFisicas =" +actividadesFisicas);
                }
                
     //-----------------------------------------    
     
     //------------------------------------anti HTA
                  if(v.antiHTAOuiBtn.isSelected()){
                    antiHTA = true;
                    System.out.println("antiHTA=" + antiHTA);
                } if(v.antiHTANonBtn.isSelected()){
                  
                    antiHTA = false;
                    System.out.println("antiHTA=" + antiHTA);
                }
                
       //----------------------------------------------diabete
       
                if(v.diabeteOuiBtn.isSelected()){
                    diabete=true;
                    System.out.println("diabete="+diabete);
                }else if(v.diabeteNonBtn.isSelected()){
                    diabete=false;
                    System.out.println("diabete="+diabete);
                }
        //--------------------------------------------------------

        //---------------------------------------------Glycemie
                if(v.glycemieOuiBtn.isSelected()){
                    glycemie=true;
                    System.out.println("grlycemie="+glycemie);
                }else if(v.glycemieNonBtn.isSelected()){
                    glycemie= false;
                    System.out.println("glycemie="+glycemie);
                }
       
         //------------------------------------------------------
         
         //------------------------------------------Legueme
     
                if(v.legumeOuiBtn.isSelected()){
                    legume=3;
                    System.out.println("legume="+legume);
                }else if(v.legumePasBtn.isSelected()){
                    legume =2;
                    System.out.println("legume="+legume);
                }else if(v.legumeNonBtn.isSelected()){
                    legume=1;
                    System.out.println("legume="+legume);
                }
    }
    
}
