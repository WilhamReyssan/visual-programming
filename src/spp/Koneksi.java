/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Lenovo
 */
public class Koneksi {
    Connection con;
    Statement stm;
    public Koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/spp?useLegacyDateTimeCode=false&serverTimezone=UTC","root","");
            stm=con.createStatement();
            System.out.print("berhasil");        
        }catch(Exception e){
            e.printStackTrace();
               System.out.println("Error"); 
        }
    }
    
}
