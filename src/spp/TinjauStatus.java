/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableColumnModel;
/**
 *
 * @author Lenovo
 */
public class TinjauStatus extends javax.swing.JPanel {

    /**
     * Creates new form TinjauStatus
     */
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    int jan=1,feb=2,mar=3,apr=4,mei=5,jun=6,jul=7,agt=8,sep=9,okt=10,nov=11,des=12;
    int pil,tmp;
    
    public TinjauStatus() {
        initComponents();
        Koneksi DB=new Koneksi();
               con=DB.con;
               stat=DB.stm;
        thnAjar();   
        addcombothn();
    }
    
    String thn="";
    Object thn1="";
    
    public void addcombothn(){
        sql = "SELECT DISTINCT tahun_ajar FROM dropdown" ;      
        try {                        
            stat=con.createStatement();                 
            stat.execute(sql);                        
            rs=stat.getResultSet();
                while (rs.next()) {
                        thn=rs.getString("tahun_ajar");
                        jComboBox2.addItem(thn);   
                        
                    }                      
                }catch (SQLException ex) 
                {            
                    JOptionPane.showMessageDialog(null, ex);
                }
    }
    
    public void popup(){
        JOptionPane.showMessageDialog(null, "Search Success","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    public void thnAjar(){
        String sqli = "SELECT * FROM datatransaksi";    
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqli);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
                String thnAjar = rs.getString("thn_ajar");
                jTextField1.setText(thnAjar);
           }
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }       
        
    }
    public void tabelLunasJan() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
        
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where januari ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasFeb() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where februari ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasMar() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
       sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where maret ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasApr() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where april ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }       
    }
    public void tabelLunasMei() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where mei ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasJun() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
       sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where juni ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasJul() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where juli ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasAgt() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where agustus ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasSep() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where september ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }       
    }
    public void tabelLunasOkt() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where oktober ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasNov() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where november ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelLunasDes() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where desember ='"+"lunas"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ;
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    //========
    public void tabelBLunasJan() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
        sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where januari ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasFeb() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where februari ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasMar() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where maret ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasApr() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where april ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }       
    }
    public void tabelBLunasMei() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where mei ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasJun() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where juni ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasJul() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where juli ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasAgt() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where agustus ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasSep() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where september ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }       
    }
    public void tabelBLunasOkt() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where oktober ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasNov() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where november ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
    public void tabelBLunasDes() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Kelas");
        tabelcd.addColumn("Angkatan");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        thn1= jComboBox2.getSelectedItem();
         sql = "SELECT nis,nama,kelas,angkatan FROM siswa where nis IN (SELECT nis FROM pembayaran WHERE nis IN"
                + "(SELECT nis FROM bulan where desember ='"+"-"+"' AND thn_ajr='"+thn1+"' ORDER BY id_s ASC))  " ; 
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("nis");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("kelas");
                o[3] = rs.getString("angkatan");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
    }

    public void tinjau(){
        pil = jComboBox1.getSelectedIndex();
            switch (pil) {
            case 1:
                String bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasJan();
                tabelBLunasJan();
                break;
            case 2:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasFeb();
                tabelBLunasFeb();
                break;
            case 3:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasMar();
                tabelBLunasMar();
                break;
            case 4:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasApr();
                tabelBLunasApr();
                break;
            case 5:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasMei();
                tabelBLunasMei();
                break;
            case 6:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasJun();
                tabelBLunasJun();
                break;
            case 7:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasJul();
                tabelBLunasJul();
                break;
            case 8:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasAgt();
                tabelBLunasAgt();
                break;
            case 9:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasSep();
                tabelBLunasSep();
                break;
            case 10:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasOkt();
                tabelBLunasOkt();
                break;
            case 11:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasNov();
                tabelBLunasNov();
                break;
            case 12:
                bln = String.valueOf(jComboBox1.getSelectedItem());
                tabelLunasDes();
                tabelBLunasDes();
                break;    
            default:
                JOptionPane.showMessageDialog(null, "bulan");
                break;
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Bulan ke-");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nobember", "Desember" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Zoom-icon.png"))); // NOI18N
        jButton1.setText("  Tinjau");
        jButton1.setActionCommand("Tinjau");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 4));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(4, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Lunas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Belum Lunas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(230, 230, 230))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS", "Nama", "Kelas", "Angkatan"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS", "Nama", "Kelas", "Angkatan"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tahun Ajaran");

        jTextField1.setEditable(false);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Ajar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(175, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        tinjau();
        popup();
        System.out.print(thn1);
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
