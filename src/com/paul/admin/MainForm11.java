/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.paul.admin;

import com.paul.gui.login;
import com.paul.student.viewstudentpersonalinfo;
import com.paul.teacher.addStudentInformationpanel;
import com.paul.teacher.addstudentgrades;
import com.paul.teacher.updateStudentInformationpanel;
import com.paul.teacher.viewstudentpanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import menu.MenuItem;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author ASUS ROG STRIX
 */
public class MainForm11 extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    Color DefaultColor, ClickedColor;

    public MainForm11() {
        initComponents();
        dt();
        // menu1 a = new menu1();
        DefaultColor = new Color(0, 0, 0);
        ClickedColor = new Color(51, 51, 51);
        execute();
        //Menu8.setBackground(DefaultColor);
        panelBody.add(new admindb());

    }

    private void execute() {
        ImageIcon icon = new ImageIcon("C:\\Users\\ASUS ROG STRIX\\OneDrive\\Desktop\\student_portal.png");
        int labelWidth = jLabel1.getWidth();
        int labelHeight = jLabel1.getHeight();
        if (labelWidth != 0 && labelHeight != 0) {
            Image img = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            jLabel1.setIcon(new ImageIcon(img));
        }

        ImageIcon iconStaff = new ImageIcon(getClass().getResource("/menu/user.png"));
        ImageIcon iconSetting = new ImageIcon(getClass().getResource("/menu/setting.png"));
        ImageIcon iconDatabase = new ImageIcon(getClass().getResource("/menu/database.png"));
        ImageIcon iconMessage = new ImageIcon(getClass().getResource("/menu/message.png"));
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/menu/subMenu.png"));
        ImageIcon iconNext = new ImageIcon(getClass().getResource("/menu/next.png"));
        ImageIcon iconDashboard = new ImageIcon(getClass().getResource("/menu/0.png"));
        //  create submenu staff

        MenuItem menustudentAcc1 = new MenuItem(iconSubMenu, "View Students", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new com.paul.admin.viewstudentpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menustudentAcc2 = new MenuItem(iconSubMenu, "Add Student Information", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new com.paul.admin.addStudentInformationpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menustudentAcc3 = new MenuItem(iconSubMenu, "Update Student Information", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new com.paul.admin.updateStudentInformationpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menustudentAcc4 = new MenuItem(iconSubMenu, "Delete Student Information", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new deletestudentinformation());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menuAcc1 = new MenuItem(iconSubMenu, "View Account", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new viewaccountpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuAcc2 = new MenuItem(iconSubMenu, "Add Account", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new addaccountpanel());
                // menuAcc1.setForeground(ClickedColor); 

                clicked = !clicked;
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuAcc3 = new MenuItem(iconSubMenu, "Update Account", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new updateaccountpanel());

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuAcc4 = new MenuItem(iconSubMenu, "Delete Account", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {

                panelBody.removeAll();
                panelBody.add(new deleteaccountpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem accsetting1 = new MenuItem(iconNext, "Add Personal Details", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new addpersonalinfo());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem accsetting2 = new MenuItem(iconNext, "Update Personal Details", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new editpersonalinfo());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        //  create submenu setting 
        MenuItem menuSetting1 = new MenuItem(iconSubMenu, "View Personal Details", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new viewpersonalinfo());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menuSettingMessage = new MenuItem(iconMessage, "Account Setting", null, accsetting1, accsetting2);

        MenuItem menuDashboard1 = new MenuItem(iconDashboard, "Pie Chart", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new admindb());

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menuEnrollment1 = new MenuItem(iconSubMenu, "Student Enrollment", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new enrollmentadminpanel());

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menuGrades = new MenuItem(iconStaff, "Grades Management", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new addstudentgradesadmin());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuteacherAcc1 = new MenuItem(iconSubMenu, "View Teachers", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new viewsteacherpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuteacherAcc2 = new MenuItem(iconSubMenu, "Delete Teachers", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new deleteteacheraccountpanel());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuteacherAcc3 = new MenuItem(iconSubMenu, "Edit Teachers", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new editteacherpersonalinfo());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menugenerate = new MenuItem(iconSubMenu, "Generate PDF Grades", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new admingenerategrades());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuPrint = new MenuItem(iconSubMenu, "Print Student Grades", new ActionListener() {
            private boolean clicked = false;

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new adminprintgrades());
                // menuAcc1.setForeground(ClickedColor); 

                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuDashboard = new MenuItem(iconDashboard, "Dashboard ", null, menuDashboard1);
        MenuItem menuEnrollment = new MenuItem(iconStaff, "Enrollment ", null, menuEnrollment1);
        MenuItem menudstudentAcc = new MenuItem(iconStaff, "Student Information Management", null, menustudentAcc1, menustudentAcc2, menustudentAcc3, menustudentAcc4);
        MenuItem menudteacherAcc = new MenuItem(iconStaff, "Teacher Information Management", null, menuteacherAcc1, menuteacherAcc3, menuteacherAcc2);

        MenuItem menuAcc = new MenuItem(iconStaff, "Account Management", null, menuAcc1, menuAcc2, menuAcc3, menuAcc4);
        MenuItem menuSetting = new MenuItem(iconSetting, "Admin Setting", null, menuSetting1, menuSettingMessage);
        MenuItem menuDatabase = new MenuItem(iconDatabase, "Print Grades", null, menugenerate, menuPrint);
        addMenu(menuDashboard, menuAcc, menudstudentAcc, menudteacherAcc, menuEnrollment, menuGrades, menuSetting, menuDatabase);// Create a JLabel to hold the logo image

        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ASUS ROG STRIX\\OneDrive\\Desktop\\icons8-logout-rounded-24.png"));
        JLabel textLabel = new JLabel("LOGOUT");

// Create a new BoxLayout with a vertical axis
        BoxLayout boxLayout = new BoxLayout(menus, BoxLayout.Y_AXIS);

// Set the layout of the menus panel to the BoxLayout
        menus.setLayout(boxLayout);

// Create a horizontal Box container for the logo and text labels
        Box hbox = Box.createHorizontalBox();
        hbox.add(Box.createHorizontalGlue());
        hbox.add(logoLabel);
        hbox.add(Box.createHorizontalStrut(10));
        hbox.add(textLabel);
        hbox.add(Box.createHorizontalGlue());
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to Signout?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                    login lg = new login();
                    lg.setVisible(true);
                }
            }
        });
// Add the horizontal Box container to the vertical BoxLayout
        menus.add(Box.createVerticalGlue());
        menus.add(hbox);
        menus.add(Box.createVerticalGlue());
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scroll.setHorizontalScrollBar(sp);
        scroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        menus.setBackground(new java.awt.Color(248, 249, 250));
        menus.setBorder(null);
        menus.setAutoscrolls(true);
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        scroll.setViewportView(menus);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 250, 460));

        panelBody.setBackground(new java.awt.Color(153, 153, 153));
        panelBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 1190, 640));

        jPanel1.setBackground(new java.awt.Color(248, 249, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1438, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 160));

        jPanel2.setBackground(new java.awt.Color(248, 249, 250));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS ROG STRIX\\Downloads\\working-with-computer.png")); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Admin");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel7)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 180));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 private void dt() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Establish database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");

            stmt = con.prepareStatement("SELECT first_name,last_name FROM `admin` WHERE user_id=(SELECT `user_id` FROM `users` WHERE username=(SELECT Username FROM `login` WHERE `Date` =? ORDER BY `Time` DESC LIMIT 1))");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = new Date();

            stmt.setString(1, sdf.format(d)); // replace with actual time value

            // Execute the query and retrieve the result set
            rs = stmt.executeQuery();
            // Process the result set
            if (rs.next()) {
                // Retrieve the value of the Username column from the current row
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                // Set the text of the JLabel to the username
                jLabel8.setText("Logged in as: " + firstname + " " + lastname);
            } else {
                // No rows were returned, so set the text of the JLabel to indicate that
                jLabel8.setText("No user found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
