/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice0;

import Model.Model;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;


/**
 *
 * @author user
 */

class Test{
 
    LocalDate myObj = LocalDate.now();

}


public class Deplacement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        LocalDate myObj = LocalDate.now();
        Archivage archivage = new Archivage();
       
         archivage.deplacer(1, 5, "D:/java/jasper.exe", "D:/java2/", new IArchivageListener() {
             @Override
             public void onStart(String fichier){
                 System.out.println("Entrer les parametres du fichier a archiver:" +fichier);
             }

             @Override
             public void onEnd(String fichier) {
                 System.out.println(fichier + " A étè enregistrer" );
             }
         });
         
        
   }
}