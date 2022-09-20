/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
/**
 *
 * @author user
 */
public class Model {
    
    private String nomFichier;
    private  long   tailleFichier;
    private long    tailleFArchive;
    private LocalDateTime dateHeure;
    private boolean status;
    private String pathSource;
    private String pathArchivage;
    
    private boolean success;

    public Model(String nomFichier, long fichierTaile, long fichierTaile0, LocalDateTime date, boolean status, String sourceFile, String targetRepo) {
        this.dateHeure = date;
        this.nomFichier = nomFichier;
        this.tailleFichier = fichierTaile;
        this.tailleFArchive = fichierTaile0;
        this.status = status;
        this.pathSource = sourceFile;
        this.pathArchivage = targetRepo;
    }


     public boolean createUser(){
    
      try{
          Connection con = null;
          String sql = "INSERT INTO operation (nomFichier, tailleFichier, tailleFArchive, dateHeure, status, pathSource, pathArchivage) VALUES (?, ?, ?, ?, ?, ?, ?)";
          con = DriverManager.getConnection("jdbc:postgresql://localhost/journal_archivage", "postgres", "megatim");
          PreparedStatement ps = con.prepareStatement(sql);
          con.setAutoCommit(false);

          ps.setString(1, this.nomFichier);
          ps.setDouble(2, this.tailleFichier);
          ps.setDouble(3, this.tailleFArchive);
          ps.setDate(4, null);
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
