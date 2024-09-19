/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.paul.student;

import com.paul.teacher.*;
import com.paul.admin.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS ROG STRIX
 */
public class enrollmentpanel extends javax.swing.JPanel {

    /**
     * Creates new form addaccountpanel
     */
    public enrollmentpanel() {
        initComponents();
       
    }    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date d = new Date();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        scroll1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1190, 630));

        scroll.setBackground(new java.awt.Color(0, 0, 0));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scroll.setHorizontalScrollBar(sp);
        scroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        scroll.setToolTipText("");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(java.awt.SystemColor.control);
        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(java.awt.SystemColor.control);
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        scroll.setViewportView(jTable1);

        scroll1.setBackground(new java.awt.Color(0, 0, 0));
        scroll1.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.HORIZONTAL);
        scroll1.setHorizontalScrollBar(sp1);
        scroll1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        scroll1.setToolTipText("");

        jTable2.setBackground(java.awt.SystemColor.control);
        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setGridColor(java.awt.SystemColor.control);
        jTable2.setRowHeight(40);
        scroll1.setViewportView(jTable2);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel9.setText("AVAILABLE UNIT / S :");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel11.setText("0");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel13.setText("TOTAL ADDED UNIT / S :");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel12.setText("0");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel7.setText("TOTAL UNIT / S :");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel8.setText("0");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel14.setText("Year Level");
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel10.setText("Semester");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "First Semester", "Second Semester", "Mid Term" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel15.setText("Track");
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jComboBox4.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "none", "Business Analytics Track", "Network Technology Track" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(6, 6, 6)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int Myindex = jTable1.getSelectedRow();
       
       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to add " + model.getValueAt(Myindex, 0).toString(), "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

if (result == JOptionPane.YES_OPTION) {    
          try {
                Connection Con = null;
                java.sql.PreparedStatement add3 = null;

                Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");

                //add3 = Con.prepareStatement("INSERT INTO `studentfinalgrades` (`final_grade`, `course_code`, `course_title`, `unit`, `lec`, `lab`, `prerequisite`, `corequisite`, `Years`, `Semester`, `Track`, `Program`, `SR_Code` VALUES ('0.00',  '"+model.getValueAt(Myindex, 0).toString()+"',  '"+model.getValueAt(Myindex, 1).toString()+"','"+model.getValueAt(Myindex, 2).toString()+"', '"+model.getValueAt(Myindex, 3).toString()+"', '"+model.getValueAt(Myindex, 4).toString()+"', '"+model.getValueAt(Myindex, 5).toString()+"', '"+jComboBox3.getSelectedItem().toString()+"', '"+jComboBox2.getSelectedItem().toString()+"','"+jComboBox4.getSelectedItem().toString()+"', '"+txt1.getText()+"',(SELECT `Program` FROM `student` WHERE `SR_Code` = '" + txt1.getText() + "')");
                add3 = Con.prepareStatement("INSERT INTO `studentfinalgrades` (`final_grade`, `course_code`, `course_title`, `unit`, `lec`, `lab`, `prerequisite`, `corequisite`, `Years`, `Semester`, `Track`, `Program`, `SR_Code`) VALUES ( '',  '" + model.getValueAt(Myindex, 0).toString() + "',  '" + model.getValueAt(Myindex, 1).toString() + "','" + model.getValueAt(Myindex, 2) + "', '" + model.getValueAt(Myindex, 3) + "', '" + model.getValueAt(Myindex, 4) + "', '" + model.getValueAt(Myindex, 5).toString() + "', '', '" + jComboBox3.getSelectedItem().toString() + "', '" + jComboBox2.getSelectedItem().toString() + "','" + jComboBox4.getSelectedItem().toString() + "',(SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )), (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ))");
                add3.execute();
               tables();
                searchStudentinfo();
            } catch (SQLException ex) {
               
            }
}     

        
           
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to enrolled?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

if (result == JOptionPane.YES_OPTION) {   
       
            try {
                Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");
                String UpdateQuery = "UPDATE `studentfinalgrades` SET `Status`='Enrolled' WHERE SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) and Status= 'Not Enrolled' ";

                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                tables();
                JOptionPane.showMessageDialog(null, "Enrolled Successfully");
            } catch (SQLException ex) {
               
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        studentSr();
        searchStudentinfo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int Myindex = jTable2.getSelectedRow();
     
    int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove? " + model.getValueAt(Myindex, 0).toString(), "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

if (result == JOptionPane.YES_OPTION) { 
            try {
                Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");
                String crcode = model.getValueAt(Myindex, 0).toString();

                String Query = "Delete from studentportal.studentfinalgrades where course_code='" + crcode + "' and SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )";

                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                tables();

                searchStudentinfo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tables();
        } else {
            searchStudentinfo();
        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public void studentSr() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");
            St = Con.createStatement();
            String query = "SELECT `SR_Code` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )";
            ResultSet rs = St.executeQuery(query); // execute the query
           
            if (rs.next()) {
                searchStudentinfo();
            } else {
    String srcode = rs.getString("SR_Code");

                JOptionPane.showMessageDialog(null,"" + srcode + " is not existing.");
               
            }

        } catch (SQLException ex) {
            
        }

    }
    public void tables() {
        Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT  s.`course_code` as 'Course Code', s.`course_title` as 'Course Title', s.`unit` as 'Unit / s', s.`lec` as 'Lec', s.`lab` as 'Lab', s.`prerequisite` as 'Pre-Requisite / s', IF(s.`corequisite` = 'null', ' ', s.`corequisite`)  as 'Co-Requisite / s', s.`Semester` FROM `studentfinalgrades` s WHERE s.`Program` = (SELECT `Program` FROM `student`   WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "' and s.Track='" + jComboBox4.getSelectedItem().toString() + "' and s.SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) and Status='Not Enrolled'");

            jTable2.setModel(DbUtils.resultSetToTableModel(Rs));

            countUnit();
            System.out.println("Table1 successfully loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchStudentinfo() {

        try {

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentportal", "root", "");
            St = Con.createStatement();
            if (jComboBox3.getSelectedItem().toString().equals("Third Year") || jComboBox3.getSelectedItem().toString().equals("Fourth Year")) {
                if (jComboBox4.getSelectedItem().toString().equals("none")) {
                    Rs = St.executeQuery("SELECT DISTINCT s.`course_code` as 'Course Code', s.`course_title` as 'Course Title', s.`unit` as 'Unit / s', s.`lec` as 'Lec', s.`lab` as 'Lab', s.`prerequisite` as 'Pre-Requisite / s', s.`corequisite` as 'Co-Requisite / s', s.`Semester` FROM `subs` s WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "' and Track='" + jComboBox4.getSelectedItem().toString() + "' AND s.`course_code` NOT IN (SELECT `course_code` as 'Course Code' FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) ORDER BY course_code ASC;");
                    jTable1.setModel(DbUtils.resultSetToTableModel(Rs));
                    tables();
                    countUnit();

                } else {
                    Rs = St.executeQuery("SELECT DISTINCT s.`course_code` as 'Course Code', s.`course_title` as 'Course Title', s.`unit` as 'Unit / s', s.`lec` as 'Lec', s.`lab` as 'Lab', s.`prerequisite` as 'Pre-Requisite / s', s.`corequisite` as 'Co-Requisite / s', s.`Semester` FROM `subs` s WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "' and Track='" + jComboBox4.getSelectedItem().toString() + "' AND s.`course_code` NOT IN (SELECT `course_code` as 'Course Code' FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) ORDER BY course_code ASC;");
                    jTable1.setModel(DbUtils.resultSetToTableModel(Rs));
                    tables();
                    countUnit();
                }
            } else {
                Rs = St.executeQuery("SELECT DISTINCT s.`course_code` as 'Course Code', s.`course_title` as 'Course Title', s.`unit` as 'Unit / s', s.`lec` as 'Lec', s.`lab` as 'Lab', s.`prerequisite` as 'Pre-Requisite / s', s.`corequisite` as 'Co-Requisite / s', s.`Semester` FROM `subs` s WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "' AND s.`course_code` NOT IN (SELECT `course_code`  as 'Course Code' FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) ORDER BY course_code ASC");
                jTable1.setModel(DbUtils.resultSetToTableModel(Rs));
                tables();

                System.out.println("Student search successfully.");
                countUnit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (Integer.parseInt(jLabel11.getText()) == 0) {

        }
    }
  public void countUnit() {
        try {
            if (jComboBox3.getSelectedItem().toString().equals("Third Year") || jComboBox3.getSelectedItem().toString().equals("Fourth Year")) {
                if (jComboBox4.getSelectedItem().toString().equals("none")) {
                    try {

                        ResultSet Rs = St.executeQuery("SELECT SUM(subs.`unit`) as total_units\n"
                                + "FROM (\n"
                                + "    SELECT DISTINCT s.`course_code`, s.`course_title`, s.`unit`, s.`lec`, s.`lab`, s.`prerequisite`, s.`corequisite`, s.`Semester`\n"
                                + "    FROM `subs` s\n"
                                + "    WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "'\n"
                                + "    AND Track='" + jComboBox4.getSelectedItem().toString() + "' and s.`course_code` NOT IN (\n"
                                + "        SELECT `course_code` FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )\n"
                                + "    )\n"
                                + ") as subs");
                        int totalUnits = 0;
                        if (Rs.next()) {
                            totalUnits = Rs.getInt("total_units");
                        }
                        jLabel11.setText(Integer.toString(totalUnits));
                        jLabel8.setText(Integer.toString(totalUnits));
                    } catch (SQLException ex) {
                      
                    }
                } else {
                    try {

                        ResultSet Rs = St.executeQuery("SELECT SUM(subs.`unit`) as total_units\n"
                                + "FROM (\n"
                                + "    SELECT DISTINCT s.`course_code`, s.`course_title`, s.`unit`, s.`lec`, s.`lab`, s.`prerequisite`, s.`corequisite`, s.`Semester`\n"
                                + "    FROM `subs` s\n"
                                + "    WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "'\n"
                                + "    AND Track='" + jComboBox4.getSelectedItem().toString() + "' and s.`course_code` NOT IN (\n"
                                + "        SELECT `course_code` FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )\n"
                                + "    )\n"
                                + ") as subs");
                        int totalUnits = 0;
                        if (Rs.next()) {
                            totalUnits = Rs.getInt("total_units");
                        }
                        jLabel11.setText(Integer.toString(totalUnits));

                    } catch (SQLException ex) {
                       
                    }
                }

            } else {

                try {

                    ResultSet Rs = St.executeQuery("SELECT SUM(subs.`unit`) as total_units\n"
                            + "FROM (\n"
                            + "    SELECT DISTINCT s.`course_code`, s.`course_title`, s.`unit`, s.`lec`, s.`lab`, s.`prerequisite`, s.`corequisite`, s.`Semester`\n"
                            + "    FROM `subs` s\n"
                            + "    WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "'\n"
                            + "    AND s.`course_code` NOT IN (\n"
                            + "        SELECT `course_code` FROM `studentfinalgrades` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )\n"
                            + "    )\n"
                            + ") as subs");
                    int totalUnits = 0;
                    if (Rs.next()) {
                        totalUnits = Rs.getInt("total_units");
                    }
                    jLabel11.setText(Integer.toString(totalUnits));

                } catch (SQLException ex) {
                 
                }
            }
            ResultSet Rs = St.executeQuery("SELECT SUM(s.`unit`) as total_units FROM `studentfinalgrades` s WHERE s.`Program` = (SELECT `Program` FROM `student` WHERE `SR_Code` = (SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )) AND s.`Years` = '" + jComboBox3.getSelectedItem().toString() + "' AND s.`Semester` = '" + jComboBox2.getSelectedItem().toString() + "' and s.Track='"+jComboBox4.getSelectedItem().toString()+"' and s.SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )");
            if (Rs.next()) {
                int totalUnits = Rs.getInt("total_units");
                jLabel12.setText(Integer.toString(totalUnits));
            }
        } catch (SQLException ex) {
          
        }
        jLabel8.setText(Integer.toString((Integer.parseInt(jLabel11.getText()) + Integer.parseInt(jLabel12.getText()))));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    // End of variables declaration//GEN-END:variables
}
