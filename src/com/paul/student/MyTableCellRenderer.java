package com.paul.student;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Object val = table.getValueAt(row, column);

        for (int i = 0; i < table.getColumnCount(); i++) {
            if (i != column && val.equals(table.getValueAt(row, i))) {
                c.setForeground(table.getForeground());
                return c;
            }
        }
if (val != null) {
    String[] values = val.toString().trim().split(",");
    if (values.length > 0) {
        String lastValue = values[values.length - 1];
        if (lastValue.trim().equals("3")) {
            c.setForeground(Color.BLACK);
        } else if (lastValue.trim().equals("5.00") || lastValue.trim().equals("4.00") || lastValue.trim().equalsIgnoreCase("INC") || lastValue.trim().equalsIgnoreCase("Drop")) {
            c.setForeground(Color.RED);
        } else {
            c.setForeground(table.getForeground());
        }
    } else {
        c.setForeground(table.getForeground());
    }
} else {
    c.setForeground(table.getForeground());
}     
        return c;
    }
}