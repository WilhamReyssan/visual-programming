/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.*;
import java.io.IOException;;
import java.util.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.util.*;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;
import javax.sql.DataSource;
/**
 *
 * @author Lenovo
 */
public class Cetak extends javax.swing.JPanel {

    /**
     * Creates new form Cetak
     */
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
  
    

          
    public void popup(){
        JOptionPane.showMessageDialog(null, "Export Excel Success","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void simpan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");

            Row row2 ;
            thn1= jComboBox1.getSelectedItem();
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn1+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
                row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


    }
    
    
    
    
    
    public void simpan2019_2020(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export_2019_2020.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
             row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");
            String thn="2019/2020";
            Row row2 ;
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
               row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


    }
    public void simpan2020_2021(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export_2020_2021.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
             row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");
            String thn="2020/2021";
            Row row2 ;
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
               row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


    }   
    public void simpan2021_2022(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export_2021_2022.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
             row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");
            String thn="2021/2022";
            Row row2 ;
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
               row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


    }
    public void simpan2022_2023(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export_2022_2023.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
             row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");
            String thn="2022/2023";
            Row row2 ;
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
               row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


    }   
    public void simpan2023_2024(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/spp","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("E:/export_2023_2024.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

     // Nama Field
            Row row1 = worksheet.createRow((short)0);
             row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Tahun Ajaran");
            row1.createCell(4).setCellValue("Januari");
            row1.createCell(5).setCellValue("Februari");
            row1.createCell(6).setCellValue("Maret");
            row1.createCell(7).setCellValue("April");
            row1.createCell(8).setCellValue("Mei");
            row1.createCell(9).setCellValue("Juni");
            row1.createCell(10).setCellValue("Juli");
            row1.createCell(11).setCellValue("Agustus");
            row1.createCell(12).setCellValue("September");
            row1.createCell(13).setCellValue("Oktober");
            row1.createCell(14).setCellValue("November");
            row1.createCell(15).setCellValue("Desember");
            String thn="2023/2024";
            Row row2 ;
            ResultSet rs = stat.executeQuery("SELECT siswa.*, bulan.* FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE thn_ajr='"+thn+"' ORDER BY thn_ajr ASC");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                // Sesuaikan dengan Jumlah Field
               row2.createCell(0).setCellValue(rs.getString(23));
                row2.createCell(1).setCellValue(rs.getString(2));//nama
                row2.createCell(2).setCellValue(rs.getString(4));//kelas
                row2.createCell(3).setCellValue(rs.getString(22));
                row2.createCell(4).setCellValue(rs.getString(10));
                row2.createCell(5).setCellValue(rs.getString(11));
                row2.createCell(6).setCellValue(rs.getString(12));
                row2.createCell(7).setCellValue(rs.getString(13));
                row2.createCell(8).setCellValue(rs.getString(14));
                row2.createCell(9).setCellValue(rs.getString(15));
                row2.createCell(10).setCellValue(rs.getString(16));
                row2.createCell(11).setCellValue(rs.getString(17));
                row2.createCell(12).setCellValue(rs.getString(18));
                row2.createCell(13).setCellValue(rs.getString(19));
                row2.createCell(14).setCellValue(rs.getString(20));
                row2.createCell(15).setCellValue(rs.getString(21));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
          //  rs.close();
          //  statement.close();
            //con.close();
            System.out.println("Export Excel Success");
            popup();
         }catch(ClassNotFoundException e){
        System.out.println(e);
    }catch(SQLException ex){
        System.out.println(ex);
    }catch(IOException ioe){
        System.out.println(ioe);
    }


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
                        jComboBox1.addItem(thn);   
                        
                    }                      
                }catch (SQLException ex) 
                {            
                    JOptionPane.showMessageDialog(null, ex);
                }
    }
     
    public Cetak() {
        initComponents();
        Koneksi DB=new Koneksi();
               con=DB.con;
               stat=DB.stm;
               addcombothn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton3.setText("Export To Excel");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Tahun Ajaran");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Ajaran" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
