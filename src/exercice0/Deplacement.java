/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice0;

import Model.Model;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class Deplacement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here

        
        Archivage archivage = new Archivage();
       
         archivage.deplacer(1, 5, "D:/java/jasper.exe", "D:/java2/", new IArchivageListener() {
             @Override
             public void onStart(String fichier){
    
             }

             @Override
             public void onEnd(String fichier) {
                 
             }
         });
   }
}