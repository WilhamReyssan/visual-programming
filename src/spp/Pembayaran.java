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
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JRException;
import java.util.ArrayList;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Lenovo
 */
public class Pembayaran extends javax.swing.JPanel {

    /**
     * Creates new form Pembayaran
     */
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql,sqli,sqlj,sqll;
    double nilai;
    int tmp,tmp1,temp,pil,pil1,tunggak=0;
    int jan=1,feb=2,mar=3,apr=4,mei=5,jun=6,jul=7,agt=8,sep=9,okt=10,nov=11,des=12;
    double disc=0,kembalian=0;
    String nama,kelas,nis,biaya,thnAjar;
    public Pembayaran() {
        initComponents();
        Koneksi DB=new Koneksi();
               con=DB.con;
               stat=DB.stm;
               addcombo();
        
    }
    public void popup_cari(){
        JOptionPane.showMessageDialog(null, "Search Success","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    public void popup(){
        JOptionPane.showMessageDialog(null, "Success","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    public void popup_byr(){
        JOptionPane.showMessageDialog(null, "Pembayaran Berhasil","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
//===================================================================2019/2020    
    public boolean cek (){
        sql = "SELECT nis FROM bulan where nis like '%"+ jTextField2.getText()+ "%'AND thn_ajr='"+jTextField5.getText()+"'" ;        
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();
           while (rs.next()) {
                String id_sA=rs.getString("nis");
                if(id_sA.equals(jTextField2.getText())){
                    
                    return true;
                     
                }        
            }                      
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }  
    public void tabel1() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("Januari");
        tabelcd.addColumn("Februari");
        tabelcd.addColumn("Maret");
        tabelcd.addColumn("April");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+jTextField5.getText()+"'" ;  
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqll);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("januari");
                o[1] = rs.getString("februari");
                o[2] = rs.getString("maret");
                o[3] = rs.getString("april");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
        
    }
    public void tabel2() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable2.setModel(tabelcd);
        tabelcd.addColumn("Mei");
        tabelcd.addColumn("Juni");
        tabelcd.addColumn("Juli");
        tabelcd.addColumn("Agustus");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+jTextField5.getText()+"'" ;  
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqll);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("mei");
                o[1] = rs.getString("juni");
                o[2] = rs.getString("juli");
                o[3] = rs.getString("agustus");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
        
    }
    public void tabel3() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable3.setModel(tabelcd);
        tabelcd.addColumn("September");
        tabelcd.addColumn("Oktober");
        tabelcd.addColumn("November");
        tabelcd.addColumn("Desember");
      
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
        sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+jTextField5.getText()+"'" ;  
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqll);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
               Object [] o = new Object[4];
                o[0] = rs.getString("september");
                o[1] = rs.getString("oktober");
                o[2] = rs.getString("november");
                o[3] = rs.getString("desember");
                tabelcd.addRow(o);
           }   
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
        
    }

    String x="";
    public void tunggakan1(){
        String T=jTextField5.getText();
        String[] kata = T.split("/");
        int num1 = Integer.parseInt(kata[0]);
        int num2= Integer.parseInt(kata[1]);
        num1=num1-1;
        num2=num2-1;
        x=num1+"/"+num2;
        System.out.print(x);
        
            DefaultTableModel tabelcd = new DefaultTableModel();
            jTable4.setModel(tabelcd);
            tabelcd.addColumn("Januari");
            tabelcd.addColumn("Februari");
            tabelcd.addColumn("Maret");
            tabelcd.addColumn("April");
            tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
            tabelcd.fireTableDataChanged();
            sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+x+"'" ;  
            try {                        
               stat=con.createStatement();                 
               stat.execute(sqll);                        
               rs=stat.getResultSet();   
               while (rs.next()) {
                   Object [] o = new Object[4];
                   o[0] = rs.getString("januari");
                    o[1] = rs.getString("februari");
                    o[2] = rs.getString("maret");
                    o[3] = rs.getString("april");
                    tabelcd.addRow(o);
                    if(o[0].equals("-")){
                        tunggak++;
                    }
                    if(o[1].equals("-")){
                        tunggak++;
                    }
                    if(o[2].equals("-")){
                        tunggak++;
                    }
                    if(o[3].equals("-")){
                        tunggak++;
                    }
               }   
            }catch (SQLException ex) 
            {            
                JOptionPane.showMessageDialog(null, ex);
            }
        
    }
    public void tunggakan2(){
        String T=jTextField5.getText();
        String[] kata = T.split("/");
        int num1 = Integer.parseInt(kata[0]);
        int num2= Integer.parseInt(kata[1]);
        num1=num1-1;
        num2=num2-1;
        String x=num1+"/"+num2;
        
        
            DefaultTableModel tabelcd = new DefaultTableModel();
            jTable5.setModel(tabelcd);
            tabelcd.addColumn("Mei");
            tabelcd.addColumn("Juni");
            tabelcd.addColumn("Juli");
            tabelcd.addColumn("Agustus");
            tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
            tabelcd.fireTableDataChanged();
            sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+x+"'" ;  
            try {                        
               stat=con.createStatement();                 
               stat.execute(sqll);                        
               rs=stat.getResultSet();   
               while (rs.next()) {
                   Object [] o = new Object[4];
                   o[0] = rs.getString("mei");
                   o[1] = rs.getString("juni");
                   o[2] = rs.getString("juli");
                   o[3] = rs.getString("agustus");
                    tabelcd.addRow(o);
                    if(o[0].equals("-")){
                        tunggak++;
                    }
                    if(o[1].equals("-")){
                        tunggak++;
                    }
                    if(o[2].equals("-")){
                        tunggak++;
                    }
                    if(o[3].equals("-")){
                        tunggak++;
                    }
               }   
            }catch (SQLException ex) 
            {            
                JOptionPane.showMessageDialog(null, ex);
            }
        
        
        
    }
    public void tunggakan3(){
       String T=jTextField5.getText();
        String[] kata = T.split("/");
        int num1 = Integer.parseInt(kata[0]);
        int num2= Integer.parseInt(kata[1]);
        num1=num1-1;
        num2=num2-1;
        String x=num1+"/"+num2;
        

            DefaultTableModel tabelcd = new DefaultTableModel();
            jTable6.setModel(tabelcd);
            tabelcd.addColumn("September");
            tabelcd.addColumn("Oktober");
            tabelcd.addColumn("November");
            tabelcd.addColumn("Desember");
            tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
            tabelcd.fireTableDataChanged();
            sqll = "SELECT * FROM bulan where nis='"+jTextField2.getText()+"'AND thn_ajr='"+x+"'" ;  
            try {                        
               stat=con.createStatement();                 
               stat.execute(sqll);                        
               rs=stat.getResultSet();   
               while (rs.next()) {
                   Object [] o = new Object[4];
                   o[0] = rs.getString("september");
                   o[1] = rs.getString("oktober");
                   o[2] = rs.getString("november");
                   o[3] = rs.getString("desember");
                    tabelcd.addRow(o);
                    if(o[0].equals("-")){
                        tunggak++;
                    }
                    if(o[1].equals("-")){
                        tunggak++;
                    }
                    if(o[2].equals("-")){
                        tunggak++;
                    }
                    if(o[3].equals("-")){
                        tunggak++;
                    }
               }   
            }catch (SQLException ex) 
            {            
                JOptionPane.showMessageDialog(null, ex);
            }
        
        
        
    }
    
    public void cari(){
       sql = "SELECT * FROM siswa where nis ='"+ jTextField1.getText()+ "'" + "or nama like '" + jTextField1.getText() + "%'";       
        try {                        
            stat=con.createStatement();                 
            stat.execute(sql);                        
            rs=stat.getResultSet();   
            while (rs.next()) {
                nis = rs.getString("nis");
                jTextField2.setText(nis);
                nama = rs.getString("nama");
                jTextField3.setText(nama);
                kelas = rs.getString("kelas");
                jTextField4.setText(kelas);
                String status=rs.getString("status");
                jTextField11.setText(status);
        }                      
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
        String sqli = "SELECT * FROM datatransaksi";    
        try {               
            
            stat=con.createStatement();                 
            stat.execute(sqli);                        
            rs=stat.getResultSet();   
            while (rs.next()) {
                biaya = rs.getString("biaya");
                if(jTextField11.getText().equals("Anak Guru")){
                        String sts=rs.getString("pt_anak_guru");
                        disc=Double.parseDouble(sts);
                }
                if(jTextField11.getText().equals("KIP")){
                        String sts=rs.getString("pt_KIP");
                        disc=Double.parseDouble(sts);
                }
                if(jTextField11.getText().equals("Tahfidz 1")){
                        String sts=rs.getString("pt_tahfidz");
                        disc=Double.parseDouble(sts);
                }
                if(jTextField11.getText().equals("Tahfidz 2")){
                        String sts=rs.getString("pt_tahfidz2");
                        disc=Double.parseDouble(sts);
                }
                if(jTextField11.getText().equals("Tahfidz 3")){
                        String sts=rs.getString("pt_tahfidz3");
                        disc=Double.parseDouble(sts);
                }
                
                double value = Double.parseDouble(biaya);
                nilai =value-disc;
                String mataUang = String.format("Rp.%,.0f", nilai).replaceAll(",", ".")+",00";
                jTextField10.setText(mataUang);
                thnAjar = rs.getString("thn_ajar");
                jTextField5.setText(thnAjar);
           }
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
        String patokan=jTextField5.getText();

            tabel1();
            tabel2();
            tabel3();

    }
    
    String bulan_Bayar="";
    //String thn="";
   public void addcombo(){
        sql = "SELECT DISTINCT tahun_ajar FROM dropdown" ;      
        try {                        
            stat=con.createStatement();                 
            stat.execute(sql);                        
            rs=stat.getResultSet();
                while (rs.next()) {
                        String thn=rs.getString("tahun_ajar");
                        jComboBox3.addItem(thn);       
                    }                      
                }catch (SQLException ex) 
                {            
                    JOptionPane.showMessageDialog(null, ex);
                }
    }
   Object thn="";
    public void bayar(){
   
        try{ 
            String nis=jTextField2.getText();
           
            String id_sA=jTextField2.getText();
            
          //  Random id= new Random();
          //  int id_byr= id.nextInt(10000);
          //  String id_bayar = Integer.toString(id_byr);
            
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(tampilan);
            thn= jComboBox3.getSelectedItem();
            String tanggal = String.valueOf(format.format(jDateChooser1.getDate()));
           // String thnAjr= jTextField5.getText();
            stat.executeUpdate("INSERT INTO pembayaran (tglbayar,nis,tahun_ajar)VALUES ('"+tanggal+"','"+nis+"','"+thn+"');");  
          
            if (cek()==false){
                System.out.print("good");
                stat.executeUpdate("INSERT INTO bulan (januari,februari,maret,april,mei,juni,juli,agustus,september,oktober,november,desember,nis,thn_ajr)VALUES ('"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+"-"+"','"+id_sA+"','"+thn+"');"); 
            }
           
            pil = jComboBox1.getSelectedIndex();
            switch (pil) {
                case 1:
                    String bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=jan;
                    break;
                case 2:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=feb;
                    break;
                case 3:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=mar;
                    break;
                case 4:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=apr;
                    break;
                case 5:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=mei;
                    break;
                case 6:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=jun;
                    break;
                case 7:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=jul;
                    break;
                case 8:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=agt;
                    break;
                case 9:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=sep;
                    break;
                case 10:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=okt;
                    break;
                case 11:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=nov;
                    break;
                case 12:
                    bln = String.valueOf(jComboBox1.getSelectedItem());
                    tmp=des;
                    break;    
                default:
                    JOptionPane.showMessageDialog(null, "bulan");
                    break;
            }
            
            pil1 = jComboBox2.getSelectedIndex();
            switch (pil1) {
                case 1:
                    String bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=jan;
                    break;
                case 2:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=feb;
                    break;
                case 3:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=mar;
                    break;
                case 4:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=apr;
                    break;
                case 5:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=mei;
                    break;
                case 6:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=jun;
                    break;
                case 7:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=jul;
                    break;
                case 8:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=agt;
                    break;
                case 9:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=sep;
                    break;
                case 10:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=okt;
                    break;
                case 11:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=nov;
                    break;
                case 12:
                    bln1 = String.valueOf(jComboBox2.getSelectedItem());
                    tmp1=des;
                    break;    
                default:
                    JOptionPane.showMessageDialog(null, "bulan");
                    break;
            }
            //to bulan bayaran
            
            if(tmp<tmp1 || tmp==tmp1){
                
                temp=tmp1-tmp+1;
                String status="lunas";
                for(int i=tmp;i<=tmp1;i++){
                    if(i==1){
                        String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar="januari, ";
                    }
                    if(i==2){
                        String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"februari, ";
                    }
                    if(i==3){
                        String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"maret, ";
                    }
                    if(i==4){
                        String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"april, ";
                    }
                    if(i==5){
                        String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"mei, ";
                    }
                    if(i==6){
                        String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"juni, ";
                    }
                    if(i==7){
                        String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"juli, ";
                    }
                    if(i==8){
                        String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"agustus, ";
                    }
                    if(i==9){
                        String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"september, ";
                    }
                    if(i==10){
                        String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"oktober, ";
                    }
                    if(i==11){
                        String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"november, ";
                    }
                    if(i==12){
                        String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                        stat.executeUpdate(sqlq);
                        bulan_Bayar=bulan_Bayar+"desember, ";
                    }
                 }
                 try{   
                    String sqli = "UPDATE pembayaran SET bulan_Bayar='"+bulan_Bayar+"'WHERE nis='"+jTextField2.getText()+"'AND tahun_ajar='"+thn+"'AND tglbayar='"+tanggal+"' ";
                    System.out.print(bulan_Bayar);
                    stat.executeUpdate(sqli);
                //    stat.close();
                    System.out.println("Berhasil Memasukan Data");
                }catch(Exception e){
                    System.err.println("gagal Memasukan Data");

                }
                
            //    String sqlq = "UPDATE pembayaran SET bulan_Bayar='"+bulan_Bayar+"'WHERE nis='"+jTextField2.getText()+"'AND tahun_ajar='"+jTextField6.getText()+"'AND tglbayar='"+tanggal+"' ";
            //   stat.executeUpdate(sqlq);
            }
  if(tmp>tmp1){
            temp=tmp1-tmp+13;
            int temp1=Math.abs(temp);
            System.out.print("yes"+(temp1)+"yes");
            String status="lunas";
          
            for(int i=tmp;i<=12;i++){
               if(i==1){
                   String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"januari, ";
               }
               if(i==2){
                   String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"februari, ";
               }
               if(i==3){
                   String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"maret, ";
               }
               if(i==4){
                   String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"april, ";
               }
               if(i==5){
                   String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"mei, ";
               }
               if(i==6){
                   String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"juni, ";
               }
               if(i==7){
                   String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"juli, ";
               }
               if(i==8){
                   String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"agustus, ";
               }
               if(i==9){
                   String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"september, ";
               }
               if(i==10){
                   String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"oktober, ";
               }
               if(i==11){
                   String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"november, ";
               }
               if(i==12){
                   String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                      bulan_Bayar=bulan_Bayar+"desember, ";
               }
           }
           for(int i=1;i<=tmp1;i++){
               if(i==1){
                   String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"januari, ";
                     
               }
               if(i==2){
                   String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"februari, ";
               }
               if(i==3){
                   String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"maret, ";
               }
               if(i==4){
                   String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"april, ";
               }
               if(i==5){
                   String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"mei, ";
               }
               if(i==6){
                   String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"juni, ";
               }
               if(i==7){
                   String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"juli, ";
               }
               if(i==8){
                   String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"agustus, ";
               }
               if(i==9){
                   String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"september, ";
               }
               if(i==10){
                   String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"oktober, ";
               }
               if(i==11){
                   String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"november, ";
               }
               if(i==12){
                   String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                     stat.executeUpdate(sqlq);
                     bulan_Bayar=bulan_Bayar+"desember, ";
               }
           }
           try{   
                    String sqli = "UPDATE pembayaran SET bulan_Bayar='"+bulan_Bayar+"'WHERE nis='"+jTextField2.getText()+"'AND tahun_ajar='"+thn+"'AND tglbayar='"+tanggal+"' ";
                    System.out.print(bulan_Bayar);
                    stat.executeUpdate(sqli);
                //    stat.close();
                    System.out.println("Berhasil Memasukan Data");
                }catch(Exception e){
                    System.err.println("gagal Memasukan Data");

                }
        }
  //=============================================          
        //   stat.close();
           System.out.println("Berhasil Memasukan Data");
        }catch(Exception e){
            System.err.println("gagal Memasukan Data");
            System.out.print("nnn");
        }
           
        
        sqlj = "SELECT biaya FROM datatransaksi";       
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqlj);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
                String biayatotal = rs.getString("biaya");
               
                
                double biayatot = Double.parseDouble(biayatotal);
                double tot=(biayatot-disc)*temp;
                String uangtot = String.format("Rp.%,.0f", tot).replaceAll(",", ".")+",00";
                jTextField7.setText(uangtot);
                
                String bayar = jTextField8.getText();
                double bayartot = Double.parseDouble(bayar);
                kembalian= bayartot-tot; 
                String kembaliantot = String.format("Rp.%,.0f", kembalian).replaceAll(",", ".")+",00";
                jTextField9.setText(kembaliantot);
           }
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }

        
        int tunggak1=0;
        String sqlb= "SELECT * FROM bulan WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
        try {
           
           stat=con.createStatement();                 
           stat.execute(sqlb);                        
           rs=stat.getResultSet();
           while (rs.next()) {
                String januari = rs.getString("januari");
                String februari = rs.getString("februari");
                String maret = rs.getString("maret");
                String april = rs.getString("april");
                String mei = rs.getString("mei");
                String juni = rs.getString("juni");
                String juli = rs.getString("juli");
                String agustus = rs.getString("agustus");
                String september = rs.getString("september");
                String oktober = rs.getString("oktober");
                String november = rs.getString("november");
                String desember = rs.getString("desember");
                if (januari.equals("-")){
                    tunggak1++;
                }
                if (februari.equals("-")){
                    tunggak1++;
                }
                if (maret.equals("-")){
                    tunggak1++;
                }
                if (april.equals("-")){
                    tunggak1++;
                }
                if (mei.equals("-")){
                    tunggak1++;
                }
                if (juni.equals("-")){
                    tunggak1++;
                }
                if (juli.equals("-")){
                    tunggak1++;
                }
                if (agustus.equals("-")){
                    tunggak1++;
                }
                if (september.equals("-")){
                    tunggak1++;
                }
                if (oktober.equals("-")){
                    tunggak1++;
                }
                if (november.equals("-")){
                    tunggak1++;
                }
                if (desember.equals("-")){
                    tunggak1++;
                }
           }
           
           double nunggak1= nilai*tunggak1; 
           String nunggakfinal = String.format("Rp.%,.0f", nunggak1).replaceAll(",", ".")+",00";
           String sqlo = "UPDATE bulan SET tunggak='"+nunggakfinal+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                try{  
                     stat.executeUpdate(sqlo);
                }catch (SQLException ex) 
                {            
                JOptionPane.showMessageDialog(null, ex);
                }
            }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }  
        try{
            String byr=jTextField7.getText();
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(tampilan);

            String tanggal = String.valueOf(format.format(jDateChooser1.getDate()));
            String sqlo = "UPDATE pembayaran SET byr='"+byr+"' WHERE tglbayar='"+tanggal+"'AND nis='"+jTextField2.getText()+"'";
            stat.executeUpdate(sqlo);
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    public void refresh(){
         String patokan=jTextField5.getText();
       
            tabel1();
            tabel2();
            tabel3();
            tunggakan1();
            tunggakan2();
            tunggakan3();
            jTextField12.setText(x);

        String sqlm = "SELECT biaya FROM datatransaksi";    
        try {
           stat=con.createStatement();                 
           stat.execute(sqlm);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
                String biaya1 = rs.getString("biaya");
                double valueE = Double.parseDouble(biaya1);
                double valueA=(valueE-disc)*tunggak;
                String mataUang1 = String.format("Rp.%,.0f", valueA).replaceAll(",", ".")+",00";
                jTextField6.setText(mataUang1);
                tunggak=0;
           }
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
        try{
            String byr=jTextField7.getText();
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(tampilan);

            String tanggal = String.valueOf(format.format(jDateChooser1.getDate()));
            String sqlo = "UPDATE pembayaran SET byr='"+byr+"' WHERE tglbayar='"+tanggal+"'AND nis='"+jTextField2.getText()+"'";
            stat.executeUpdate(sqlo);
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
    
   // ArrayList<String> deret= new ArrayList <String> ();
    String bln="" ; 
    public void cekData(){
        sql = "SELECT * FROM bulan where nis='"+ jTextField2.getText()+ "' AND thn_ajr='" + thn+ "'";       
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
                if(rs.getString("januari").equals("-")){
                    //deret.add("januari");
                    String bln1="januari, ";
                    bln=bln+bln1;
                }
                if(rs.getString("februari").equals("-")){
                    //deret.add("februari");
                    String bln1="februari, ";
                    bln=bln+bln1;
                }
                if(rs.getString("maret").equals("-")){
                    //deret.add("maret");
                    String bln1="maret, ";
                    bln=bln+bln1;
                }
                if(rs.getString("april").equals("-")){
                    //deret.add("april");
                    String bln1="april, ";
                    bln=bln+bln1;
                }
                if(rs.getString("mei").equals("-")){
                    //deret.add("mei");
                    String bln1="mei, ";
                    bln=bln+bln1;
                }
                if(rs.getString("juni").equals("-")){
                    //deret.add("juni");
                    String bln1="juni, ";
                    bln=bln+bln1;
                }
                if(rs.getString("juli").equals("-")){
                    //deret.add("juli");
                    String bln1="juli, ";
                    bln=bln+bln1;
                }
                if(rs.getString("agustus").equals("-")){
                    //deret.add("agustus");
                    String bln1="agustus, ";
                    bln=bln+bln1;
                }
                if(rs.getString("september").equals("-")){
                    //deret.add("september");
                    String bln1="september, ";
                    bln=bln+bln1;
                }
                if(rs.getString("oktober").equals("-")){
                    //deret.add("oktober");
                    String bln1="oktober, ";
                    bln=bln+bln1;
                }
                if(rs.getString("november").equals("-")){
                    //deret.add("november");
                    String bln1="november, ";
                    bln=bln+bln1;
                }
                if(rs.getString("desember").equals("-")){
                    //deret.add("desember");
                    String bln1="desember ";
                    bln=bln+bln1;
                }
            }                      
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try{   
            String sqli = "UPDATE bulan SET bln='"+bln+"'WHERE nis='"+ jTextField2.getText()+ "' AND thn_ajr='" + thn+ "'"; 
            stat.executeUpdate(sqli);
       //     stat.close();
            System.out.println("Berhasil Memasukan Data");
        }catch(Exception e){
            System.err.println("gagal Memasukan Data");
            
        }
        
    }
    
    public void cetak(){
        thn= jComboBox3.getSelectedItem();
         sql = "SELECT bulan.*,siswa.*,pembayaran.* FROM bulan inner join pembayaran ON bulan.nis=pembayaran.nis inner join siswa on pembayaran.nis=siswa.nis WHERE nama='"+jTextField3.getText()+"'AND thn_ajr='"+thn+"'  ORDER BY tglbayar\n" +
"DESC LIMIT 1" ;  
        try {
            ResultSet rs = stat.executeQuery(sql);
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);            
            JasperReport jasperReport = JasperCompileManager.compileReport("D:/spp/src/spp/kwitansi.jrxml");          
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Tidak Ada Laporan "+e);
        }
    }
    
    public void cetak1(){
         sql = "SELECT bulan.*,siswa.*,pembayaran.* FROM bulan inner join pembayaran ON bulan.nis=pembayaran.nis inner join siswa on pembayaran.nis=siswa.nis WHERE nama='"+jTextField3.getText()+"'AND thn_ajr='"+jTextField5.getText()+"'  ORDER BY tglbayar\n" +
"DESC LIMIT 1" ;  
        try {
            ResultSet rs = stat.executeQuery(sql);
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);            
            JasperReport jasperReport = JasperCompileManager.compileReport("D:/spp/src/spp/kwitansi.jrxml");          
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Tidak Ada Laporan "+e);
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

        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1201, 735));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("NIS");

        jTextField2.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jTextField3.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Kelas");

        jTextField4.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Pembayaran Tahun Ajar");

        jTextField5.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Taggal Bayar");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Search by NIS / Nama");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Zoom-icon.png"))); // NOI18N
        jButton1.setText("  Cari");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(435, 4));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Pembayaran");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Bulan Ke-");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nobember", "Desember" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Hingga");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "Nobember", "Desember" }));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Biaya Total");

        jTextField7.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Jumlah Bayar");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Kembalian");

        jTextField9.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(443, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Actions-document-edit-icon.png"))); // NOI18N
        jButton2.setText("Bayar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/printer-icon.png"))); // NOI18N
        jButton3.setText("Cetak");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Data SPP");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/reFresh.png"))); // NOI18N
        jButton4.setText("Refresh");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Januari", "Februari", "Maret", "April"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Biaya / Bulan");

        jTextField10.setEditable(false);

        jLabel15.setText("Rp.");

        jLabel16.setText("Rp.");

        jLabel17.setText("Rp.");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mei", "Juni", "Juli", "Agustus"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "September", "Oktober", "November", "Desember"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Tunggakan tahun ajaran ");

        jTextField6.setEditable(false);
        jTextField6.setText("Rp.-0");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Januari", "Februari", "Maret", "April"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mei", "Juni", "Juli", "Agustus"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "September", "Oktober", "November", "Desember"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Status");

        jTextField11.setEditable(false);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Ajaran" }));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Tahun Ajaran");

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 7, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel8))
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel5))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addComponent(jLabel15))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel9)
                                                    .addGap(12, 12, 12)
                                                    .addComponent(jComboBox2, 0, 1, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel16)
                                                                .addComponent(jLabel17))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                                .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel20))
                                        .addGap(99, 99, 99)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                            .addComponent(jTextField3)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField10)
                                            .addComponent(jTextField11)
                                            .addComponent(jTextField5)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(jButton2)
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton3)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton4))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        cari();
        popup_cari();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here: 
        System.out.print(jTextField8.getText());
        if(jComboBox1.getSelectedIndex()!=0 && jComboBox2.getSelectedIndex()!=0 && jComboBox3.getSelectedIndex()!=0 && jTextField8.getText().isEmpty()==false && jDateChooser1.getDate()!=null){
                bayar();
                if(kembalian>=0){
                popup_byr();
                }else{
                    try{
                        pil = jComboBox1.getSelectedIndex();
                    switch (pil) {
                        case 1:
                            String bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=jan;
                            break;
                        case 2:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=feb;
                            break;
                        case 3:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=mar;
                            break;
                        case 4:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=apr;
                            break;
                        case 5:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=mei;
                            break;
                        case 6:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=jun;
                            break;
                        case 7:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=jul;
                            break;
                        case 8:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=agt;
                            break;
                        case 9:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=sep;
                            break;
                        case 10:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=okt;
                            break;
                        case 11:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=nov;
                            break;
                        case 12:
                            bln = String.valueOf(jComboBox1.getSelectedItem());
                            tmp=des;
                            break;    
                        default:
                            JOptionPane.showMessageDialog(null, "bulan");
                            break;
                    }

                    pil1 = jComboBox2.getSelectedIndex();
                    switch (pil1) {
                        case 1:
                            String bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=jan;
                            break;
                        case 2:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=feb;
                            break;
                        case 3:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=mar;
                            break;
                        case 4:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=apr;
                            break;
                        case 5:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=mei;
                            break;
                        case 6:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=jun;
                            break;
                        case 7:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=jul;
                            break;
                        case 8:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=agt;
                            break;
                        case 9:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=sep;
                            break;
                        case 10:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=okt;
                            break;
                        case 11:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=nov;
                            break;
                        case 12:
                            bln1 = String.valueOf(jComboBox2.getSelectedItem());
                            tmp1=des;
                            break;    
                        default:
                            JOptionPane.showMessageDialog(null, "bulan");
                            break;
                    }
                    if(tmp<tmp1 || tmp==tmp1){
                        temp=tmp1-tmp+1;
                        String status="-";
                        for(int i=tmp;i<=tmp1;i++){
                            if(i==1){
                                String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);        
                            }
                            if(i==2){
                                String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==3){
                                String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==4){
                                String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==5){
                                String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==6){
                                String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==7){
                                String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==8){
                                String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==9){
                                String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==10){
                                String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==11){
                                String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                            if(i==12){
                                String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                                stat.executeUpdate(sqlq);
                            }
                         }
                    }
          if(tmp>tmp1){
                    temp=tmp1-tmp+13;
                    int temp1=Math.abs(temp);
                    System.out.print("yes"+(temp1)+"yes");
                    String status="-";

                    for(int i=tmp;i<=12;i++){
                       if(i==1){
                           String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==2){
                           String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==3){
                           String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==4){
                           String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==5){
                           String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==6){
                           String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==7){
                           String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==8){
                           String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==9){
                           String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==10){
                           String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==11){
                           String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==12){
                           String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                   }
                   for(int i=1;i<=tmp1;i++){
                       if(i==1){
                           String sqlq = "UPDATE bulan SET januari='"+(status)+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==2){
                           String sqlq = "UPDATE bulan SET februari='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==3){
                           String sqlq = "UPDATE bulan SET maret='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==4){
                           String sqlq = "UPDATE bulan SET april='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==5){
                           String sqlq = "UPDATE bulan SET mei='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==6){
                           String sqlq = "UPDATE bulan SET juni='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==7){
                           String sqlq = "UPDATE bulan SET juli='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==8){
                           String sqlq = "UPDATE bulan SET agustus='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==9){
                           String sqlq = "UPDATE bulan SET september='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==10){
                           String sqlq = "UPDATE bulan SET oktober='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==11){
                           String sqlq = "UPDATE bulan SET november='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                       if(i==12){
                           String sqlq = "UPDATE bulan SET desember='"+status+"'WHERE nis='"+jTextField2.getText()+"'AND thn_ajr='"+thn+"'";
                             stat.executeUpdate(sqlq);
                       }
                   } 
                    }
          //=============================================          
                 //  stat.close();
                   System.out.println("Berhasil Memasukan Data");
                }catch(Exception e){
                    System.err.println("gagal Memasukan Data");
                    System.out.print("nnn");
                }

                     JOptionPane.showMessageDialog(null, "Pembayaran Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
                cekData();
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Form Bulan Pembayaran","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        refresh();
        popup(); 
    }//GEN-LAST:event_jButton4MouseClicked
//print
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        
        if(thn==""){
            cetak();
        }else{
            cetak();
        }
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
