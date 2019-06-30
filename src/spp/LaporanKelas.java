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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Lenovo
 */
public class LaporanKelas extends javax.swing.JPanel {

    /**
     * Creates new form LaporanKelas
     */
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    int tunggak=0;
    
    //inputCombo2
    public void addcombo(){
        sql = "SELECT DISTINCT kelas FROM siswa where nis is not null" ;      
        try {                        
            stat=con.createStatement();                 
            stat.execute(sql);                        
            rs=stat.getResultSet();
                while (rs.next()) {
                        String kls=rs.getString("kelas");
                        jComboBox2.addItem(kls);       
                    }                      
                }catch (SQLException ex) 
                {            
                    JOptionPane.showMessageDialog(null, ex);
                }
    }
  

    Object kls="";
    public void cari() {
        DefaultTableModel tabelcd = new DefaultTableModel();
        jTable1.setModel(tabelcd);
        tabelcd.addColumn("NIS");
        tabelcd.addColumn("Nama");
        tabelcd.addColumn("Tunggakan");
        
        tabelcd.getDataVector().removeAllElements();//untuk mengkosongkan isi tabel di form
        tabelcd.fireTableDataChanged();
       // tunggakan();
      //  String a=jTextField2.getText().toUpperCase();
        
            //comboKelas
            int pil1;
            
            kls= jComboBox2.getSelectedItem();
            System.out.print(kls);
            thn1= jComboBox1.getSelectedItem();
        sql = "SELECT siswa.*,bulan.* FROM bulan INNER JOIN siswa ON bulan.nis=siswa.nis WHERE kelas='"+kls+"'AND thn_ajr='"+ thn1+"'";   
        try {                        
           stat=con.createStatement();                 
           stat.execute(sql);                        
           rs=stat.getResultSet();
                
           while (rs.next()) {
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                Object [] o = new Object[3];
                 o[0] = rs.getString("nis");
                 o[1] = rs.getString("nama");
                 o[2] = rs.getString("bln");

                tabelcd.addRow(o);
           }
            
          
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }    
        
    }
    
    public void thnAjar(){
        String sqli = "SELECT * FROM datatransaksi";    
        try {                        
           stat=con.createStatement();                 
           stat.execute(sqli);                        
           rs=stat.getResultSet();   
           while (rs.next()) {
                String thnAjar = rs.getString("thn_ajar");
            //    jTextField1.setText(thnAjar);
           }
        }catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, "Kelas");
        }       
        
    }
    String thnAjar;
    public void cetak(){
        //sql = "SELECT siswa.nis,siswa.nama,siswa.kelas, bulan.tunggak,bulan.thn_ajr FROM siswa INNER JOIN bulan ON siswa.nis=bulan.nis WHERE kelas='"+jTextField2.getText()+"'AND thn_ajr='"+jTextField1.getText()+"'";   
        
            thn1= jComboBox1.getSelectedItem();
        sql = "SELECT siswa.nis,siswa.nama,siswa.kelas, bulan.bln,bulan.thn_ajr FROM siswa INNER JOIN bulan ON  siswa.nis=bulan.nis WHERE kelas='"+kls+"'AND thn_ajr='"+thn1+"'";   
        try {
            ResultSet rs = stat.executeQuery(sql);
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);            
            JasperReport jasperReport = JasperCompileManager.compileReport("D:/spp/src/spp/kls.jrxml");          
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Ada Laporan "+e);
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
    
    public LaporanKelas() {
        initComponents();
        Koneksi DB=new Koneksi();
               con=DB.con;
               stat=DB.stm;
        addcombo();
        addcombothn();
        thnAjar();            
    }

  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NIS", "Nama", "Tunggakan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Tahun Ajaran");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/Zoom-icon.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/New folder/printer-icon.png"))); // NOI18N
        jButton2.setText("Cetak");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun Ajar" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(318, 318, 318)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        cetak();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
