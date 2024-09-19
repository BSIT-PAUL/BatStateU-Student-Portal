package com.paul.student;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class printperSemgwa {

    public void myMethod(String textFieldValue, String textFieldValue3, String textFieldValue4, String textFieldValue7, String textFieldValue8, String textFieldValue9) throws BadElementException, FileNotFoundException, DocumentException, IOException, SQLException {

        Document document = new Document(PageSize.A4, 20, 20, 30, 0);

        String outputFileName = textFieldValue + "-viewgrades.pdf"; // concatenate the parameter value with ".pdf"
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFileName));

        String name = textFieldValue8; // replace with the actual name of the student
        String sex = textFieldValue9; // replace with the actual sex of the student
        String srcode = textFieldValue;

        String url = "jdbc:mysql://localhost:3306/studentportal";
        String user = "root";
        String password = "";

        Font red = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.RED);
        Font black = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
        Font boldblack = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.BLACK);
        Font normalblack = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
        Font uboldblack = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD | Font.UNDERLINE, BaseColor.BLACK);
        Font tableheaderblack = new Font(Font.FontFamily.TIMES_ROMAN, (float) 10.3, Font.BOLD, BaseColor.BLACK);
        Font totalboldblack = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.BLACK);
        Font uboldblackred = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD | Font.UNDERLINE, BaseColor.RED);
        document.open();

        PdfPageEventHelper pageEventHelper = new PdfPageEventHelper() {
            public void onStartPage(PdfWriter writer, Document document) {
                try {
                   final int MAX_Sex_LENGTH = 25;
                           final int MAX_srcode_LENGTH = 73;  
final int MAX_NAME_LENGTH = 68;

int nameLength = name.length();
int numSpaces = (MAX_NAME_LENGTH - nameLength) / 2;
String spacesBeforeName = " ".repeat(numSpaces);
String spacesAfterName = " ".repeat(MAX_NAME_LENGTH - nameLength - numSpaces);


int sexLength = sex.length();
int numSpaces2 = (MAX_Sex_LENGTH - sexLength) / 2;
String spacesBeforeSex = " ".repeat(numSpaces2);
String spacesAfterSex= " ".repeat(MAX_Sex_LENGTH - sexLength - numSpaces2);


int srcodeLength = srcode.length();
int numSpaces3 = (MAX_srcode_LENGTH - srcodeLength) / 2;
String spacesBeforeSr = " ".repeat(numSpaces3);
String spacesAftersex = " ".repeat(MAX_srcode_LENGTH - srcodeLength - numSpaces3);



Font normalblack = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
Paragraph header2 = new Paragraph();
Chunk nameLabel = new Chunk("Name:                    ", normalblack);
Chunk nameChunk = new Chunk(spacesBeforeName + name + spacesAfterName, uboldblack);
Chunk sexLabel = new Chunk("Sex: ", normalblack);
Chunk sexChunk = new Chunk(sex + spacesBeforeSex +spacesAfterSex, boldblack);
header2.add(nameLabel);
header2.add(nameChunk);
header2.add(new Chunk(new VerticalPositionMark()));
header2.add(sexLabel);
header2.add(sexChunk);
                    header2.setAlignment(Element.ALIGN_LEFT);
                    header2.setLeading(10);
                    header2.setSpacingAfter(10);
                    document.add(header2);

                    Paragraph header3 = new Paragraph("Student Number:   ", normalblack);
                    Chunk srChunk = new Chunk(spacesBeforeSr + srcode + spacesAftersex, uboldblack);
                    header3.add(srChunk);

                    header3.setAlignment(Element.ALIGN_LEFT);
                    header3.setLeading(8);
                    header3.setSpacingAfter(8);
                    Font tableheaderblack = new Font(Font.FontFamily.TIMES_ROMAN, (float) 10.4, Font.BOLD, BaseColor.BLACK);
                    document.add(header3);
                    PdfPTable table = new PdfPTable(7); // 7 columns.
                    table.setWidthPercentage(100); //Width 100%
                    table.setSpacingBefore(10f); //Space before table
                    table.setSpacingAfter(10f); //Space after table

                    //Set Column widths
                    float[] columnWidths = {1.50f, 2.50f, 4f, 1.25f, 1.50f, 2f, 2f};
                    table.setWidths(columnWidths);

                    PdfPCell cell1 = new PdfPCell(new Paragraph("Final \nGrade", tableheaderblack));
                    cell1.setBorderColor(BaseColor.BLACK);
                    cell1.setPaddingLeft(10);
                    cell1.setPaddingBottom(10);
                    cell1.setPaddingTop(10);
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell2 = new PdfPCell(new Paragraph("Course Code", tableheaderblack));
                    cell2.setBorderColor(BaseColor.BLACK);
                    cell2.setPaddingLeft(10);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell3 = new PdfPCell(new Paragraph("Course Title", tableheaderblack));
                    cell3.setBorderColor(BaseColor.BLACK);
                    cell3.setPaddingLeft(10);
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell4 = new PdfPCell(new Paragraph("Units", tableheaderblack));
                    cell4.setBorderColor(BaseColor.BLACK);
                    cell4.setPaddingLeft(10);
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

//nestedCell1.setPaddingBottom(10);
                    PdfPTable nestedTable = new PdfPTable(2); // 3 columns
                    nestedTable.setWidthPercentage(100);

                    PdfPCell nestedCell1 = new PdfPCell(new Paragraph("Hours", tableheaderblack));
                    nestedCell1.setBorderColor(BaseColor.BLACK);
                    nestedCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    nestedCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    nestedCell1.setPaddingLeft(5);
                    nestedCell1.setPaddingBottom(8);
                    nestedCell1.setPaddingTop(8);
                    nestedCell1.setColspan(2); // Merge with the next cell
                    nestedTable.addCell(nestedCell1);

                    PdfPCell lecLabelCell = new PdfPCell(new Paragraph("Lec", tableheaderblack));
                    lecLabelCell.setBorderColor(BaseColor.BLACK);
                    lecLabelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    lecLabelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    nestedTable.addCell(lecLabelCell);

                    PdfPCell labLabelCell = new PdfPCell(new Paragraph("Lab", tableheaderblack));
                    labLabelCell.setBorderColor(BaseColor.BLACK);

                    labLabelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    labLabelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    nestedTable.addCell(labLabelCell);

// Add an empty cell to align the Hours label with the Lec/Lab labels
                    PdfPCell emptyCell = new PdfPCell(new Phrase(""));
                    emptyCell.setBorder(Rectangle.NO_BORDER);
                    nestedTable.addCell(emptyCell);

                    PdfPCell cell5 = new PdfPCell(nestedTable);
                    cell5.setBorderColor(BaseColor.BLACK);

                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell6 = new PdfPCell(new Paragraph("Pre-Requisite/s", tableheaderblack));
                    cell6.setBorderColor(BaseColor.BLACK);
                    cell6.setPaddingLeft(10);
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell7 = new PdfPCell(new Paragraph("Co-Requisite/s", tableheaderblack));
                    cell7.setBorderColor(BaseColor.BLACK);
                    cell7.setPaddingLeft(10);
                    cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table.addCell(cell1);
                    table.addCell(cell2);
                    table.addCell(cell3);
                    table.addCell(cell4);
                    table.addCell(cell5);
                    table.addCell(cell6);
                    table.addCell(cell7);
                    
                    document.add(table);
                                        Paragraph header14 = new Paragraph("\n");
 document.add(header14);
                } catch (DocumentException ex) {
                    System.out.println(ex);                }
            }
        };
        writer.setPageEvent(pageEventHelper);

        // Add underline to the header 
        Image logo = Image.getInstance("C:\\Users\\ASUS ROG STRIX\\OneDrive\\Desktop\\New folder (2)\\BatStateULogo.png");
        logo.scaleAbsolute(100, 100);
        logo.setAbsolutePosition(30, PageSize.A4.getHeight() - 120);

        String headerText1 = "Republic of the Philippines";
        com.itextpdf.text.Paragraph headers1 = new com.itextpdf.text.Paragraph(headerText1, boldblack);
        headers1.setAlignment(Element.ALIGN_CENTER);
        headers1.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 11));
        headers1.setLeading(8);
        //headers1.setSpacingBefore(60);
        headers1.setIndentationLeft(60);
        headers1.setIndentationRight(60);
        document.add(headers1);

        String headerText2 = "BATANGAS STATE UNIVERSITY";
        com.itextpdf.text.Paragraph headers2 = new com.itextpdf.text.Paragraph(headerText2, black);
        headers2.setAlignment(Element.ALIGN_CENTER);

        headers2.setLeading(10);
        headers2.setSpacingBefore(10);
        headers2.setIndentationLeft(60);
        headers2.setIndentationRight(60);
        document.add(headers2);

        String headerText3 = "The National Engineering University";
        com.itextpdf.text.Paragraph headers3 = new com.itextpdf.text.Paragraph(headerText3, red);
        headers3.setAlignment(Element.ALIGN_CENTER);

        headers3.setLeading(8);
        headers3.setSpacingBefore(8);
        headers3.setIndentationLeft(60);
        headers3.setIndentationRight(60);
        document.add(headers3);

        String headerText4 = "ARASOF-Nasugbu Campus";
        com.itextpdf.text.Paragraph headers4 = new com.itextpdf.text.Paragraph(headerText4, boldblack);
        headers4.setAlignment(Element.ALIGN_CENTER);

        headers4.setLeading(8);
        headers4.setSpacingBefore(8);
        headers4.setIndentationLeft(60);
        headers4.setIndentationRight(60);
        document.add(headers4);

        String headerText5 = "R. Martinez St., Brgy. Bucana, Nasugbu, Batangas, Philippines 4231";
        com.itextpdf.text.Paragraph headers5 = new com.itextpdf.text.Paragraph(headerText5, boldblack);
        headers5.setAlignment(Element.ALIGN_CENTER);

        headers5.setLeading(8);
        headers5.setSpacingBefore(8);
        headers5.setIndentationLeft(60);
        headers5.setIndentationRight(60);
        document.add(headers5);

        String headerText6 = "Tel Nos. (+63 43) 416-0350";
        com.itextpdf.text.Paragraph headers6 = new com.itextpdf.text.Paragraph(headerText6, normalblack);
        headers6.setAlignment(Element.ALIGN_CENTER);

        headers6.setLeading(7);
        headers6.setSpacingBefore(7);
        headers6.setIndentationLeft(60);
        headers6.setIndentationRight(60);
        document.add(headers6);

        String headerText7 = "E-mail Address: cics.nasugbu@g.batstate-u.edu.ph | Website Address: http://www.batstate-u.edu.ph";
        com.itextpdf.text.Paragraph headers7 = new com.itextpdf.text.Paragraph(headerText7, normalblack);
        headers7.setAlignment(Element.ALIGN_CENTER);

        headers7.setLeading(7);
        headers7.setSpacingBefore(7);
        headers7.setIndentationLeft(20);
        headers7.setIndentationRight(20);
        document.add(headers7);

        PdfContentByte cb = writer.getDirectContent();
        cb.setLineWidth(2f); // set line width to 2 units
        cb.moveTo(document.left(), PageSize.A4.getHeight() - 140);
        cb.lineTo(document.right(), PageSize.A4.getHeight() - 140);
        cb.stroke();

        document.add(logo);

        String headerText8 = "\nCOLLEGE OF INFORMATICS AND COMPUTING SCIENCES";
        com.itextpdf.text.Paragraph headers8 = new com.itextpdf.text.Paragraph("\n" + headerText8, boldblack);
        headers8.setAlignment(Element.ALIGN_CENTER);
        headers8.setLeading(8);
        headers8.setSpacingBefore(8);
        headers8.setIndentationLeft(60);
        headers8.setIndentationRight(60);
        document.add(headers8);
        String outputFileName3 = textFieldValue3;
        //String headerText9 = "Bachelor of Science in Information Technology";
        com.itextpdf.text.Paragraph headers9 = new com.itextpdf.text.Paragraph(outputFileName3, boldblack);
        headers9.setAlignment(Element.ALIGN_CENTER);
        headers9.setLeading(8);
        headers9.setSpacingBefore(8);
        headers9.setIndentationLeft(60);
        headers9.setIndentationRight(60);
        document.add(headers9);
        String outputFileName4 = textFieldValue4;
        //String headerText10 = "NETWORK TECHNOLOGY TRACK";

        com.itextpdf.text.Paragraph headers10 = new com.itextpdf.text.Paragraph(outputFileName4, uboldblack);
        headers10.setAlignment(Element.ALIGN_CENTER);
        headers10.setLeading(8);

        headers10.setSpacingBefore(8);
        headers10.setIndentationLeft(60);
        headers10.setIndentationRight(60);
        document.add(headers10);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date d = new Date();
        String currentYear = sdf.format(d);
        String nextYear = String.valueOf(Integer.parseInt(currentYear) - 1);
        String academicYear = nextYear + "-" + currentYear;

        com.itextpdf.text.Paragraph headers11 = new com.itextpdf.text.Paragraph("Academic Year " + academicYear, normalblack);
        headers11.setAlignment(Element.ALIGN_CENTER);
        headers11.setLeading(8);
        headers11.setSpacingBefore(8);
        headers11.setIndentationLeft(60);
        headers11.setIndentationRight(60);
        document.add(headers11);
        String outputFileName7 = textFieldValue7;
        // String texts = "CMO No. 25 series of 2015, CMO No. 4 series of 2018, CMO No. 20 series of 2013";
        String headerText12 = "Reference: ";

// Define the font styles for the reference and text parts separately
        com.itextpdf.text.Font boldFont = new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 11, com.itextpdf.text.Font.BOLD);
        com.itextpdf.text.Font normalFont = new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 11, com.itextpdf.text.Font.NORMAL);

// Create a Phrase object to hold the entire header text
        com.itextpdf.text.Phrase headerPhrase = new com.itextpdf.text.Phrase();

// Add the reference text with normal font style to the Phrase object
        headerPhrase.add(new com.itextpdf.text.Chunk(headerText12, normalFont));

// Split the texts string into individual items and add each item with bold font style to the Phrase object
        String[] textItems = outputFileName7.split(", ");
        for (int i = 0; i < textItems.length; i++) {
            if (i != textItems.length - 1) {
                headerPhrase.add(new com.itextpdf.text.Chunk(textItems[i] + ", ", boldFont));
            } else {
                headerPhrase.add(new com.itextpdf.text.Chunk(textItems[i], boldFont));
            }
        }

        // Add the completed header text to a Paragraph object
        com.itextpdf.text.Paragraph headers12 = new com.itextpdf.text.Paragraph(headerPhrase);
        headers12.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        headers12.setSpacingAfter(10);
        document.add(headers12);

        final int MAX_Sex_LENGTH = 25;
                           final int MAX_srcode_LENGTH = 73;  
final int MAX_NAME_LENGTH = 68;

int nameLength = name.length();
int numSpaces = (MAX_NAME_LENGTH - nameLength) / 2;
String spacesBeforeName = " ".repeat(numSpaces);
String spacesAfterName = " ".repeat(MAX_NAME_LENGTH - nameLength - numSpaces);


int sexLength = sex.length();
int numSpaces2 = (MAX_Sex_LENGTH - sexLength) / 2;
String spacesBeforeSex = " ".repeat(numSpaces2);
String spacesAfterSex= " ".repeat(MAX_Sex_LENGTH - sexLength - numSpaces2);


int srcodeLength = srcode.length();
int numSpaces3 = (MAX_srcode_LENGTH - srcodeLength) / 2;
String spacesBeforeSr = " ".repeat(numSpaces3);
String spacesAftersex = " ".repeat(MAX_srcode_LENGTH - srcodeLength - numSpaces3);



Paragraph header2 = new Paragraph();
Chunk nameLabel = new Chunk("Name:                    ", normalblack);
Chunk nameChunk = new Chunk(spacesBeforeName + name + spacesAfterName, uboldblack);
Chunk sexLabel = new Chunk("Sex: ", normalblack);
Chunk sexChunk = new Chunk( sex + spacesBeforeSex +spacesAfterSex, boldblack);
header2.add(nameLabel);
header2.add(nameChunk);
header2.add(new Chunk(new VerticalPositionMark()));
header2.add(sexLabel);
header2.add(sexChunk);
                    header2.setAlignment(Element.ALIGN_LEFT);
                    header2.setLeading(10);
                    header2.setSpacingAfter(10);
                    document.add(header2);

                    Paragraph header3 = new Paragraph("Student Number:   ", normalblack);
                    Chunk srChunk = new Chunk(spacesBeforeSr + srcode + spacesAftersex, uboldblack);
                    header3.add(srChunk);

                    header3.setAlignment(Element.ALIGN_LEFT);
                    header3.setLeading(8);
                    header3.setSpacingAfter(8);
                    document.add(header3);
        PdfPTable table = new PdfPTable(7); // 7 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table

        //Set Column widths
        float[] columnWidths = {1.50f, 2.50f, 4f, 1.25f, 1.50f, 2f, 2f};
        table.setWidths(columnWidths);

        PdfPCell cell1 = new PdfPCell(new Paragraph("Final \nGrade", tableheaderblack));
        cell1.setBorderColor(BaseColor.BLACK);
        cell1.setPaddingLeft(10);
        cell1.setPaddingBottom(10);
        cell1.setPaddingTop(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell2 = new PdfPCell(new Paragraph("Course Code", tableheaderblack));
        cell2.setBorderColor(BaseColor.BLACK);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell3 = new PdfPCell(new Paragraph("Course Title", tableheaderblack));
        cell3.setBorderColor(BaseColor.BLACK);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell4 = new PdfPCell(new Paragraph("Units", tableheaderblack));
        cell4.setBorderColor(BaseColor.BLACK);
        cell4.setPaddingLeft(10);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

//nestedCell1.setPaddingBottom(10);
        PdfPTable nestedTable = new PdfPTable(2); // 2 columns
        nestedTable.setWidthPercentage(100);

        PdfPCell nestedCell1 = new PdfPCell(new Paragraph("Hours", tableheaderblack));
        nestedCell1.setBorderColor(BaseColor.BLACK);
        nestedCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        nestedCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nestedCell1.setPaddingLeft(5);
        nestedCell1.setPaddingBottom(7);
        nestedCell1.setPaddingTop(7);
        nestedCell1.setColspan(2); // Merge with the next cell
        nestedTable.addCell(nestedCell1);

        PdfPCell lecLabelCell = new PdfPCell(new Paragraph("Lec", tableheaderblack));
        lecLabelCell.setBorderColor(BaseColor.BLACK);
        lecLabelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        lecLabelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        nestedTable.addCell(lecLabelCell);

        PdfPCell labLabelCell = new PdfPCell(new Paragraph("Lab", tableheaderblack));
        labLabelCell.setBorderColor(BaseColor.BLACK);

        labLabelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        labLabelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nestedTable.addCell(labLabelCell);

// Add an empty cell to align the Hours label with the Lec/Lab labels
        PdfPCell emptyCell = new PdfPCell(new Phrase(""));
        emptyCell.setBorder(Rectangle.NO_BORDER);
        nestedTable.addCell(emptyCell);

        PdfPCell cell5 = new PdfPCell(nestedTable);
        cell5.setBorderColor(BaseColor.BLACK);

        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell6 = new PdfPCell(new Paragraph("Pre-Requisite/s", tableheaderblack));
        cell6.setBorderColor(BaseColor.BLACK);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell cell7 = new PdfPCell(new Paragraph("Co-Requisite/s", tableheaderblack));
        cell7.setBorderColor(BaseColor.BLACK);
        cell7.setPaddingLeft(10);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        document.add(table);

        String sql = "SELECT DISTINCT * FROM studentfinalgrades WHERE  years = ? and semester = ?  and SR_Code='" + srcode + "' ORDER BY course_code"; // add an ORDER BY clause to sort the results by course code

// establish database connection
        Connection conn = DriverManager.getConnection(url, user, password);
        //  int i = 0; // variables to keep track of the totals

// set up year loop
        String[] years = {"FIRST YEAR", "SECOND YEAR", "THIRD YEAR", "FOURTH YEAR"};
        String[] semesters = {"First Semester", "Second Semester", "Mid Term"};
        for (String year : years) {

            // set up semester loop
            for (String semester : semesters) {
                // add semester heading to document

                PdfPTable table2 = new PdfPTable(8);
                table2.setWidthPercentage(100);
                table2.setSpacingBefore(10f);
                table2.setSpacingAfter(10f);
                float[] columnWidths2 = {1.50f, 2.50f, 4f, 1.25f, 0.75f, 0.75f, 2f, 2f};
                table2.setWidths(columnWidths2);

                // execute SQL query for current year and semester
                PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
                stmt.setString(1, year);
                stmt.setString(2, semester);
                ResultSet rs = stmt.executeQuery();

                int totalUnits = 0;
                int totalLec = 0;
                int totalLab = 0;
                double gwa = 0;

                if (rs.next()) {
                    if (semester.equals("Mid Term")) {
                        Paragraph semesterHeading = new Paragraph(semester, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
                        semesterHeading.setAlignment(Element.ALIGN_CENTER);
                        document.add(semesterHeading);
                    } else {
                        Paragraph semesterHeading = new Paragraph(year + "\n" + semester, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
                        semesterHeading.setAlignment(Element.ALIGN_CENTER);
                        document.add(semesterHeading);
                    }
// iterate over result set and add data to table
                    do {
                        // iterate over result set and add data to table

                        // set up table
                        String finalGrade = rs.getString("final_grade");
                        String gradeText = finalGrade.equals("0.00") ? "_______" : finalGrade;
                        if (finalGrade.equalsIgnoreCase("Inc") || finalGrade.equalsIgnoreCase("Drop") || finalGrade.equalsIgnoreCase("5.00") || finalGrade.equalsIgnoreCase("4.00")) {
                            PdfPCell subcell1 = new PdfPCell(new Phrase(gradeText, uboldblackred));
                            subcell1.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                            subcell1.setHorizontalAlignment(Element.ALIGN_CENTER);

                            subcell1.setNoWrap(false); // allow content to wrap

                            table2.addCell(subcell1);
                        } else {
                            PdfPCell subcell1 = new PdfPCell(new Phrase(gradeText, uboldblack));
                            subcell1.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                            subcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                            subcell1.setNoWrap(false); // allow content to wrap
                            table2.addCell(subcell1);
                        }

                        PdfPCell subcell2 = new PdfPCell(new Phrase(rs.getString("course_code"), normalblack));
                        subcell2.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell2.setHorizontalAlignment(Element.ALIGN_CENTER);

                        table2.addCell(subcell2);

                        PdfPCell subcell3 = new PdfPCell(new Phrase(rs.getString("course_title"), normalblack));
                        subcell3.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell3.setHorizontalAlignment(Element.ALIGN_LEFT);

                        table2.addCell(subcell3);

                        PdfPCell subcell24 = new PdfPCell(new Phrase(rs.getString("unit"), normalblack));
                        subcell24.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell24.setHorizontalAlignment(Element.ALIGN_CENTER);

                        table2.addCell(subcell24);

                        PdfPCell subcell5 = new PdfPCell(new Phrase(rs.getString("lec"), normalblack));

                        subcell5.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell5.setHorizontalAlignment(Element.ALIGN_CENTER);

                        table2.addCell(subcell5);

                        String lab = rs.getString("lab");
                        String labtext = lab.equals("0") ? "-" : lab;
                        PdfPCell subcell6 = new PdfPCell(new Phrase(labtext, normalblack));
                        subcell6.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(subcell6);

                        PdfPCell subcell7 = new PdfPCell(new Phrase(rs.getString("prerequisite"), normalblack));
                        subcell7.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell7.setHorizontalAlignment(Element.ALIGN_CENTER);

                        table2.addCell(subcell7);
                        PdfPCell subcell8 = new PdfPCell(new Phrase(rs.getString("corequisite"), normalblack));
                        //subcell8.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcell8.setBorderWidth(0);
                        subcell8.setHorizontalAlignment(Element.ALIGN_CENTER);

                        table2.addCell(subcell8);

                        // update total values
                        int unit = rs.getInt("unit");
                        int lec = rs.getInt("lec");
                        int labs = rs.getInt("lab");
                        totalUnits += unit;
                        totalLec += lec;
                        totalLab += labs;

                        String finalGradeString = rs.getString("final_grade");
                        double finalGrades = 0.0;

                        if (finalGradeString.equalsIgnoreCase("inc") || finalGradeString.equalsIgnoreCase("drop")) {
                            finalGrades = 0.0;
                        } else {
                            String[] parts = finalGradeString.split("/");
                            String lastPart = parts[parts.length - 1].trim();
                            if (!lastPart.isEmpty()) {
                                finalGrades = Double.parseDouble(lastPart);
                            }
                        }
                        gwa += (finalGrades * unit);
                    } while (rs.next());

                    // add row for total values
                   double gwaPerUnit = gwa / totalUnits;
String formattedGwaPerUnit = String.format("%.2f", gwaPerUnit);
                    if (formattedGwaPerUnit == "0") {

                        PdfPCell subcellss1 = new PdfPCell(new Phrase("", totalboldblack));

                        subcellss1.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcellss1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(subcellss1);
                    } else {
                        PdfPCell subcellss1 = new PdfPCell(new Phrase(formattedGwaPerUnit, totalboldblack));

                        subcellss1.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                        subcellss1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(subcellss1);
                    }

                    PdfPCell subcellss2 = new PdfPCell(new Phrase("", normalblack));
                    subcellss2.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss2);

                    PdfPCell subcellss3 = new PdfPCell(new Phrase("Total", totalboldblack));
                    subcellss3.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss3);

                    PdfPCell subcellss4 = new PdfPCell(new Phrase(String.valueOf(totalUnits), totalboldblack));
                    subcellss4.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss4);

                    PdfPCell subcellss5 = new PdfPCell(new Phrase(String.valueOf(totalLec), totalboldblack));
                    subcellss5.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss5);

                    PdfPCell subcellss6 = new PdfPCell(new Phrase(String.valueOf(totalLab), totalboldblack));
                    subcellss6.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss6);

                    PdfPCell subcellss7 = new PdfPCell(new Phrase("", normalblack));
                    subcellss7.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss7.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss7);

                    PdfPCell subcellss8 = new PdfPCell(new Phrase("", normalblack));
                    subcellss8.setBorder(com.lowagie.text.Rectangle.NO_BORDER);
                    subcellss8.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table2.addCell(subcellss8);

                    // add table to document
                    document.add(table2);

                }
            }
        }
 //  File outputFile = new File(outputFileName);
    //    Desktop.getDesktop().open(outputFile);
        System.out.println("PDF GENERATED SUCCESSFULLY");
        document.close();
    }
}
