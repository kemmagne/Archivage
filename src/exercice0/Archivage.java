/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice0;

import Model.Model;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author user
 */
public class Archivage  {
    
    private String nomFichier;    
    public static long fichierTaile;
    public static boolean status = false;
    
    public static Date date;

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    
    
    
     
    public void deplacer(int choix, int rep, String source, String target, IArchivageListener  archivageListener){
    
    Scanner str = new Scanner(System.in);
     System.out.println("Vous avez saisi : " + choix); 
       
      if(choix != 1 && choix != 2)
          System.out.println("Entre 1 pour copier ou 2 pour couper"); 
      
       else{
        if(choix == 1){
             System.out.println("vous aviez entrer Copy");
              
             switch (rep){
               case 5:
                 System.out.println("Entre le path du dossier");
                   
                 System.out.println("Entre le path du dossier de destination");
               
                 File sourceFile = new File(source);
                 System.out.println(sourceFile);
                 
                 //Obtenir la taille du fichier
                fichierTaile = (long) sourceFile.length();
                System.out.println("La taille du fichier est:"  + fichierTaile);
                status = (sourceFile.exists()) ? true : false;
                System.out.println(status);
                
                String name = sourceFile.getName();
                File targetRepo = new File(target+name);
                System.out.println("Copying file : " + sourceFile.getName() +" from Java Program");
                
                 try {
                     //copy file from one location to other
                  
                     FileUtils.copyFile(sourceFile, targetRepo);
                 } catch (IOException ex) {
                     Logger.getLogger(Deplacement.class.getName()).log(Level.SEVERE, null, ex);
                 }
                

                  break;
                  case 6: 
                    System.out.println("Creer le path du dossier");
                    System.out.println("Entre le path du dossier de destination");
                    File sourceFile1 = new File(source);
                    System.out.println(sourceFile1);
                    String name1 = sourceFile1.getName();
                    File targetRepo1 = new File(target);
                    String path2 = str.nextLine(); 
                    File dossier = new File(path2); 
                     boolean res = targetRepo1.mkdir();
                          
                     if(res) {
                            
                      try {
                     //copy file from one location to other
                       
                     
                       FileUtils.copyFile(sourceFile1, targetRepo1);
                       
                              } catch (IOException ex) {
                                  
                        Logger.getLogger(Deplacement.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                            System.out.println("Le dossier a ete creer.");
                        }else {
                           System.out.println("Le dossier existe déja.");
               }  
            }
               
             
             
         }if(choix == 2){
             System.out.println("Coupure avier entrer coupure");
             
             
              switch (rep){
               case 5:
                System.out.println("Entre le path du dossier");
                System.out.println("Entre le path du dossier de destination");
                File sourceFile = new File(source);             
                System.out.println(sourceFile);
                fichierTaile = (long) sourceFile.length();
                status = (sourceFile.exists()) ? true : false;
                System.out.println(status);
                System.out.println("La taille du fichier est:"  + fichierTaile);
                String name = sourceFile.getName();
                File targetRepo = new File(target+name);
 
                 System.out.println("Copying file : " + sourceFile.getName() +" from Java Program");
     
                 try {
                     //copy file from one location to other
                     FileUtils.moveFile(sourceFile, targetRepo);
                  
                 } catch (IOException ex) {
                     Logger.getLogger(Deplacement.class.getName()).log(Level.SEVERE, null, ex);
                 }
                

                  break;
                  case 6: 
                    System.out.println("Creer le path du dossier");
                    System.out.println("Entre le path du dossier de destination");
                    File sourceFile1 = new File(source);
                    System.out.println(sourceFile1);
                    String name1 = sourceFile1.getName();
                    File targetRepo1 = new File(target);

                     File dossier = new File(target); 
                     boolean res = targetRepo1.mkdir();
                          
                     if(res) {
                            
                      try {
                     //copy file from one location to other
                      
                       FileUtils.copyFile(sourceFile1, targetRepo1);
                       
                              } catch (IOException ex) {
                                  
                        Logger.getLogger(Deplacement.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                            System.out.println("Le dossier a ete creer.");
                        }else {
                           System.out.println("Le dossier existe déja.");
               }
              }
             
             
         }
      } 
          
          
     
     }

    
}
