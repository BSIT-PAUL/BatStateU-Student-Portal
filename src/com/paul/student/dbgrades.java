package com.paul.student;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.paul.admin.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JScrollBar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import scrollbar.ScrollBarCustom;

public class dbgrades extends javax.swing.JPanel {

    /**
     * Creates new form addaccountpanel
     */
    public dbgrades() {
        initComponents();
        showLineChart();

searchStudentinfo();

    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date d = new Date();
 public void searchStudentinfo() {

        try {

            Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("SELECT Distinct studentfinalgrades.`final_grade` AS `Final Grade`, studentfinalgrades.`course_code` AS `Course Code`, studentfinalgrades.`course_title` AS `Course Title`, studentfinalgrades.`Semester`, studentfinalgrades.`Years`, CONCAT(teacher.`first_name`, ' ', teacher.`last_name`) AS `Teacher Name` FROM `studentfinalgrades` LEFT JOIN `teacher` ON studentfinalgrades.course_code = teacher.Course_code  WHERE studentfinalgrades.SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 )");

            jTable1.setModel(DbUtils.resultSetToTableModel(Rs));
            TableColumnModel columnModel = jTable1.getColumnModel();
            TableColumn gradeColumn = columnModel.getColumn(0);
            gradeColumn.setCellRenderer(new MyTableCellRenderer());
            System.out.println("Dashboard Connection successfully loaded.");
       
            Con.close();
            Rs.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
       
    }
    /*=============================================================================*/
    public void showLineChart() {
        String url = "jdbc:mysql://localhost:3306/studentportal";
        String user = "root";
        String password = "";

        try (Connection con = (Connection) DriverManager.getConnection(url, user, password); PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT count(*) as count_of_grades,final_grade FROM `studentfinalgrades` WHERE SR_Code=(SELECT Username FROM `login` WHERE `Date` ='"+sdf.format(d)+"' ORDER BY `Time` DESC LIMIT 1 ) group by final_grade"); ResultSet result = statement.executeQuery()) {

            // Map to store final_grade and its corresponding index in the data array
            Map<String, Integer> gradeIndexMap = new HashMap<>();
            gradeIndexMap.put("1.00", 0);
            gradeIndexMap.put("1.25", 1);
            gradeIndexMap.put("1.50", 2);
            gradeIndexMap.put("1.75", 3);
            gradeIndexMap.put("2.00", 4);
            gradeIndexMap.put("2.25", 5);
            gradeIndexMap.put("2.50", 6);
            gradeIndexMap.put("2.75", 7);
            gradeIndexMap.put("3.00", 8);
            gradeIndexMap.put("Inc", 9);
            gradeIndexMap.put("Drop", 10);
            gradeIndexMap.put("Failed", 11);

            // Populate the data array dynamically based on the maximum index in the gradeIndexMap
            double[] data = new double[gradeIndexMap.values().stream().max(Integer::compare).orElse(0) + 1];

            while (result.next()) {
                String grades = result.getString("final_grade");
                int count = result.getInt("count_of_grades");
                System.out.println(grades + ": " + count);
                Integer index = gradeIndexMap.get(grades);
                if (index != null) {
                    data[index] = count;
                }
            }

            //create dataset for the graph
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            gradeIndexMap.forEach((grades, index) -> dataset.setValue(data[index], "Grades", grades));

            //create chart
            JFreeChart linechart = ChartFactory.createLineChart("Overall Total Grades", "Grades", "Count",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            //customize chart
            CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
            lineCategoryPlot.setBackgroundPaint(Color.white);
            LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
            Color lineChartColor = new Color(204, 0, 51);
            lineRenderer.setSeriesPaint(0, lineChartColor);

            //create chartPanel to display chart(graph)
            ChartPanel lineChartPanel = new ChartPanel(linechart);
            panelLineChart.removeAll();
            panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
            panelLineChart.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLineChart = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 153, 153));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1190, 630));

        panelLineChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelLineChart.setLayout(new java.awt.BorderLayout());

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
                    .addComponent(scroll))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
