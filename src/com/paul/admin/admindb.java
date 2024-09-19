
package com.paul.admin;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;


public class admindb extends javax.swing.JPanel {

    /**
     * Creates new form addaccountpanel
     */
    public admindb() {
        initComponents();
piechartdata();


    }

            Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

        public void piechartdata() {

        try {
            Con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studentportal", "root", "");
            St = (Statement) Con.createStatement();
            String query = "SELECT count(Name) as count_of_excellent_grades,yearLevel FROM `student` group by yearLevel";

// Assuming you have established a database connection
            PreparedStatement statement = (PreparedStatement) Con.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            double[] data = new double[4];
            while (result.next()) {
                String year = result.getString("yearLevel");
                int count = result.getInt("count_of_excellent_grades");
                System.out.println(year + ": " + count);
                switch (year) {

                    case "First Year":
                        data[0] = count;
                        break;
                    case "Second Year":
                        data[1] = count;
                        break;
                    case "Third Year":
                        data[2] = count;
                        break;
                    case "Fourth Year":
                        data[3] = count;
                        break;
                }

            }      DefaultPieDataset barDataset = new DefaultPieDataset( );
  
            barDataset.setValue( "First Year" , new Double( data[0] ) );  
      barDataset.setValue( "Second Year" , new Double( data[1] ) );   
      barDataset.setValue( "Third Year" , new Double( data[2] ) );    
      barDataset.setValue( "Fourth Year" , new Double( data[3] ) ); 
 //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Number Of Students",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("First Year", new Color(255,255,102));
        piePlot.setSectionPaint("Second Year", new Color(102,255,102));
        piePlot.setSectionPaint("Third Year", new Color(255,102,153));
        piePlot.setSectionPaint("Fourth Year", new Color(0,204,204));
     
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
      panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    /*=============================================================================*/
    
  
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPieChart = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1190, 630));

        panelPieChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPieChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
