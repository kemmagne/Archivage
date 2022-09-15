/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice0;

/**
 *
 * @author user
 */
public interface IArchivageListener {
    
    void onStart(String fichier);
    
     void onEnd(String fichier);
}
