package com.paul.admin;

import com.paul.teacher.*;
import com.paul.admin.*;
import com.sun.tools.javac.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import scrollbar.ScrollBarCustom;


public class deleteteacheraccountpanel extends javax.swing.JPanel {


    public deleteteacheraccountpanel() {
        initComponents();
        tableinfo();
        
    }
Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textField4 = new textfield.TextField();

        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(1190, 630));

        scroll.setBackground(new java.awt.Color(0, 0, 0));
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scroll.setHorizontalScrollBar(sp);
        scroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        scroll.setToolTipText("");

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

        textField4.setLabelText("SEARCH NAME");
        textField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textField4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(967, Short.MAX_VALUE)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(568, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int Myindex = jTable1.getSelectedRow();
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete " + model.getValueAt(Myindex, 1).toString()+" "+model.getValueAt(Myindex, 2).toString(), "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

if (result == JOptionPane.YES_OPTION) {    
         deleteaccount();
}     
    }//GEN-LAST:event_jTable1MouseClicked

    private void textField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField4KeyPressed

    }//GEN-LAST:event_textField4KeyPressed

    private void textField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField4KeyReleased

        try {
            Connection Con = null;
            Statement St = null;
            ResultSet Rs = null;

            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");

            St = Con.createStatement();
            Rs = St.executeQuery("SELECT `teacher_id`as 'Teacher ID', `first_name` as 'First Name' , `last_name` as 'Last Name', `email` as 'Email', `address`as 'Address', `contact_num` as 'Contact Number',  `Course_code` as 'Course Code', `Course_Title` as 'Course Title', `birthday` as Birthday, `sex`as Sex  FROM `teacher` where first_name like '%'"+textField4.getText()+"'%'");

            jTable1.setModel(DbUtils.resultSetToTableModel(Rs));

            Rs.close();
            Con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_textField4KeyReleased
 public void tableinfo(){
    
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT `teacher_id`as 'Teacher ID', `first_name` as 'First Name' , `last_name` as 'Last Name', `email` as 'Email', `address`as 'Address', `contact_num` as 'Contact Number',  `Course_code` as 'Course Code', `Course_Title` as 'Course Title', `birthday` as Birthday, `sex`as Sex  FROM `teacher`");

            jTable1.setModel(DbUtils.resultSetToTableModel(Rs));

            System.out.println("Connection successfully loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    
    public void deleteaccount(){
      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int Myindex = jTable1.getSelectedRow();
         
        

            try {
                Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");

                String Query = "Delete from studentportal.teacher where teacher_id='" + model.getValueAt(Myindex, 0).toString() + "'";

                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);

                JOptionPane.showMessageDialog(null, "Teacher Information Deleted Successfully" );
             tableinfo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane scroll;
    private textfield.TextField textField4;
    // End of variables declaration//GEN-END:variables
}
