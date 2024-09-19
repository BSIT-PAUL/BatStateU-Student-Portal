
package com.paul.teacher;


import com.paul.admin.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
    public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
      //  panelLineChart.removeAll();
    //    panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
      //  panelLineChart.validate();
    }

    /*========================================================================================*/
    
    public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
       // jPanel3.removeAll();
      //  jPanel3.add(barpChartPanel2, BorderLayout.CENTER);
       // jPanel3.validate();
    }

    /*========================================================================================*/
    
    public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
       // panelBarChart.removeAll();
       // panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
       // panelBarChart.validate();
        
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPieChart = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1190, 630));

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
