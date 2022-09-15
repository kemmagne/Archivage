/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class Model {
    
    private String nomFichier;
    private  int   tailleFichier;
    private int    tailleFArchive;
    private Date dateHeure;
    private boolean status;
    private String pathSource;
    private String pathArchivage;
    
    private boolean success;

    public Model(Date dateHeure, String nomFichier, int tailleFichier, int tailleFArchive, boolean status, String pathSource, String pathArchivage) {
        this.dateHeure = dateHeure;
        this.nomFichier = nomFichier;
        this.tailleFichier = tailleFichier;
        this.tailleFArchive = tailleFArchive;
        this.status = status;
        this.pathSource = pathSource;
        this.pathArchivage = pathArchivage;
    }
    
     public boolean createUser(){
    
      try{
          Connection con = null;
          String sql = "INSERT INTO operation (nomFichier, tailleFichier, tailleFArchive, dateHeure, status, pathSource, pathArchivage) VALUES (?, ?)";
          con = DriverManager.getConnection("jdbc:postgresql://localhost/archive", "postgres", "megatim");
          PreparedStatement ps = con.prepareStatement(sql);
          con.setAutoCommit(false);
          
          
          
          ps.setString(1, this.nomFichier);
          ps.setInt(2, this.tailleFichier);
          ps.setInt(3, this.tailleFArchive);
          ps.setDate(4, this.dateHeure);
     
          ps.setBoolean(5, this.status);
          ps.setString(6, this.pathSource);
          ps.setString(7, this.pathArchivage);
          
          success = ps.execute();
          con.commit();
          ps.close();
          con.close();
      
      } catch(SQLException e){
         e.printStackTrace();
      }
      return success;
    }
}
